import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static final int MOD=998_244_353;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int ans=1;
            ans=solve(n, arr);
            System.out.println(ans);
        }
    }
    static int solve(int n,int arr[]){
        int finalAns=0;
        int range=(1<<n)-1;
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i=0;i<=range;i++){
            int num=i;
            int index=0;
            while(num>0){
                if((num&1)==1){
                    ar.add(arr[index]);
                }
                index++;
                num=num>>1;
            }
            finalAns=((finalAns%MOD)+(findAns(ar)%MOD))%MOD;
            ar.clear();
        }
        return finalAns;
    }
    static int findAns(ArrayList<Integer> arr){
        Collections.sort(arr);
        int max=1;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==max){
                max++;
            }
        }
        return max;
    }
}