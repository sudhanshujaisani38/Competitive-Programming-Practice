//given N cow-stalls and C cows and position of stalls, such that stalls are in a straight line,
//find the maximum minimum distance that cows can be placed in
//i.e maximize the minimum distance between each cow.

import java.util.Arrays;
import java.util.Scanner;

class AggresiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int noOfStalls=sc.nextInt();
            int noOfCows=sc.nextInt();
            int arr[]=new int[noOfStalls];
            for(int i=0;i<noOfStalls;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int ans=solve(arr,noOfCows);
            System.out.println(ans);
        }
    }

    private static int solve(int[] arr, int noOfCows) {
        int minDist=0;
        int maxDist=arr[arr.length-1]-arr[0];
        int ans=0;
        while(maxDist>=minDist){
            int mid=(minDist+maxDist)/2;
            if(checkIfPossible(arr,noOfCows,mid)){
                ans=mid;
                minDist=mid+1;
            }else{
                maxDist=mid-1;
            }
        }
        return ans;
    }

    private static boolean checkIfPossible(int[] arr, int noOfCows, int dist) {
        int cowsPlaced=1; //placing the first cow at first stall by default
        int lastPos=arr[0];
        int currentDist=0;
        for(int i=1;i<arr.length;i++){
            currentDist+=(arr[i]-lastPos);
            if(currentDist>=dist){  //if minimum distance has been acheived for this cow, place it
                                    //and reset currentDist & update no of cows placed
                cowsPlaced++;
                currentDist=0;
            }
            lastPos=arr[i];
            if(cowsPlaced==noOfCows){ //when all cows have been placed with a min distance=dist
                return true;
            }
        }
        return false; //when we ran out of stalls
    }

}