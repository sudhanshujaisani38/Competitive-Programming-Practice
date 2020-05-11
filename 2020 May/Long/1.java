import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n=sc.nextInt();
            int x[]=new int[n];
            for(int i=0;i<n;i++){
                x[i]=sc.nextInt();
            }
            int left[]=new int[n];
            int right[]=new int[n];
            left[0]=1;
            right[n-1]=1;
            // System.out.println("left:1,");
            for(int i=1;i<n;i++){
                if(x[i]-x[i-1]<=2){
                    left[i]=left[i-1]+1;
                }else{
                    left[i]=1;
                }
                // System.out.print(left[i]+",");
            }
            // System.out.println("right:");
            for(int i=n-2;i>=0;i--){
                if(x[i+1]-x[i]<=2){
                    right[i]=right[i+1]+1;
                }else{
                    right[i]=1;
                }
                // System.out.print(right[i]+",");
            }
            // System.out.println();
            int max=1;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                int total=left[i]+right[i]-1;
                if(total>max){
                    max=total;
                }
                if(total<min){
                    min=total;
                }
            }
            System.out.println(min+" "+max);
        }
    }
}