import java.util.Scanner;

//program to find the maximum no in a sorted array which is rotated using binary search
//Divide & Conquer
class CB_Pivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = findPivot(arr, 0, n - 1);
        System.out.println(ans);
    }

    private static int findPivot(int[] arr, int start, int end) {
        System.out.println(start + ":" + end);
        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid + 1]) {          // if mid is greater than the number ahead then it is the point.
            return arr[mid];
        } else if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {    // if mid is smaller than the number ahead &&
                                                                            // before both, then previous no is the ans
            return arr[mid - 1];
        } else {                                        // the normal case i.e mid is greater than prev & smaller than next
            if (arr[mid] > arr[end]) {                  // if right part is unsorted, then the answer must lie in that section
                return findPivot(arr, mid + 1, end);
            } else {                                    // else in the left part
                return findPivot(arr, start, mid - 1);
            }
        }
    }
}