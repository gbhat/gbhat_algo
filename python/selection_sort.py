def selection_sort(arr):
    arr_len = len(arr)
    for i in range(0, arr_len):
        min_idx = i
        for j in range(i + 1, arr_len):
            if arr[j] < arr[min_idx]:
                min_idx = j
        if min_idx != i:
            arr[min_idx], arr[i] = arr[i], arr[min_idx]


def main():
    arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
    print("Before: ", arr)
    selection_sort(arr)
    print("After: ", arr)


if __name__ == "__main__":
    main()
