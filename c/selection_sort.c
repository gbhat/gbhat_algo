#include <stdio.h>

// Utility function to print the array
void print_arr(int arr[], int arr_len) {
    for (int i = 0; i < arr_len; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

// Utility function to swap two elements of the array
void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

// Function implementing Selection Sort
void selection_sort(int arr[], int arr_len) {
    for (int i = 0; i < arr_len - 1; i++) {
        int min_idx = i;
        for (int j = i + 1; j < arr_len; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;
        if (min_idx != i)
            swap(arr, i, min_idx);
    }
}

// Driver function
int main() {
    int arr[] = {5, 9, 3, 1, 8, 6, 4, 2, 7};
    int arr_len = sizeof(arr) / sizeof(arr[0]);

    printf("Before: ");
    print_arr(arr, arr_len);

    selection_sort(arr, arr_len);

    printf("After: ");
    print_arr(arr, arr_len);
    return 0;
}
