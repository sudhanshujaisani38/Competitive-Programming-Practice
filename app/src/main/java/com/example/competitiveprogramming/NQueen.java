import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // dimension of board
        boolean board[][] = new boolean[n][n];
        solveNQueen(board, 0, n);
    }

    //tries to solve n-queen problem from the i-th row
    private static void solveNQueen(boolean[][] board, int i, int n) {
        // base case
        if (i == n) {
            //if you come out of the board while solving, 
            //this means you have solved the problem.
            printBoard(board, n);
            System.out.println();
            return;
        }
        // recursive case
        for (int col = 0; col < n; col++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = true; //place the queen
                solveNQueen(board, i + 1, n); //solve rest of the board
                board[i][col] = false; //remove the queen in both case if it gives a solution or not and try next position
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int i, int j, int n) {
        for (int row = 0; row < i; row++) {
            if (board[row][j]) {
                return false;
            }
        }

        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col]) {
                return false;
            }
        }
        for (int row = i - 1, col = j + 1; row >= 0 && col < n; row--, col++) {
            if (board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(boolean[][] board, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
}