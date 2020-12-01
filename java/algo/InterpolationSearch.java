package algo;

public class InterpolationSearch {
    // Method implementing interpolation search
    private static void interpolationSearch(int[] arr, int key) {
        boolean found = false;
        int low = 0;
        int high = arr.length - 1;
        while (key >= arr[low] && key <= arr[high] && arr[high] != arr[low]) {
            int mid = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));
            if (arr[mid] == key) {
                found = true;
                System.out.println("Found key at index " + mid);
                break;
            } else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (key == arr[low]) {
            found = true;
            System.out.println("Found key at index " + low);
        }
        if (!found)
            System.out.println("Could not find the key");
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 10, 14, 15, 16, 18, 20, 21, 22, 23, 25, 33, 35, 42, 45, 47, 50, 52};
        int key = 33;
        interpolationSearch(arr, key);
    }
}
