arr = [5, 9, 3, 1, 8, 6, 4, 2, 7]
arr_len = len(arr)

print("Before: ", arr)
for i in range(1, arr_len):
    temp = arr[i]
    j = i - 1
    while j >= 0 and arr[j] > temp:
        arr[j + 1] = arr[j]
        j -= 1
    arr[j + 1] = temp
print("After: ", arr)