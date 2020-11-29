#include <stdio.h>

// Function to solve tower of hanoi recursively
void tower_of_hanoi(int no_of_disks, char *source, char *aux, char *target) {
    if (no_of_disks == 1) {
        printf("Move disk 1 from %s to %s\n", source, target);
        return;
    }
    // Move no_of_disks - 1 disks from source to aux using target
    tower_of_hanoi(no_of_disks - 1, source, target, aux);
    printf("Move disk %d form %s to %s", no_of_disks, source, target);
    // Move no_of_disks - 1 disks from aux to target using source
    tower_of_hanoi(no_of_disks - 1, aux, source, target);
}

//Driver function
int main() {
    printf("Moves to solve Tower Of Hanoi with 3 disks");
    tower_of_hanoi(3, "source", "aux", "target");

    printf("\n\nMoves to solve Tower Of Hanoi with 5 disks");
    tower_of_hanoi(5, "source", "aux", "target");
}
