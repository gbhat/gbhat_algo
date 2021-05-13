#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#define BOARD_SIZE 4

bool solve_nqueens(int board[BOARD_SIZE][BOARD_SIZE], int column);
bool is_safe(int board[BOARD_SIZE][BOARD_SIZE], int row, int column);
void print_solution(int board[BOARD_SIZE][BOARD_SIZE]);


int main()
{
    int board[BOARD_SIZE][BOARD_SIZE];
    memset(board, 0, sizeof(board));

    if (solve_nqueens(board, 0)) {
        printf("Found a solution\n");
        print_solution(board);
    }
    else
        printf("Could not find a solution\n");
    return 0;
}

bool solve_nqueens(int board[BOARD_SIZE][BOARD_SIZE], int column)
{
    if (column >= BOARD_SIZE)
        return true;

    for (int row = 0; row < BOARD_SIZE; row++) {
        if (!is_safe(board, row, column))
            continue;

        board[row][column] = 1;
        if (solve_nqueens(board, column + 1))
            return true;

	board[row][column] = 0;		// Triggers backtracking
    }

    return false;
}

// We need to check only on the left of the board since queens on the right side are yet to be placed
bool is_safe(int board[BOARD_SIZE][BOARD_SIZE], int row, int column)
{
    int i, j;

    // Check for queens in the same row
    for (int i = column - 1; i >= 0; i--)
        if (board[row][i])
            return false;

    // Check for queens diagonally up
    for (i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--)
        if (board[i][j])
            return false;

    // Check for queens diagonally down
    for (i = row + 1, j = column - 1; j >= 0 && i < BOARD_SIZE; i++, j--)
        if (board[i][j])
            return false;

    return true;
}

void print_solution(int board[BOARD_SIZE][BOARD_SIZE])
{
    for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++)
            printf("%d  ", board[i][j]);
        printf("\n");
    }
}


