import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            int copy[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                copy[i]=arr[i];
            }
            Arrays.sort(copy);
            boolean origVisited[]=new boolean[n];

            for(int i=0;i<n;i++){
                origVisited[i]=false;
            }
            boolean outerFlag=true;
            for(int i=0;i<n;i++){
                boolean flag=true;
                for(int j=i,j2=i;(j<n) || (j2>=0);j+=k,j2-=k){
                    if(j<n){
                        if(arr[j]==copy[i] && !origVisited[j]){
                            origVisited[j]=true;
                            flag=false;
                            break;
                        }
                    }
                    if(j2>=0){
                        if(arr[j2]==copy[i] && !origVisited[j2]){
                            origVisited[j2]=true;
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag){
                    System.out.println("no");
                    outerFlag=false;
                    break;
                }
            }
            if(outerFlag){
                System.out.println("yes");
            }
        }
    }
}