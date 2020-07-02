//given an n, find the values of binomial coefficients
//i.e nC0,nC1,nC2,nC3,nC4....nCn
class Main{
    public static void main(String[] args) {
        int n=10;         
        int nCr[][]=new int[n+1][n+1];
        solveBottomUp(nCr,n);

        System.out.print("Bottom up Solution: ");
        for(int r=0;r<=n;r++){
            System.out.print(nCr[n][r]+",");
        }
        System.out.println();


        int nCr2[][]=new int[n+1][n+1];
        System.out.print("top down solution: ");
        for(int r=0;r<=n;r++){
            System.out.print(getnCr(n,r,nCr2)+",");
        }
        System.out.println();
        
        // for(int i=1;i<=nn;i++){
        //     System.out.print("n="+i+" ");
        //     for(int j=0;j<=i;j++){
        //         System.out.print(nCr[i][j]+",");
        //     }
        //     System.out.println();
        // }
    }

    private static int getnCr(int n, int r,int nCr[][]) {
        if(r==0 || r==n){
            return 1;
        }
        if(nCr[n][r]!=0){
            return nCr[n][r];
        }
        return nCr[n][r]=getnCr(n-1, r-1, nCr)+getnCr(n-1, r, nCr);
    }

    private static void solveBottomUp(int[][] nCr, int nn) {
        nCr[1][0]=1;
        nCr[1][1]=1;
        for(int i=2;i<=nn;i++){
            nCr[i][0]=1;
            nCr[i][i]=1;
            for(int j=1;j<i;j++){
                nCr[i][j]=nCr[i-1][j-1]+nCr[i-1][j];
            }
        }
    }
}