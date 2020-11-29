package algo;

public class TowerOfHanoi {
    // Method to solve tower of hanoi recursively
    private static void towerOfHanoi(int noOfDisks, String source, String aux, String target) {
        if (noOfDisks == 1) {       // If only one disk is left, move it from source to target
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        // Move noOfDisks - 1 disks from source to aux using target
        towerOfHanoi(noOfDisks - 1, source, target, aux);
        System.out.println("Move disk " + noOfDisks + " from " + source + " to " + target);
        // Move noOfDisks - 1 disks from aux to target using source
        towerOfHanoi(noOfDisks - 1, aux, source, target);
    }

    // Driver method
    public static void main(String[] args) {
        System.out.println("Moves to solve Tower Of Hanoi with 3 disks");
        towerOfHanoi(3, "Source", "Aux", "Target");

        System.out.println("\n\nMoves to solve Tower Of Hanoi with 5 disks");
        towerOfHanoi(5, "Source", "Aux", "Target");
    }
}
