class RatInAMaze{

    public static void main(String[] args) {

        //-1 = blockage
        //0 = open path/no blockage
        int maze[][]={
            {0,  0,0,-1, 0},
            {0,-1,0,-1,-1},
            {0,-1,0, 0, 0},
            {0,-1,0,-1,-1},
            {0,-1,0,-1,-1},
            {0,  0,0, 0, 0}
        };
        int rows=maze.length,cols=maze[0].length;
    
        if(!solveRatInAMaze(maze,0,0,rows,cols)){
            System.out.println("no solution possible!");
        }
    }

    //returns if a possible path contains i,jth cell in it
    //prints the path too if true
    private static boolean solveRatInAMaze(int[][] maze, int i, int j,int rows,int cols) {
        //base case
        if(i==(rows-1) && j==(cols-1)){ //check if last cell has been reached
            maze[i][j]=1;
            printMaze(maze);
            maze[i][j]=0;
            System.out.println();
            return true;
        }
        if(i>=rows ||j>=cols){ //check if we have reached a dead-end or got out of the maze
            return false;
        }
        if(maze[i][j]==-1){//if this cell is a blockage it cannot be in a valid path
            return false;
        }

        //recursive case
        maze[i][j]=1;  //fill this cell and check if any right or down path contains this cell

        boolean fwdRoute=solveRatInAMaze(maze, i, j+1, rows, cols);
        boolean dnRoute=solveRatInAMaze(maze, i+1, j, rows, cols);

        maze[i][j]=0; //remove this cell no matter if there is a path or not because we need to get all possible o/p
        if(fwdRoute || dnRoute){
            return true;
        }
        return false;
    }

    private static void printMaze(int[][] maze) {
        int rows=maze.length,cols=maze[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(maze[i][j]==0){
                    System.err.print("0 ");
                }
                if(maze[i][j]==-1){
                    System.err.print("# ");
                }
                if(maze[i][j]==1){
                    System.err.print("1 ");
                }
            }
            System.out.println();
        }
    }
   
}