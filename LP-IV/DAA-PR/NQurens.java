
public class NQurens {

    // Time Complexity: O(n)   // checks up to n rows in a column/diagonal
    // Space Complexity: O(1)
    public static boolean isSafe(char[][] board, int row, int col) {
        // Check same column upward
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal upward
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal upward
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char[][] board) {
        System.out.println("--------------- 8 Queens Board ---------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Time Complexity: O(n!)   // worst-case search tree for n-Queens
    // Space Complexity: O(n^2) + O(n) = O(n^2)   // board + recursion stack
    public static boolean solveQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return true;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';

                if (solveQueens(board, row + 1)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // First queen is fixed at row 0, column 3
        int firstRow = 0;
        int firstCol = 0;

        board[firstRow][firstCol] = 'Q';

        if (solveQueens(board, 1)) {
            System.out.println("Solution exists for the remaining queens.");
        } else {
            System.out.println("No valid arrangement for remaining queens.");
        }
    }
}

