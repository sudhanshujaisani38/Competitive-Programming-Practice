import java.util.Scanner;

class Main {
    static String mat[];
    static int noOfRows;
    static int noOfCols;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        noOfCols=c;
        noOfRows=r;
        mat=new String[r];
        for(int i=0;i<r;i++){
            mat[i]=sc.next();
        }
        int finalAns=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i].charAt(j)=='R'){
                    int ans=0;
                    ans+=(getVerticalMoves(i,j));
                    ans+=(getHorizontalMoves(i,j));
                    // System.out.println("adding "+ans+" moves for R");
                    finalAns+=ans;
                }
                if(mat[i].charAt(j)=='B'){
                    int ans=0;
                    ans+=(getLDMoves(i,j));
                    ans+=(getRDMoves(i,j));
                    // System.out.println("adding "+ans+" moves for B");
                    finalAns+=ans;

                }
                if(mat[i].charAt(j)=='Q'){
                    int ans=0;
                    ans+=(getVerticalMoves(i,j));
                    ans+=(getHorizontalMoves(i,j));
                    ans+=(getLDMoves(i, j));
                    ans+=(getRDMoves(i, j));
                    // System.out.println("adding "+ans+" moves for Q");
                    finalAns+=ans;

                }
            }
        }
        System.out.println(finalAns);
    }

    private static int getRDMoves(int i, int j) {
        int r=i-1;
        int c=j+1;
        int ans=0;
        while(r>=0 && c<noOfCols){
            if(mat[r].charAt(c)=='.'){
                ans++;
                r--;
                c++;
            }else{
                break;
            }
        }
        r=i+1;
        c=j-1;
        while(r<noOfRows && c>=0){
            if(mat[r].charAt(c)=='.'){
                ans++;
                r++;
                c--;
            }else{
                break;
            }
        }
        return ans;
    }

    private static int getLDMoves(int i, int j) {
        int r=i-1;
        int c=j-1;
        int ans=0;
        while(r>=0 && c>=0){
            if(mat[r].charAt(c)=='.'){
                ans++;
                r--;
                c--;
            }else{
                break;
            }
        }
        r=i+1;
        c=j+1;
        while(r<noOfRows && c<noOfCols){
            if(mat[r].charAt(c)=='.'){
                ans++;
                r++;
                c++;
            }else{
                break;
            }
        }
        return ans;
    }

    private static int getHorizontalMoves(int i, int j) {
        int ans=0;
        for(int c=j-1;c>=0;c--){
            if(mat[i].charAt(c)=='.'){
                ans++;
            }else{
                break;
            }
        }
        for(int c=j+1;c<noOfCols;c++){
            if(mat[i].charAt(c)=='.'){
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }

    private static int getVerticalMoves(int i, int j) {
        int ans=0;
        for(int r=i-1;r>=0;r--){
            if(mat[r].charAt(j)=='.'){
                ans++;
            }else{
                break;
            }
        }
        for(int r=i+1;r<noOfRows;r++){
            if(mat[r].charAt(j)=='.'){
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}