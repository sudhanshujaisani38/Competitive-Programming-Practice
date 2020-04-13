import java.util.Scanner;

class JANCOOKOFF3 {
    public static final long MOD=1000000009;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long l=sc.nextLong();
            long r=sc.nextLong();
            long sum=0;
            for(long i=l;i<=r;i++){
                long temp=l;
//                System.out.print(l);
                for(long j=l+1;j<=i;j++){
//                    System.out.print("AND"+j);
                    temp=temp&j;
                }
//                System.out.println();
                sum=(sum+temp)%MOD;
            }
            System.out.println(sum);
        }
    }
}
