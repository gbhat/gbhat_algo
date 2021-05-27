#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#define BOARD_SIZE 5
#define STEPS_SIZE 8

bool solve_knights_tour(int board[BOARD_SIZE][BOARD_SIZE], int steps[STEPS_SIZE][2], int x, int y, int step_count);
bool is_safe(int board[BOARD_SIZE][BOARD_SIZE], int x, int y);
void print_solution(int board[BOARD_SIZE][BOARD_SIZE]);


int main()
{
    // steps is the possible steps for knight at any position. For example {-1, 2} is one left and 2 down, {2, 1} is 2 right and 1 down.
    int steps[STEPS_SIZE][2] = {{-1, 2}, {1, 2}, {-2, 1}, {2, 1}, {1, -2}, {-1, -2}, {2, -1}, {-2, -1}};

    int board[BOARD_SIZE][BOARD_SIZE];
    memset(board, 0, sizeof(board));

    board[0][0] = 1;
    if (solve_knights_tour(board, steps, 0, 0, 2)) {
        printf("Found a solution\n");
        print_solution(board);
    }
    else
        printf("Could not find a solution\n");
    return 0;
}

bool solve_knights_tour(int board[BOARD_SIZE][BOARD_SIZE], int steps[STEPS_SIZE][2], int x, int y, int step_count)
{
    if (step_count > BOARD_SIZE * BOARD_SIZE)
        return true;

    for (int i = 0; i < STEPS_SIZE; i++) {
        int next_x = x + steps[i][0];
        int next_y = y + steps[i][1];

        if (is_safe(board, next_x, next_y)) {
            board[next_x][next_y] = step_count;
            if (solve_knights_tour(board, steps, next_x, next_y, step_count + 1))
                return true;
            board[x][y] = 0;		// Triggers backtracking
        }
    }

    return false;
}

bool is_safe(int board[BOARD_SIZE][BOARD_SIZE], int x, int y)
{
    return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && board[x][y] == 0;
}

void print_solution(int board[BOARD_SIZE][BOARD_SIZE])
{
    for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++)
            board[i][j] < 10 ? printf("0%d ", board[i][j]) : printf("%d ", board[i][j]);
        printf("\n");
    }
}
