import java.util.Scanner;

//Given an integer N which is a power of 2, i.e N=2^k, you have to fill a floor 
//of NxN with L shaped tiles such that there exists exactly one hole where there is
//no tile.
//This hole can be anywhere it doesn't matters
class TrominoTiling {
    static int tileNo = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n=2,4,8,16....

        int floor[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                floor[i][j] = -1;
            }
        }
        floor[n / 2-1][n / 2-1] = 0;
        solveTrominoTiling(floor, n, 0, 0, n / 2 - 1, n / 2 - 1);
        for (int x = 0; x < floor.length; x++) {
            for (int y = 0; y < floor[0].length; y++) {
                System.out.print(floor[x][y] + "  ");
            }
            System.out.println();
            System.out.println();
        }

    }

    // given the dimension of floor and the position of hole,
    // this function tries to fill the floor with L shaped tiles
    // and prints it.
    private static void solveTrominoTiling(int floor[][], int n, int top, int left, int row, int col) {
        tileNo++;
        
       
        // base case
        if (n == 2) {
            // tileNo++;
            if (row == top && col == left) {
                floor[top + 1][left + 1] = tileNo;
                floor[top + 1][left] = tileNo;
                floor[top][left + 1] = tileNo;
            }
            if (row == top && col != left) {
                floor[top][left] = tileNo;
                floor[top + 1][left] = tileNo;
                floor[top + 1][left + 1] = tileNo;
            }
            if (row != top && col == left) {
                floor[top + 1][left + 1] = tileNo;
                floor[top][left + 1] = tileNo;
                floor[top][left] = tileNo;
            }
            if (row != top && col != left) {
                floor[top][left] = tileNo;
                floor[top + 1][left] = tileNo;
                floor[top][left + 1] = tileNo;
            }
            return;
        }
        // recursive case
        else {
            // tileNo++;
            int mid = n / 2;
            if (row > top+mid && col > left+mid) { 
                System.out.println("rec case 1:hole lies in bottom-right");
                floor[top+mid - 1][left+mid - 1] = tileNo;
                floor[top+mid][left+mid - 1] = tileNo;
                floor[top+mid - 1][left+mid] = tileNo;
                solveTrominoTiling(floor, n / 2, top, left, top+mid - 1, left+mid - 1);
                solveTrominoTiling(floor, n / 2, top + mid, left, top+mid, left+mid - 1);
                solveTrominoTiling(floor, n / 2, top, left + mid, top+mid - 1, left+mid);
                solveTrominoTiling(floor, n / 2, top + mid, left + mid, row, col);
            } else if (row > top+mid && col <= left+mid) { // hole lies in bottom-left
                System.out.println("rec case 2:hole lies in bottom-left");
                floor[top+mid - 1][left+mid - 1] = tileNo;
                floor[top+mid - 1][left+mid] = tileNo;
                floor[top+mid][left+mid] = tileNo;

                solveTrominoTiling(floor, n / 2, top, left, top+mid - 1, left+mid - 1);
                solveTrominoTiling(floor, n / 2, top + mid, left, row, col);
                solveTrominoTiling(floor, n / 2, top, left + mid, top+mid - 1, left+mid);
                solveTrominoTiling(floor, n / 2, top + mid, left + mid, top+mid, left+mid);
            } else if (row <= top+mid && col <= left+mid) {// hole lies in top-left
                System.out.println("rec case 3:hole lies in top-left");
                floor[top+mid][left+mid] = tileNo;
                floor[top+mid][left+mid - 1] = tileNo;
                floor[top+mid - 1][left+mid] = tileNo;

                solveTrominoTiling(floor, n / 2, top, left, row, col);
                solveTrominoTiling(floor, n / 2, top + mid, left, top+mid, left+mid - 1);
                solveTrominoTiling(floor, n / 2, top, left + mid, top+mid - 1, left+mid);
                solveTrominoTiling(floor, n / 2, top + mid, left + mid, top+mid, left+mid);
            } else if (row <= top+mid && col > left+mid) { // hole lies in top-right
                System.out.println("rec case 4:hole lies in top-right");
                floor[top+mid - 1][left+mid - 1] = tileNo;
                floor[top+mid][left+mid - 1] = tileNo;
                floor[top+mid][left+mid] = tileNo;

                solveTrominoTiling(floor, n / 2, top, left, top+mid - 1, left+mid - 1);
                solveTrominoTiling(floor, n / 2, top + mid, left, top+mid, left+mid - 1);
                solveTrominoTiling(floor, n / 2, top, left + mid, row, col);
                solveTrominoTiling(floor, n / 2, top + mid, left + mid, top+mid, left+mid);
            }

        }
    }
}