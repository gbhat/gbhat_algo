package algo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 1, 8, 6, 4, 2, 7};
        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

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

    private static int partition(int[] arr, int low, int high) {
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
