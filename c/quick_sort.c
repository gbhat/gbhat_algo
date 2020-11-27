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

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            swap(arr, i, j);
            i++;
        }
    }
    swap(arr, i, high);
    return i;
}

void quick_sort(int arr[], int low, int high) {
    if (low < high) {
        int p = partition(arr, low, high);
        quick_sort(arr, low, p - 1);
        quick_sort(arr, p + 1, high);
    }
}

int main() {
    int arr[] = {5, 9, 3, 1, 8, 6, 4, 2, 7};
    int arr_len = sizeof(arr) / sizeof(arr[0]);

    printf("Before: ");
    print_arr(arr, arr_len);

    quick_sort(arr, 0, arr_len - 1);

    printf("After: ");
    print_arr(arr, arr_len);
    return 0;
}
