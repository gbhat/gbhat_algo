def bubble_sort(arr):
    arr_len = len(arr)
    for i in range(arr_len):
        end = arr_len - i - 1
        for j in range(end):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


def main():
    arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
    print("Before: ", arr)
    bubble_sort(arr)
    print("After: ", arr)


if __name__ == "__main__":
    main()
