import java.util.Scanner;

class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ele=sc.nextInt();
        int index=searchInSortedRotatedArray(arr,0,n-1,ele);
        if(index==-1){
            System.out.println("element not found!");
        }else{
            System.out.println("found at:"+index);
        }
    }

    private static int searchInSortedRotatedArray(int[] arr, int start, int end, int ele) {
        int mid;
        while(end>start){
            mid=(start+end)/2;
            if(arr[mid]==ele){
                return mid;
            }
            if(arr[start]<arr[end]){
                return binarySearch(arr,start,end,ele);
            }
            if(ele>arr[mid] && ele<=arr[end]){
                start=mid+1;
            }
            if(ele>=arr[start] && ele<arr[mid]){
                end=mid-1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int start, int end, int ele) {
        int mid;
        while(end>start){
            mid=(start+end)/2;
            if(arr[mid]==ele){
                return mid;
            }
            if(ele>arr[mid]){
                start=mid+1;
            }
            if(ele<arr[mid]){
                end=mid-1;
            }
        }
        return -1;
    }
}