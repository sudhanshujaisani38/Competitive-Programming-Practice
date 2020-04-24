import java.util.Scanner;

class AP_COOKOFF1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            int q=sc.nextInt();
            int prev=0;
            long ans=0;
            for(int i=0;i<q;i++){
                int src=sc.nextInt();
            int dest=sc.nextInt();
            // System.out.println("ans:"+ans);
                ans+=((int)Math.abs(src-prev)+(int)Math.abs(dest-src));
                prev=dest;
            }
            System.out.println(ans);
        }
    }
}