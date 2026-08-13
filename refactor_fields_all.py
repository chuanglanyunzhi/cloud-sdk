#!/usr/bin/env python3
"""
Refactor ALL Java model/config classes in cloud-sdk-api:
public fields -> private/protected fields + getter (if missing).
Existing setters are preserved.
"""
import re
import os
import glob

BASE_DIR = r"D:\wangxun\workspace\cloud-sdk\cloud-sdk-api\src\main\java"

# Already handled
SKIP_FILES = {"BusinessClient.java", "BusinessConfig.java", "BusinessCommonResponse.java",
              "ApiClient.java", "ApiConfig.java", "ApiCommonResponse.java"}

# Files in business/ already done by previous script - skip them too
BUSINESS_DIR = os.path.join(BASE_DIR, "com", "chuanglan", "cloudsdk", "api", "api", "business")

FIELD_PATTERN = re.compile(
    r'^(\s*)(public)\s+([\w<>,\s\?]+?)\s+(\w+)\s*;(.*)$'
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

    fields = []
    existing_getters = set()

    for i, line in enumerate(lines):
        m = FIELD_PATTERN.match(line)
        if m:
            indent, _, field_type, field_name, trailing = m.groups()
            if 'static' in line or 'final' in line:
                continue
            fields.append((field_name, field_type.strip(), i, indent))

        getter_match = re.match(r'^\s*public\s+[\w<>,\s\?]+?\s+get(\w+)\s*\(', line)
        if getter_match:
            existing_getters.add(getter_match.group(1).lower())
        # Also check isXxx pattern
        is_match = re.match(r'^\s*public\s+boolean\s+is(\w+)\s*\(', line)
        if is_match:
            existing_getters.add(is_match.group(1).lower())

    if not fields:
        return False

    new_lines = list(lines)
    for field_name, field_type, line_idx, indent in fields:
        new_lines[line_idx] = new_lines[line_idx].replace('public ' + field_type, 'private ' + field_type, 1)

    getters_to_add = []
    for field_name, field_type, line_idx, indent in fields:
        if field_name.lower() not in existing_getters:
            getters_to_add.append(generate_getter(indent, field_type, field_name))

    if getters_to_add:
        last_brace_idx = None
        for i in range(len(new_lines) - 1, -1, -1):
            if new_lines[i].strip() == '}':
                last_brace_idx = i
                break
        if last_brace_idx is not None:
            getter_block = ''.join(getters_to_add)
            new_lines.insert(last_brace_idx, getter_block.rstrip('\n'))

    new_content = '\n'.join(new_lines)
    if new_content != content:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(new_content)
        return True
    return False

def main():
    files = glob.glob(os.path.join(BASE_DIR, "**", "*.java"), recursive=True)
    modified = 0
    for filepath in sorted(files):
        filename = os.path.basename(filepath)
        if filename in SKIP_FILES:
            continue
        # Skip business/ dir (already processed)
        if os.path.normpath(BUSINESS_DIR) in os.path.normpath(filepath):
            continue
        if process_file(filepath):
            modified += 1
            print(f"  Modified: {os.path.relpath(filepath, BASE_DIR)}")
    print(f"\nTotal: {modified} files modified")

if __name__ == "__main__":
    main()
