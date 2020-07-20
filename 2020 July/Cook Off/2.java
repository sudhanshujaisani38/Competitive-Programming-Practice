import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.HashMap;
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
    static HashMap<Long, Integer> freq = new HashMap<>();

    public static void main(String[] args) throws Exception {
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            ts:while (testCases-- > 0) {
                int n = fastReader.nextInt();
                long arr[] = new long[n+1];
                long arr1[]=new long[n+1];
                long or[]=new long[n+1];
                // long orr=0l;
                for (int i = 1; i <= n; i++) {
                    arr[i] = fastReader.nextLong();
                    arr1[i]=arr[i];
                    // or[i]=orr|arr[i];
                }
                freq=new HashMap<>();
                
                for(int i=1;i<=n;i++){
                    long orr=0l;
                    for(int j=i;j<=n;j++){
                        orr=arr[j]|orr;
                        int f=freq.getOrDefault(orr, 0);
                        if(f!=0){
                            System.out.println("NO");
                            continue ts;
                        }
                        freq.put(orr, f+1);
                    }
                }
                // freq = new HashMap<>();

                // System.out.println(freq);
                // for(int f:freq.values()){
                //     if(f!=1){
                //         System.out.println("NO");
                //         continue ts;
                //     }
                // }
                System.out.println("YES");

            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    static class SegmentTree {
        int size;
        int tree[];
        SegNode root;

        public SegmentTree(int n) {
            size = n;
            root = new SegNode();
        }

        public void build(long arr[], int start, int end, SegNode node) {
            if (start == end) {
                node.start = start;
                node.end = start;
                node.data = arr[start];
                int f = freq.getOrDefault(node.data, 0);
                freq.put(node.data, f+1);
                return;
            }
            node.left = new SegNode();
            node.right = new SegNode();
            int mid = (start + end) / 2;
            build(arr, start, mid, node.left);
            build(arr, mid + 1, end, node.right);
            node.data = (node.left.data | node.right.data);
            node.start = node.left.start;
            node.end = node.right.end;
            int f = freq.getOrDefault(node.data, 0);
            freq.put(node.data, f+1);
        }

        public long query(int start, int end, SegNode node) {
            if (node.start > end || node.end < start) {
                return 0;
            }
            if (node.start >= start && node.end <= end) {
                return node.data;
            }
            long leftAns = query(start, end, node.left);
            long rightAns = query(start, end, node.right);
            return (leftAns | rightAns);
        }

        static class SegNode {
            long data;
            SegNode left;
            SegNode right;
            int start;
            int end;
            int lazyValue;

            void resolveLazyValue() {
                if (this.lazyValue != 0) {
                    this.data += this.lazyValue;
                    if (this.start != this.end) {
                        this.left.lazyValue += this.lazyValue;
                        this.right.lazyValue += this.lazyValue;
                    }
                    this.lazyValue = 0;
                }
            }

            boolean isLeaf() {
                return (start == end);
            }
        }

        // prints the preorder traversal of segment tree, also prints lazy value of each
        // node
        // if wantLazy is passed true;
        public void print(SegNode node, boolean wantLazy) {
            if (node == null) {
                return;
            }
            System.out.print(node.data);
            if (wantLazy) {
                System.out.print("(" + node.lazyValue + ")");
            }
            System.out.print(",");
            print(node.left, wantLazy);
            print(node.right, wantLazy);
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