package algo;

import java.util.Arrays;

public class MergeSort {
    /*
     * Method to merge two partitions of the array
     * One partition is (low to mid) and another one is from (mid + 1 to high)
     */
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
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
        } else if (m > high) {
            while (l <= mid)
                temp[idx++] = arr[l++];
        }

        System.arraycopy(temp, 0, arr, low, high - low + 1);
    }

    // Method implementing Merge Sort recursively
    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 1, 8, 6, 4, 2, 7};
        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
    }
}
