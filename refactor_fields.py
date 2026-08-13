#!/usr/bin/env python3
"""
Refactor Java model classes: public fields -> private fields + getter.
Existing setters are preserved. Missing getters are added.
"""
import re
import os
import glob

BUSINESS_DIR = r"D:\wangxun\workspace\cloud-sdk\cloud-sdk-api\src\main\java\com\chuanglan\cloudsdk\api\api\business"

# Skip Client/Config/CommonResponse - already handled
SKIP_FILES = {"BusinessClient.java", "BusinessConfig.java", "BusinessCommonResponse.java"}

# Match: public Type fieldName;  (with optional generics like List<String>)
FIELD_PATTERN = re.compile(
    r'^(\s*)(public)\s+([\w<>,\s\?]+?)\s+(\w+)\s*;(.*)$'
)

# Match: public ClassName setFieldName(Type fieldName) {
SETTER_PATTERN = re.compile(
    r'^\s*public\s+\w+\s+set(\w+)\s*\('
)

def capitalize(s):
    return s[0].upper() + s[1:] if s else s

def generate_getter(indent, field_type, field_name):
    getter_name = "get" + capitalize(field_name)
    return f"\n{indent}public {field_type} {getter_name}() {{\n{indent}    return this.{field_name};\n{indent}}}\n"

def process_file(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()

    lines = content.split('\n')

    # Collect field info
    fields = []  # (field_name, field_type, line_index)
    existing_getters = set()
    existing_setters = set()

    for i, line in enumerate(lines):
        m = FIELD_PATTERN.match(line)
        if m:
            indent, _, field_type, field_name, trailing = m.groups()
            # Skip static/final fields
            if 'static' in line or 'final' in line:
                continue
            # Skip if inside a method (indented more than class level)
            fields.append((field_name, field_type.strip(), i, indent))

        # Check for existing getter
        getter_match = re.match(r'^\s*public\s+[\w<>,\s\?]+?\s+get(\w+)\s*\(', line)
        if getter_match:
            existing_getters.add(getter_match.group(1).lower())

        setter_match = SETTER_PATTERN.match(line)
        if setter_match:
            existing_setters.add(setter_match.group(1).lower())

    if not fields:
        return False

    # Step 1: Change public -> private for fields
    new_lines = list(lines)
    for field_name, field_type, line_idx, indent in fields:
        new_lines[line_idx] = new_lines[line_idx].replace('public ' + field_type, 'private ' + field_type, 1)

    # Step 2: Add missing getters before the closing brace of class
    getters_to_add = []
    for field_name, field_type, line_idx, indent in fields:
        if field_name.lower() not in existing_getters:
            getters_to_add.append(generate_getter(indent, field_type, field_name))

    if getters_to_add:
        # Find last closing brace (class end)
        last_brace_idx = None
        for i in range(len(new_lines) - 1, -1, -1):
            if new_lines[i].strip() == '}':
                last_brace_idx = i
                break

        if last_brace_idx is not None:
            # Insert getters before last }
            getter_block = ''.join(getters_to_add)
            new_lines.insert(last_brace_idx, getter_block.rstrip('\n'))

    new_content = '\n'.join(new_lines)

    if new_content != content:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(new_content)
        return True
    return False

def main():
    files = glob.glob(os.path.join(BUSINESS_DIR, "*.java"))
    modified = 0
    for filepath in sorted(files):
        filename = os.path.basename(filepath)
        if filename in SKIP_FILES:
            continue
        if process_file(filepath):
            modified += 1
            print(f"  Modified: {filename}")
    print(f"\nTotal: {modified} files modified")

if __name__ == "__main__":
    main()
