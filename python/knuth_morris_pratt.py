# KMP string search method
def string_search(string, pattern, lookup_table):
    i = 0
    j = 0
    while i < len(string) and j < len(pattern):
        if string[i] == pattern[j]:
            i += 1
            j += 1
        elif j > 0:
            j = lookup_table[j - 1]
        else:
            i += 1
    if j == len(pattern):
        print("Found pattern at index: ", i - j)


# Method to build lookup table using pattern
def build_lookup_table(pattern):
    table = [0 for i in range(len(pattern))]
    idx = 0
    j = 1
    while j < len(pattern):
        if pattern[idx] == pattern[j]:
            idx += 1
            table[j] = idx
            j += 1
        elif idx > 0:
            idx = table[idx - 1]
        else:
            j += 1
    return table


# Driver method
def main():
    string = "ABCABAB ABABABAABAC"
    pattern = "ABABAABA"
    lookup_table = build_lookup_table(pattern)
    print("Lookup table: ", lookup_table)
    string_search(string, pattern, lookup_table)


if __name__ == "__main__":
    main()
