arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
arr_len = len(arr)

print("Before: ", arr)
for i in range(arr_len):
    end = arr_len - i - 1
    for j in range(end):
        if arr[j] > arr[j + 1]:
            arr[j], arr[j + 1] = arr[j + 1], arr[j]
print("After: ", arr)