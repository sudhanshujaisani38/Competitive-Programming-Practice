import java.util.Scanner;

class Main {
    static int noOfCellsCleared = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxForce = sc.nextInt();
        int grid[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int maxShots = sc.nextInt();
        Attack attack[] = new Attack[2 * maxShots];

        int shotsTaken = 0;
        char direction = 'X';
        int index = -1;
        outer:for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(noOfCellsCleared==(n*n)){
                    break;
                }
                if (grid[i][j] != 0) {
                    // System.out.println("tring to destroy: " + i + "," + j);
                    int h = getLeftThickness(i, n, grid, maxForce);
                    int v = getTopThickness(j, n, grid, maxForce);
                    if (h >= v) {
                        direction = 'L';
                        index = i + 1;
                    } else {
                        direction = 'U';
                        index = j + 1;
                    }
                    fireAttack(direction, index, grid, maxForce, n);
                    attack[shotsTaken] = new Attack(direction, index);
                    shotsTaken++;
                    // System.out.println("cells cleared till now:" + noOfCellsCleared);
                    // for (int row = 0; row < n; row++) {
                    // for (int col = 0; col < n; col++) {
                    // System.out.print(grid[row][col] + ",");
                    // }
                    // System.out.println();
                    // }
                }
                if (grid[n - 1 - i][n - 1 - j] != 0) {
                    // System.out.println("tring to destroy: " + (n-1-i) + "," + (n-1-j));
                    int h = getRightThickness(n - 1 - i, n, grid, maxForce);
                    int v = getBottomThickness(n - 1 - j, n, grid, maxForce);
                    if (h >= v) {
                        direction = 'R';
                        index = (n - 1 - i) + 1;
                    } else {
                        direction = 'D';
                        index = (n - 1 - j) + 1;
                    }
                    fireAttack(direction, index, grid, maxForce, n);
                    attack[shotsTaken] = new Attack(direction, index);
                    shotsTaken++;
                    // System.out.println("cells cleared till now:" + noOfCellsCleared);
                    // for (int row = 0; row < n; row++) {
                    // for (int col = 0; col < n; col++) {
                    // System.out.print(grid[row][col] + ",");
                    // }
                    // System.out.println();
                    // }
                }
            }

        }
        System.out.println(shotsTaken);
        for (int i = 0; i < shotsTaken; i++) {
            System.out.println(attack[i]);
        }
    }

    static class Attack {
        char dir;
        int index;

        public Attack(char dir, int index) {
            this.dir = dir;
            this.index = index;
        }

        @Override
        public String toString() {
            return dir + " " + index;
        }
    }

    static int getLeftThickness(int rowNo, int n, int grid[][], int maxForce) {
        int i = rowNo;
        int thickNess = 0;
        for (int j = 0; j < n; j++) {
            if (thickNess + grid[i][j] > maxForce) {
                break;
            } else {
                thickNess += grid[i][j];
            }
        }
        return thickNess;
    }

    static int getRightThickness(int rowNo, int n, int grid[][], int maxForce) {
        int i = rowNo;
        int thickNess = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (thickNess + grid[i][j] > maxForce) {
                break;
            } else {
                thickNess += grid[i][j];
            }
        }
        return thickNess;
    }

    static int getTopThickness(int columnNo, int n, int grid[][], int maxForce) {
        int j = columnNo;
        int thickNess = 0;
        for (int i = 0; i < n; i++) {
            if (thickNess + grid[i][j] > maxForce) {
                break;
            } else {
                thickNess += grid[i][j];
            }
        }
        return thickNess;
    }

    static int getBottomThickness(int columnNo, int n, int grid[][], int maxForce) {
        int j = columnNo;
        int thickNess = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (thickNess + grid[i][j] > maxForce) {
                break;
            } else {
                thickNess += grid[i][j];
            }
        }
        return thickNess;
    }

    static void fireAttack(char direction, int index, int grid[][], int maxForce, int n) {
        if (direction == 'L') {
            int i = index - 1;
            int thickNess = 0;
            for (int j = 0; j < n; j++) {
                if (thickNess + grid[i][j] > maxForce) {
                    break;
                } else {
                    if (grid[i][j] != 0) {
                        noOfCellsCleared++;
                    }
                    thickNess += grid[i][j];
                    grid[i][j] = 0;
                }
            }
        } else if (direction == 'R') {
            int i = index - 1;
            int thickNess = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (thickNess + grid[i][j] > maxForce) {
                    break;
                } else {
                    if (grid[i][j] != 0) {
                        noOfCellsCleared++;
                    }
                    thickNess += grid[i][j];
                    grid[i][j] = 0;
                }
            }
        } else if (direction == 'D') {
            int j = index - 1;
            int thickNess = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (thickNess + grid[i][j] > maxForce) {
                    break;
                } else {
                    if (grid[i][j] != 0) {
                        noOfCellsCleared++;
                    }
                    thickNess += grid[i][j];
                    grid[i][j] = 0;
                }
            }
        } else if (direction == 'U') {
            int j = index - 1;
            int thickNess = 0;
            for (int i = 0; i < n; i++) {
                if (thickNess + grid[i][j] > maxForce) {
                    break;
                } else {
                    if (grid[i][j] != 0) {
                        noOfCellsCleared++;
                    }
                    thickNess += grid[i][j];
                    grid[i][j] = 0;
                }
            }
        } else {
            System.out.println("unknown direction");
        }
    }
}