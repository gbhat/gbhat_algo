package algo;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 1, 8, 6, 4, 2, 7};
        System.out.println("Before: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int end = arr.length - 1;
        for (int idx = (arr.length - 1) / 2; idx >= 0; idx--)
            maxHeapify(arr, idx, end);
        while (end > 0) {
            int temp = arr[end];
            arr[end] = arr[0];
            arr[0] = temp;
            end--;
            maxHeapify(arr, 0, end);
        }
    }

    private static void maxHeapify(int[] arr, int idx, int end) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int maxIdx = idx;
        if (left <= end && arr[left] > arr[maxIdx])
            maxIdx = left;
        if (right <= end && arr[right] > arr[maxIdx])
            maxIdx = right;
        if (maxIdx != idx) {
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[idx];
            arr[idx] = temp;
            maxHeapify(arr, maxIdx, end);
        }
    }
}
