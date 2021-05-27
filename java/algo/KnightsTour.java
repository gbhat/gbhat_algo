package algo;

import java.util.Arrays;

public class KnightsTour {

    /* STEPS is the possible steps for knight at any position. For example {-1, 2} is one left and 2 down, {2, 1} is 2 right and 1 down. */
    private static final int[][] STEPS = new int[][] {{-1, 2}, {1, 2}, {-2, 1}, {2, 1}, {1, -2}, {-1, -2}, {2, -1}, {-2, -1}};
    private static final int BOARD_SIZE = 5;

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

        for(int row = 0; row < BOARD_SIZE; row++)               //In the beginning set all values in the board to 0
            Arrays.fill(board[row], 0);

        board[0][0] = 1;        // First step is at (0, 0)

        if (solveKnightsTour(board, 0, 0, 2)) {
            System.out.println("Found a solution:");
            for(int[] row : board) {
                for (int val : row)
                    System.out.print(val < 10 ? "0" + val + " " : val + " ");
                System.out.println();
            }
        } else
            System.out.println("Could not find a solution");
    }

    private static boolean solveKnightsTour(int[][] board, int x, int y, int stepCount) {
        if (stepCount > BOARD_SIZE * BOARD_SIZE)
            return true;
        for (int[] step : STEPS) {
            int nextX = x + step[0];
            int nextY = y + step[1];
            if (isValid(board, nextX, nextY)) {
                board[nextX][nextY] = stepCount;
                if (solveKnightsTour(board, nextX, nextY, stepCount + 1))
                    return true;
                board[nextX][nextY] = 0;        //triggers backtracking
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < BOARD_SIZE && nextY < BOARD_SIZE && board[nextX][nextY] == 0;
    }
}
