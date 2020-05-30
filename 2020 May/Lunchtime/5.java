import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();
    static final int INFINITY = 10000000;

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            test: while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int arr[] = new int[n];
                int firstIndex = -1;
                for (int i = 0; i < n; i++) {
                    arr[i] = fastReader.nextInt();
                    if (arr[i] == 1 && firstIndex == -1) {
                        firstIndex = i;
                    }
                }
                int left[] = new int[n];
                int right[] = new int[n];
                int move[] = new int[n];

                if (firstIndex == -1) {
                    System.out.println(0);
                    continue;
                }
                left[firstIndex] = INFINITY;
                right[n - 1] = INFINITY;
                // System.out.println("here");
                for (int i = firstIndex + 1; i <= (n - 1); i++) {
                    if (arr[i - 1] == 1) {
                        left[i] = 1;
                    } else {
                        left[i] = left[i - 1] + 1;
                        // System.out.println("INFINITY+1");
                        // System.out.println(INFINITY+2);
                    }
                }
                if (arr[n - 1] == 1) {
                    left[0] = 1;
                } else {
                    left[0] = left[n - 1] + 1;
                }
                for (int i = 1; i <= firstIndex; i++) {
                    if (arr[i - 1] == 1) {
                        left[i] = 1;
                    } else {
                        left[i] = left[i - 1] + 1;
                        // System.out.println("INFINITY+1");
                        // System.out.println(INFINITY+2);
                    }
                }
                // System.out.print("left:");
                // Arrays.stream(left).forEach(e -> System.out.print(e + ","));
                // System.out.println();
                for (int i = firstIndex - 1; i >= 0; i--) {
                    if (arr[i + 1] == 1) {
                        right[i] = 1;
                    } else {
                        right[i] = right[i + 1] + 1;
                    }
                }
                if (arr[0] == 1) {
                    right[n - 1] = 1;
                } else {
                    right[n - 1] = right[0] + 1;
                }
                for (int i = n - 2; i >= firstIndex; i--) {
                    if (arr[i + 1] == 1) {
                        right[i] = 1;
                    } else {
                        right[i] = right[i + 1] + 1;
                    }
                }
                // System.out.print("right:");
                // Arrays.stream(right).forEach(e -> System.out.print(e + ","));
                // System.out.println();
                int steps = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == 1) {
                        // System.out.println("handling index:"+i);
                        if (left[i] >= INFINITY && right[i] >= INFINITY) {
                            stringBuffer.append("-1\n");
                            // System.out.println(-1);
                            continue test;
                        }
                        if (left[i] > right[i]) {
                            if(i+right[i]>n-1){
                                arr[right[i]-1]++;
                            arr[i] = 0;
                            steps += right[i];
                            }else{

                            arr[i + right[i]]++;
                            arr[i] = 0;
                            steps += right[i];
                            }
                            // System.out.println("moving right");
                        } else {
                            if(i-left[i]<0){

                            arr[i] += (arr[left[i]+1]);
                            arr[left[i]+1] = 0;
                            steps += left[i];
                            }else{

                            arr[i] += (arr[i - left[i]]);
                            arr[i - left[i]] = 0;
                            steps += left[i];
                            }
                            // System.out.println("fetching left");
                        }
                        // Arrays.stream(arr).forEach(e->System.out.print(e+","));System.out.println();
                    }
                }
                stringBuffer.append(steps).append("\n");
                // System.out.println(steps);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}