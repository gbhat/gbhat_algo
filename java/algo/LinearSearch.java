package algo;

public class LinearSearch {
    // Method implementing linear search
    private static void linearSearch(int[] arr, int key) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                found = true;
                System.out.println("Found key at index " + i);
                break;
            }
        }
        if (!found)
            System.out.println("Could not find key");
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 10, 14, 15, 16, 18, 20, 21, 22, 23, 25, 33, 35, 42, 45, 47, 50, 52};
        int key = 33;
        linearSearch(arr, key);
    }
}
