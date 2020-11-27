#include <stdio.h>

void print_arr(int arr[], int arr_len) {
    for (int i = 0; i < arr_len; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void max_heapify(int arr[], int idx, int end) {
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;
    int max_idx = idx;
    if (left <= end && arr[left] > arr[max_idx])
        max_idx = left;
    if (right <= end && arr[right] > arr[max_idx])
        max_idx = right;
    if (max_idx != idx) {
        swap(arr, idx, max_idx);
        max_heapify(arr, max_idx, end);
    }
}

void heap_sort(int arr[], int arr_len) {
    int end = arr_len - 1;

    // First convert the array into a max heap
    for(int i = (arr_len - 1) / 2; i >= 0; i--) {
        max_heapify(arr, i, end);
    }

    while(end > 0) {
        swap(arr, 0, end);
        max_heapify(arr, 0, end);
        end--;
    }
}

int main() {
    int arr[] = {5, 9, 3, 1, 8, 6, 4, 2, 7};
    int arr_len = sizeof(arr) / sizeof(arr[0]);

    printf("Before: ");
    print_arr(arr, arr_len);

    heap_sort(arr, arr_len);

    printf("After: ");
    print_arr(arr, arr_len);
    return 0;
}
