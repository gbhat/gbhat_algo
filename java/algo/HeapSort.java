package algo;

import java.util.Arrays;

public class HeapSort {
    // Utility method to swap two elements of the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to convert array into max heap at index idx
    private static void maxHeapify(int[] arr, int idx, int end) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int maxIdx = idx;
        if (left <= end && arr[left] > arr[maxIdx])
            maxIdx = left;
        if (right <= end && arr[right] > arr[maxIdx])
            maxIdx = right;
        if (maxIdx != idx) {
            swap(arr, idx, maxIdx);
            maxHeapify(arr, maxIdx, end);   // Check if number has to be pushed further down
        }
    }

    // Method implementing Heap Sort
    private static void heapSort(int[] arr) {
        int end = arr.length - 1;
        for (int idx = (arr.length - 1) / 2; idx >= 0; idx--)
            maxHeapify(arr, idx, end);
        while (end > 0) {
            swap(arr, 0, end);
            end--;
            maxHeapify(arr, 0, end);
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 1, 8, 6, 4, 2, 7};
        System.out.println("Before: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

}
