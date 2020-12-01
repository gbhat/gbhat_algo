#include <stdio.h>

// Function implementing Linear Search
void linear_search(int arr[], int arr_len, int key) {
    int found = 0;
    for (int i = 0; i < arr_len; i++) {
        if (arr[i] == key) {
            found = 1;
            printf("Found Key at index %d\n", i);
        }
    }
    if (!found)
        printf("Could not find the key\n");
}

// Driver function
int main() {
    int arr[] = {1, 3, 7, 10, 14, 15, 16, 18, 20, 21, 22, 23, 25, 33, 35, 42, 45, 47, 50, 52};
    int key = 33;
    int arr_len = sizeof(arr) / sizeof(arr[0]);

    linear_search(arr, arr_len, key);
    return 0;
}
