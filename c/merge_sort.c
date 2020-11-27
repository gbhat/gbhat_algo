#include <stdio.h>
#include <string.h>


// Utility function to print the array
void print_arr(int arr[], int arr_len) {
    for (int i = 0; i < arr_len; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

/*
 * Function to merge two sorted partitions of the array
 * One partition is (low to mid) and another one is from (mid + 1 to high)
 */
void merge(int arr[], int low, int mid, int high) {
    int temp[high - low + 1];
    int idx = 0;
    int l = low;
    int m = mid + 1;
    while (l <= mid && m <= high) {
        if (arr[l] < arr[m])
            temp[idx++] = arr[l++];
        else
            temp[idx++] = arr[m++];
    }
    if (l > mid) {
        while (m <= high)
            temp[idx++] = arr[m++];
    } else if (m >= high) {
        while (l <= mid) {
            temp[idx++] = arr[l++];
        }
    }
    memcpy(&arr[low], temp, sizeof(temp));
}

// Function implementing Merge Sort recursively
void merge_sort(int arr[], int low, int high) {
    if (low < high) {
        int mid = (low + high) / 2;
        merge_sort(arr, low, mid);
        merge_sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
}

// Driver function
int main() {
    int arr[] = {5, 9, 3, 1, 8, 6, 4, 2, 7};
    int arr_len = sizeof(arr) / sizeof(arr[0]);

    printf("Before: ");
    print_arr(arr, arr_len);

    merge_sort(arr, 0, arr_len - 1);

    printf("After: ");
    print_arr(arr, arr_len);
    return 0;
}
