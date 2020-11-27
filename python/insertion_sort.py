def insertion_sort(arr):
    """Function implementing Insertion Sort"""
    arr_len = len(arr)
    for i in range(1, arr_len):
        temp = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > temp:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = temp


def main():
    """Driver method"""
    arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
    print("Before: ", arr)
    insertion_sort(arr)
    print("After: ", arr)


if __name__ == "__main__":
    main()
