import java.math.BigInteger;
import java.util.Scanner;

class AP_COOKOFF2 {
    public static final int MOD=1000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n=sc.nextInt();
            long a= sc.nextInt();
            BigInteger A=BigInteger.valueOf(a);
            int ans=0;
            int multiplier=1;
            int power=0;
            for(int i=0;i<n;i++){
                // System.out.println("adding:"+(Math.pow(a,multiplier)));
                ans=((ans%MOD)+(int)(A.pow(multiplier).longValue()%MOD))%MOD;
                // a=a*(long)Math.pow(a,multiplier);
                A=A.multiply(A.pow(multiplier));
                multiplier+=2;
            }
            System.out.println(ans);
        }
    }
}