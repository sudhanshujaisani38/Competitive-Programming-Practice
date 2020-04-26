
//given an array,find the number of inversion counts
//an inversion is a pair of numbers such that bigger number comes before smaller number in the array
import java.util.Scanner;

class InversionCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = solve(arr, 0, n - 1);
        System.out.println(ans);
    }

    private static int solve(int[] arr, int start, int end) {
        // base case:only one element in the array
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int leftAns = solve(arr, start, mid); // no of inversion pairs in left part
        int rightAns = solve(arr, mid + 1, end);// no of inversion pairs in right part
        int crossInversions = merge(arr, start, end); // cross inversions
        return leftAns + rightAns + crossInversions;
    }

    // simple merge sort logic
    private static int merge(int[] arr, int start, int end) {
        int crossInversions = 0;
        int mid = (start + end) / 2;
        int temp[] = new int[end - start + 1];
        int i = 0, j = mid + 1, k = 0;

        for (i = start, j = mid + 1; i <= mid && j <= end;) {
            if (arr[i] > arr[j]) {
                crossInversions += (mid - i + 1); // all the numbers after arr[i] in left will be greater than arr[j]
                temp[k] = arr[j];
                j++;
            } else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= end) {
                temp[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                temp[k] = arr[i];
                i++;
                k++;
            }
        }
        //copy back to the original array
        for (int s = start; s <= end; s++) {
            arr[s] = temp[s - start];
        }
        return crossInversions;
    }

}