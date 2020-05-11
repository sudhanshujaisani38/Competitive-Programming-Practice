import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[] = new int[n + 1];
            int pos[] = new int[n + 1];
            boolean possibleByMachine[][] = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                pos[arr[i]] = i;
            }
            for (int i = 1; i <= m; i++) {
                int first = sc.nextInt();
                int sec = sc.nextInt();
                possibleByMachine[first][sec] = true;
                possibleByMachine[sec][first] = true;

                for(int j=1;j<=n;j++){
                    if(possibleByMachine[j][first] || possibleByMachine[j][sec]){
                        possibleByMachine[j][sec]=true;
                        possibleByMachine[sec][j]=true;
                        possibleByMachine[j][first]=true;
                        possibleByMachine[first][j]=true;
                    }
                }
            }
            // System.out.println("possible by machine:");
            // for(int i=1;i<=n;i++){
            //     for(int j=1;j<=n;j++){
            //         System.out.print(possibleByMachine[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[i] != i) {
                    if(!possibleByMachine[i][pos[i]]){
                        // System.out.println("leaving "+i+"for now");
                        continue;
                    }
                    // System.out.println("fixing:"+i);
                    // System.out.print("swapping:" + arr[i] + " & " + arr[pos[i]]);
                    int temp = arr[i];
                    arr[i] = arr[pos[i]];
                    arr[pos[i]] = temp;

                    if (!possibleByMachine[arr[i]][pos[arr[i]]]) {
                        ans++;
                        // System.out.println(" manually");
                    } else {
                        // System.out.println(" automatically");
                    }
                    pos[temp] = pos[i];
                    pos[i] = i;
                    // for (int j = 1; j <= n; j++) {
                    //     System.out.print(arr[j] + ",");
                    // }
                    // System.out.println();
                }
            }
            // System.out.println("------------");
            // for(int i=1;i<=n;i++){
            //     System.out.print(arr[i]+",");
            // }
            // System.out.println();
            for (int i = 1; i <= n; i++) {
                if (arr[i] != i) {
                    // System.out.print("swapping:" + arr[i] + " & " + arr[pos[i]]);
                    int temp = arr[i];
                    arr[i] = arr[pos[i]];
                    arr[pos[i]] = temp;

                    if (!possibleByMachine[arr[i]][pos[arr[i]]]) {
                        ans++;
                        // System.out.println(" manually");
                    } else {
                        // System.out.println(" automatically");
                    }
                    pos[temp] = pos[i];
                    pos[i] = i;
                    // for (int j = 1; j <= n; j++) {
                    //     System.out.print(arr[j] + ",");
                    // }
                    // System.out.println();
                }
            }
            System.out.println(ans);
        }
    }
}