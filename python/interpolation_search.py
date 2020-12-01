# Function implementing Interpolation Search
def interpolation_search(arr, key):
    found = False
    low = 0
    high = len(arr) - 1
    while arr[low] <= key <= arr[high] and arr[high] != arr[low]:
        mid = int(low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low])))
        if arr[mid] == key:
            found = True
            print("Found key at index ", mid)
            break
        elif arr[mid] > key:
            high = mid - 1
        else:
            low = mid + 1

    if key == arr[low]:
        found = True
        print("Found key at index", low)

    if not found:
        print("Could not find the key")


# Driver function
def main():
    arr = [1, 3, 7, 10, 14, 15, 16, 18, 20, 21, 22, 23, 25, 33, 35, 42, 45, 47, 50, 52]
    key = 33
    interpolation_search(arr, key)


if __name__ == "__main__":
    main()
