import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
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
    public static final int MOD = 998244353;

    public static void main(String[] args) throws Exception {
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {
                String s = fastReader.next();
                long weights[] = new long[26];
                for (int i = 0; i < 26; i++) {
                    weights[i] = fastReader.nextLong();
                }
                int n = s.length();
                Trie trie = new Trie();
                long total = 0l;
                for (int i = 0; i < n; i++) {
                    String temp = "";
                    long w = 0l;
                    for (int j = i; j < n; j++) {
                        temp = temp + s.charAt(j);
                        w += weights[s.charAt(j) - 'a'];
                        trie.insert(temp, temp, w, false);
                        total++;
                        String rs = createRolStr(temp, s.length());
                        trie.insert(rs, temp, w, true);
                    }
                }
                long ans = 0l;
                ans = trie.getTotalPower(trie.rootNode);
                long q = modInverse2(total, MOD);
                long finalAns = ((ans % MOD) * (q % MOD)) % MOD;
                System.out.println(finalAns);

            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static String createRolStr(String st, int length) {
        int rem = length - st.length();
        StringBuilder sb = new StringBuilder(st);
        while (rem >= st.length()) {
            sb.append(st);
            rem -= st.length();
        }
        if (rem > 0) {
            sb.append(st.substring(0, rem));
        }
        return sb.toString();
    }

    static long modInverse2(long a, long m) {
        long m0 = m;
        long y = 0, x = 1;
        if (m == 1)
            return 0;
        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }

    static class Trie {
        Node rootNode;

        public Trie() {
            rootNode = new Node('\0');
        }

        public long getTotalPower(Node node) {
            if (node.children.isEmpty())
                return 0;
            long ans = 0l;
            for (char key : node.children.keySet()) {
                Node n = node.children.get(key);
                if (n.isTerminal) {
                    ans += (n.power * n.freq);
                }
                ans += (getTotalPower(n));
            }
            return ans;
        }

        void insert(String word, String parent, long parentWt, boolean isRolling) {
            Node node = rootNode;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (node.children.get(c) != null) {
                    node = node.children.get(c);
                } else {
                    Node newNode = new Node(c);
                    node.children.put(c, newNode);
                    node = newNode;
                }
                if (isRolling && (i + 1) >= parent.length()) {
                    // System.out.println("adding " + parent + " as parent:" + i);
                    if (!node.parentStrings.contains(parent)) {
                        node.parentStrings.add(parent);
                        node.power += parentWt;
                    }
                }
            }
            // node.parentStrings.add(parent);
            if (!isRolling) {
                node.isTerminal = true;
                node.wt = parentWt;
                node.freq++;
            }
        }

        Node get(String word) {
            Node node = rootNode;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (node.children.get(c) == null) {
                    return null;
                } else {
                    node = node.children.get(c);
                }
            }
            return node;
        }

        static class Node {
            char data;
            HashMap<Character, Node> children;
            boolean isTerminal;
            HashSet<String> parentStrings = new HashSet<>();
            long freq;
            long wt;
            boolean visited;
            long power;

            public Node(char data) {
                // System.out.println("new node:" + data);
                this.data = data;
                this.children = new HashMap<>();
                isTerminal = false;
            }
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