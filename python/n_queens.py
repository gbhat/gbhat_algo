BOARD_SIZE = 4
board = [[0 for i in range(BOARD_SIZE)] for j in range(BOARD_SIZE)]


def solve_nqueens(column=0):
    if column >= BOARD_SIZE:
        return True
    for row in range(0, BOARD_SIZE):
        if not is_safe(row, column):
            continue
        board[row][column] = 1
        if solve_nqueens(column + 1):
            return True
        board[row][column] = 0      # Triggers backtracking
    return False


# We need to check only on the left of the board since queens on the right side are yet to be placed
def is_safe(row, column):
    # Check for queens in the same row
    for i in range(0, column):
        if board[row][i] == 1:
            return False

    # Check for queens diagonally up
    for i, j in zip(range(0, row), range(0, column)):
        if board[i][j] == 1:
            return False

    # Check for queens diagonally down
    for i, j in zip(range(row + 1, BOARD_SIZE), reversed(range(0, column))):
        if board[i][j] == 1:
            return False

    return True


def print_solution():
    for row in range(BOARD_SIZE):
        print(board[row])


if solve_nqueens():
    print("Found a solution")
    print_solution()
else:
    print("Could not find a solution")
