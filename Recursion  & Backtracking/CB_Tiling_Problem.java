import java.util.Scanner;

class CB_Tiling_Problem{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int ans=solveTilingProblem(n,m);
            System.out.println(ans);
        }
    }

    private static int solveTilingProblem(int n, int m) {
        // System.out.println("solving for "+n+"x"+m);
        //base case
        if(n<=0){
            return 0;
        }
        if(n<m){
            return 1;
        }
        if(n==m){
            return 2;
        }

        //recursive case
        int placedV= solveTilingProblem(n-1, m);
        int placedH= solveTilingProblem(n-m, m);
        // System.out.println( n+"x"+m+" hori:"+placedH+" ver:"+placedV);
        return placedH+placedV;
    }
}