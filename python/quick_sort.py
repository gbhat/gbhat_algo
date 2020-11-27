def partition(arr, low, high):
    pivot = arr[high]
    i = low
    for j in range(low, high):
        if arr[j] < pivot:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
    arr[i], arr[high] = arr[high], arr[i]
    return i


def quick_sort(arr, low, high):
    if low < high:
        p = partition(arr, low, high)
        quick_sort(arr, low, p - 1)
        quick_sort(arr, p + 1, high)


def main():
    arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
    arr_len = len(arr)
    print("Before: ", arr)
    quick_sort(arr, 0, arr_len - 1)
    print("After: ", arr)


if __name__ == "__main__":
    main()
