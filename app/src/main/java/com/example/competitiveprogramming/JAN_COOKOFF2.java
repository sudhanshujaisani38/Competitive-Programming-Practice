import java.util.ArrayList;
import java.util.Scanner;

class JAN_COOKOFF2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int m=Math.max(a,b);
            a--;
            b--;
            int ans=0;
            ArrayList<Integer> aa=new ArrayList<>();
            for(int p=1;p<=m;p++){
                System.out.println("p="+p+" "+(a%p)+" "+(b%p));
                if((a%p)==(b%p)){
                    ans++;
                    aa.add(p);
                }
            }
            System.out.println(aa);
        }
    }
}
