# Function implementing Linear Search
def linear_search(arr, key):
    found = False
    arr_len = len(arr)
    for i in range(arr_len):
        if arr[i] == key:
            found = True
            print("Found key at index ", i)
            break
    if not found:
        print("Could not find key")


# Driver function
def main():
    arr = [1, 3, 7, 10, 14, 15, 16, 18, 20, 21, 22, 23, 25, 33, 35, 42, 45, 47, 50, 52]
    key = 33
    linear_search(arr, key)


if __name__ == "__main__":
    main()
