BOARD_SIZE = 5
board = [[0 for i in range(BOARD_SIZE)] for j in range(BOARD_SIZE)]     # Create a board with size BOARD_SIZE x BOARD_SIZE filled with 0

# STEPS is the possible steps for knight at any position.For example {-1, 2} is one left and 2 down, {2, 1} is 2 right and 1 down
STEPS = [[-1, 2], [1, 2], [-2, 1], [2, 1], [1, -2], [-1, -2], [2, -1], [-2, -1]]


def solve_knights_tour(x, y, step_count):
    if step_count > BOARD_SIZE * BOARD_SIZE:
        return True
    for step in STEPS:
        next_x = x + step[0]
        next_y = y + step[1]
        if is_safe(next_x, next_y):
            board[next_x][next_y] = step_count
            if solve_knights_tour(next_x, next_y, step_count + 1):
                return True
            board[next_x][next_y] = 0       # triggers backtracking
    return False


def is_safe(x, y):
    return 0 <= x < BOARD_SIZE and 0 <= y < BOARD_SIZE and board[x][y] == 0


def print_solution():
    for row in board:
        for col in row:
            print("0" + str(col) if col < 10 else col, end=" ")
        print()


board[0][0] = 1     # First move is at (0, 0)

if solve_knights_tour(0, 0, 2):
    print("Found a solution")
    print_solution()
else:
    print("Could not find a solution")