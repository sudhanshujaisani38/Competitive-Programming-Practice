/*
given a pile of stones of k stones initially and a set of n positive integers,
a game in which you can remove any number of stones such that that number exists 
in the set. Find who will win.

note: in easy words, for which player is the current state the winning state
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;

class K {
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
            // int testCases = fastReader.nextInt();
            int testCases = 1;
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int k = fastReader.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = fastReader.nextInt();
                }
                boolean isWinningState[] = new boolean[k + 1];

                /*
                from the current state (height of pile), if you can go to any state
                which is a loosing state (for opposition), then current state is winning state
                */
                for (int currPileHeight = 1; currPileHeight <= k; currPileHeight++) {       //loop for all possible states
                    for (int setIndex = 0; setIndex < n; setIndex++) {                      //loop for all possible transitions
                        if (currPileHeight - arr[setIndex] < 0) {
                            break; //safety check for negative index
                        }
                        if (!isWinningState[currPileHeight - arr[setIndex]]) {
                            isWinningState[currPileHeight] = true;
                            break;
                        }

                    }
                }
                if(isWinningState[k]){
                    System.out.println("First");
                }else{
                    System.out.println("Second");
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