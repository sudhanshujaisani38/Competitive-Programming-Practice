class SudokuSolver{
    public static void main(String[] args) {
        int sudoku[][]={
            {0,0,0, 0,0,0, 0,0,0},
            {0,1,2, 3,0,5, 8,6,0},
            {0,5,4, 0,0,0, 3,1,0},

            {0,2,0, 0,1,0, 0,9,0},
            {0,0,0, 4,0,7, 0,0,0},
            {0,7,0, 0,8,0, 0,2,0},

            {0,9,8, 0,0,0, 4,7,0},
            {0,4,6, 1,0,9, 2,3,0},
            {0,0,0, 0,0,0, 0,0,0}            
        };
        if(!solveSudoku(sudoku,0,0)){
            System.out.println("no solution exists for current sudoku");
        }
    }

    //tries to place a number at i,j if it's empty (represented by zero here) 
    //and returns if placing any number could solve the sudoku
    private static boolean solveSudoku(int[][] sudoku, int i, int j) {
        //base case
        if(i==9){
            printSudoku(sudoku);
            return true;
        }
        if(j==9){ //if reached the last column, start from next row
            return solveSudoku(sudoku, i+1, 0);
        }
        if(sudoku[i][j]!=0){ //if already filled, skip
            return solveSudoku(sudoku, i, j+1);
        }

        //recursive case
        for(int num=1;num<=9;num++){
            if(canPlace(sudoku,i,j,num)){
                sudoku[i][j]=num; //place the number and solve the rest of the sudoku
                boolean wasCorrect=solveSudoku(sudoku, i, j+1);
                if(wasCorrect){
                   return true; 
                }else{
                    //if it didn't gave the solution, remove the filled number
                    sudoku[i][j]=0;
                }
            }
        }
        return false; //no number could be placed
    }

    private static boolean canPlace(int[][] sudoku, int i, int j, int num) {
        for(int x=0;x<9;x++){
            if(sudoku[x][j]==num || sudoku[i][x]==num){ //check if num exists in ith row or jth col
                return false;
            }
        }
        int gridx=(i/3)*3; //starting pt of grid in which cell i,j exists
        int gridy=(j/3)*3; //starting pt of grid in which cell i,j exists
        for(int x=gridx;x<gridx+3;x++){
            for(int y=gridy;y<gridy+3;y++){
                if(sudoku[x][y]==num){
                    return false;
                }
            }
        }
        return true;//checked everything now we can place it
    }

    public static void printSudoku(int sudoku[][]) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}