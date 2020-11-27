def max_heapify(arr, idx, end):
    left = idx * 2 + 1
    right = idx * 2 + 2
    max_idx = idx
    if left <= end and arr[left] > arr[max_idx]:
        max_idx = left
    if right <= end and arr[right] > arr[max_idx]:
        max_idx = right
    if max_idx != idx:
        arr[idx], arr[max_idx] = arr[max_idx], arr[idx]
        max_heapify(arr, max_idx, end)


def heap_sort(arr):
    arr_len = len(arr)
    end = arr_len - 1
    for idx in reversed(range(0, int((arr_len - 1) / 2))):
        max_heapify(arr, idx, end)
    while end > 0:
        arr[0], arr[end] = arr[end], arr[0]
        end -= 1
        max_heapify(arr, 0, end)


def main():
    arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
    print("Before: ", arr)
    heap_sort(arr)
    print("After: ", arr)


if __name__ == "__main__":
    main()
