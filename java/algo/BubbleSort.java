package algo;

import java.util.Arrays;

public class BubbleSort {
    // Utility method to swap two elements of the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method implementing Bubble Sort
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int end = arr.length - i - 1;
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 1, 8, 6, 4, 2, 7};
        System.out.println("Before: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }
}
