def merge(arr, low, mid, high):
    """
    Function to merge two sorted partitions of the array
    One partition is (low to mid) and another one is from (mid + 1 to high)
    """
    temp = []
    l = low
    m = mid + 1
    while l <= mid and m <= high:
        if arr[l] < arr[m]:
            temp.append(arr[l])
            l += 1
        else:
            temp.append(arr[m])
            m += 1
    if l > mid:
        while m <= high:
            temp.append(arr[m])
            m += 1
    elif m > high:
        while l <= mid:
            temp.append(arr[l])
            l += 1
    arr[low: high + 1] = temp[:]


def merge_sort(arr, low, high):
    """Function implementing Merge Sort recursively"""
    if low < high:
        mid = int((low + high) / 2)
        merge_sort(arr, low, mid)
        merge_sort(arr, mid + 1, high)
        merge(arr, low, mid, high)


def main():
    """Driver function"""
    arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
    arr_len = len(arr)
    print("Before: ", arr)
    merge_sort(arr, 0, arr_len - 1)
    print("After: ", arr)


if __name__ == "__main__":
    main()
