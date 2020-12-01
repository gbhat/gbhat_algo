#include <stdio.h>

// Function implementing Interpolation Search
void interpolation_search(int arr[], int arr_len, int key) {
    int found = 0;
    int low = 0;
    int high = arr_len - 1;
    while (key >= arr[low] && key <= arr[high] && arr[high] != arr[low]) {
        int mid = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));
        if (arr[mid] == key) {
            found = 1;
            printf("Found key at index %d\n", mid);
            break;
        } else if (arr[mid] > key)
            high = mid - 1;
        else
            low = mid + 1;
    }
    if (arr[low] == key) {
        found = 1;
        printf("Found key at index %d\n", low);
    }
    if (!found)
        printf("Could not find the key");
}

// Driver function
int main() {
    int arr[] = {1, 3, 7, 10, 14, 15, 16, 18, 20, 21, 22, 23, 25, 33, 35, 42, 45, 47, 50, 52};
    int key = 33;
    int arr_len = sizeof(arr) / sizeof(arr[0]);

    interpolation_search(arr, arr_len, key);
    return 0;
}
