import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        outer: while (testCases-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int steps[][] = new int[k][3];
            int stepsTaken = 0;
            int arr[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            int start = 1;
            int end = n;
            int mid = (start + end) / 2;
            while (end - start >= 2 && stepsTaken < k) {
                if (end - start == 2 && (n&1)==0) {
                    // System.out.println("reverse case!");
                    mid=start+1;
                    steps[stepsTaken][0]=end;
                    steps[stepsTaken][1]=mid;
                    steps[stepsTaken][2]=start;
                    int temp=arr[start];
                    // System.out.println("start:"+arr[start]+",mid:"+arr[mid]+",end:"+arr[end]);
                    arr[start]=arr[mid];
                    arr[mid]=arr[end];
                    arr[end]=temp;
                } else {
                    steps[stepsTaken][0] = start;
                    steps[stepsTaken][1] = mid;
                    steps[stepsTaken][2] = end;
                    int temp = arr[end];
                    arr[end] = arr[mid];
                    arr[mid] = arr[start];
                    arr[start] = temp;
                }
                stepsTaken++;
                if (arr[start] == start)
                    start++;
                if (arr[end] == end)
                    end--;
                // System.out.println("start:" + start + "end:" + end);
                // for (int i = 1; i <= n; i++) {
                //     System.out.print(arr[i] + ",");
                // }
                // System.out.println();
            }
            for (int i = 1; i <= n; i++) {
                if (arr[i] != i) {
                    System.out.println(-1);
                    continue outer;
                }
            }
            System.out.println(stepsTaken);
            for (int i = 0; i < stepsTaken; i++) {
                System.out.println(steps[i][0] + " " + steps[i][1] + " " + steps[i][2]);
            }

        }
    }
}