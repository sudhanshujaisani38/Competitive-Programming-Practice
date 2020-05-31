import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n=sc.nextInt();
            HashMap<Integer,Integer> map=new HashMap<>();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                int units=sc.nextInt();
                if((units&1)==1){
                    units--;
                }
                map.put(arr[i],units);
            }
            Arrays.sort(arr);
            int sticksUsed=0;
            int last2Sum=0;
            int ans=0;
            for(int i=n-1;i>=0;i--){
                if((map.get(arr[i])>=2)){
                        last2Sum=2*arr[i];
                        ans+=(arr[i]*map.get(arr[i]));
                        sticksUsed+=map.get(arr[i]);
                }
            }
            if(sticksUsed%4!=0){
                ans-=last2Sum;
            }
            System.out.println(ans);

        }
    }
}