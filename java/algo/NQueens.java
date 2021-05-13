import java.util.Arrays;

public class NQueens {
    private static final int BOARD_SIZE = 4;
    private static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        //In the beginning set all values in the board to 0
        for(int row = 0; row < BOARD_SIZE; row++)
            Arrays.fill(board[row], 0);

        if (solveNQueens(0))  {
            System.out.println("Found solution");
            showBoard();
        } else {
            System.out.println("Could not find a solution");
        }
    }

    private static boolean solveNQueens(int column) {
        if (column >= BOARD_SIZE)
            return true;

        for(int row = 0; row < BOARD_SIZE; row++) {
            if (!isSafe(row, column))
                continue;
            board[row][column] = 1;
            if (solveNQueens(column + 1))
                return true;
            board[row][column] = 0;
        }
        return false;
    }

    // We need to check only on the left of the board since queens on the right side are yet to be placed
    private static boolean isSafe(int row, int column) {
        // Check for queens in the same row
        for(int i = column - 1; i >= 0; i--)
            if (board[row][i] == 1)
                return false;

        // Check for queens diagonally up
        for(int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check for queens diagonally down
        for(int i = row + 1, j = column - 1; i < BOARD_SIZE && j > 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }


    private static void showBoard() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
