# Brute-force string search method
def string_search(string, pattern):
    s_len = len(string)
    p_len = len(pattern)
    found = False
    i = 0
    for i in range(s_len - p_len + 1):
        j = 0
        for j in range(p_len):
            if string[i + j] != pattern[j]:
                break
        if j == p_len - 1:         # If we have reached end of pattern, we have found the pattern in string
            found = True
            break

    if found:
        print("Found pattern at index ", i)
    else:
        print("Could not find pattern")


# Driver method
def main():
    string = "ABCABAB ABABABAABAC"
    pattern = "ABABAABA"
    string_search(string, pattern)


if __name__ == "__main__":
    main()
