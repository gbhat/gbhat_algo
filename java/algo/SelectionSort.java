package algo;

import java.util.Arrays;

public class SelectionSort {
    // Utility method to swap two elements of the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function implementing Selection Sort
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            if (minIdx != i)
                swap(arr, i, minIdx);
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 1, 8, 6, 4, 2, 7};
        System.out.println("Before: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }
}