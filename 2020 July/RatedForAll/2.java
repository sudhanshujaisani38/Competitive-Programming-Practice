import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static {
        try {
            System.setOut(new PrintStream(new File("output.txt")));
            new File("input.txt").createNewFile();
            System.setIn(new FileInputStream(new File("input.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {
                String s = fastReader.next();
                int n = s.length();
                Stack<Character> stack = new Stack<>();
                Stack<Integer> numStack = new Stack<>();
                int ans[] = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);
                    if (c == ')') {
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                            ans[numStack.pop()] = (i + 1);

                            while (!stack.isEmpty() && stack.peek() != '(') {
                                stack.pop();
                                ans[numStack.pop()] = (i + 1);
                            }
                        }
                        stack.push(')');
                        numStack.push(i + 1);
                    } else {
                        stack.push('(');
                        numStack.push(i + 1);
                    }
                    // System.out.println(stack);
                    // System.out.println(numStack);
                }
                while (!stack.isEmpty()) {
                    stack.pop();
                    ans[numStack.pop()] = -1;
                }
                int q = fastReader.nextInt();
                while (q-- > 0) {
                    int in = fastReader.nextInt();
                    System.out.println(ans[in]);
                }

            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
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