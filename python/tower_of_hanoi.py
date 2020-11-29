# Function to solve tower of hanoi recursively
def tower_of_hanoi(no_of_disks, source, aux, target):
    if no_of_disks == 1:
        print("Move disk 1 from ", source, " to ", target)
        return
    # Move no_of_disks - 1 disks from source to aux using target
    tower_of_hanoi(no_of_disks - 1, source, target, aux)
    print("Move disk ", no_of_disks, " from ", source, " to ", target)
    # Move no_of_disks - 1 disks from aux to target using source
    tower_of_hanoi(no_of_disks - 1, aux, source, target)

# Driver function
def main():
    print("Steps to solve tower of hanoi with 3 disks:")
    tower_of_hanoi(3, "Source", "Aux", "Target")

    print("\n\nSteps to solve tower of hanoi with 5 disks:")
    tower_of_hanoi(5, "Source", "Aux", "Target")


if __name__ == "__main__":
    main()
