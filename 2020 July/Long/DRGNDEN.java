import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
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
    static final boolean SHOW_LOGS = true;

    public static void main(String[] args) throws Exception {
        try {

            int testCases = 1;
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int q = fastReader.nextInt();
                int h[] = new int[n + 1];
                long arr[] = new long[n + 1];
                for (int i = 1; i <= n; i++) {
                    h[i] = fastReader.nextInt();
                }
                for (int i = 1; i <= n; i++) {
                    arr[i] = fastReader.nextLong();
                }
                SegmentTree tree = new SegmentTree(n);
                tree.build(h, arr, 1, n, tree.root);
                // tree.print(tree.root, false);
                while (q-- > 0) {
                    int type = fastReader.nextInt();
                    if (type == 1) {
                        int index = fastReader.nextInt();
                        int newA = fastReader.nextInt();
                        tree.pointUpdate(index, newA, tree.root);
                        arr[index] = newA;
                        // tree.print(tree.root, false);
                    } else {
                        int l = fastReader.nextInt();
                        int r = fastReader.nextInt();
                        if (l == r) {
                            System.out.println(arr[l]);
                            continue;
                        }
                        if (h[l] <= h[r]) {
                            System.out.println(-1);
                            continue;
                        }
                        int maxHeight = Math.max(h[l], h[r]);
                        int minHeight = Math.min(h[l], h[r]);
                        boolean isLR = true;
                        if (l > r) {
                            isLR = false;
                            int temp = l;
                            l = r;
                            r = temp;
                        }
                        int maxObtained[]=new int[1];
                        long ans = tree.query(l + 1, r - 1, tree.root, maxHeight - 1, minHeight + 1, isLR,maxObtained);
                        if (ans != -1) {
                            ans += arr[l];
                            ans += arr[r];
                        }
                        System.out.println(ans);
                    }
                }
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (OutOfMemoryError e) {
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

        public void build(int h[], long arr[], int start, int end, SegNode node) {
            if (start == end) {
                node.start = start;
                node.end = start;
                if (node.dataLR == null) {
                    node.dataLR = new Data[2];
                    node.dataRL=new Data[2];
                }
                node.dataLR[1] = new Data(arr[start], h[start], start);
                node.dataRL[1] = new Data(arr[start], h[start], start);
                return;
            }
            node.left = new SegNode();
            node.right = new SegNode();
            int mid = (start + end) / 2;
            node.left.data = new Data[mid - start + 2];
            node.right.data = new Data[end - mid + 1];
            node.left.indexOfPos = new int[node.left.data.length];
            node.right.indexOfPos = new int[node.right.data.length];
            node.indexOfPos = new int[end - start + 2];
            build(h, arr, start, mid, node.left);
            build(h, arr, mid + 1, end, node.right);
            // System.out.println("sending for merge:"+node.left.start+","+node.left.end+" &
            // "+node.right.start+","+node.right.end);
            node.data = merge(node.left.data, node.right.data, node.indexOfPos, node.left.start);
            node.start = node.left.start;
            node.end = node.right.end;
        }

        static int firstIndexOf(Data arr[], Data element) {
            int n = arr.length;
            int high = n - 1, low = 1;
            while (high > low) {
                int mid = (high + low) / 2;
                if (arr[mid].compareTo(element) == 0 && (mid == 0 || arr[mid].compareTo(arr[mid - 1]) > 0)) {
                    return mid;
                }
                if (element.compareTo(arr[mid]) > 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (element.compareTo(arr[low]) > 0) {
                return low + 1;
            } else {
                return low;
            }
        }

        static int lastIndexOf(Data arr[], Data element) {
            int n = arr.length;
            int high = n - 1, low = 1;
            while (high > low) {
                int mid = (high + low) / 2;
                if (arr[mid].compareTo(element) == 0 && (mid == n - 1 || arr[mid].compareTo(arr[mid + 1]) < 0)) {
                    return mid;
                }
                if (element.compareTo(arr[mid]) < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (element.compareTo(arr[low]) > 0) {
                return low + 1;
            } else {
                return low;
            }
        }

        private Data[] merge(Data[] data, Data[] data2, int indexOfPos[], int start) {
            int n = data.length + data2.length;
            Data finalData[] = new Data[n - 1];
            // System.out.println("size="+indexOfPos.length);
            int i = 1, j = 1, k = 1;
            while (i < data.length && j < data2.length) {
                if (data[i].h > data2[j].h) {
                    finalData[k] = data2[j];
                    indexOfPos[data2[j].pos - start + 1] = k;
                    j++;
                } else {
                    finalData[k] = data[i];
                    // System.out.println("i:"+i);
                    indexOfPos[data[i].pos - start + 1] = k;
                    i++;
                }
                k++;
            }
            while (i < data.length) {
                finalData[k] = data[i];
                indexOfPos[data[i].pos - start + 1] = k;
                k++;
                i++;
            }
            while (j < data2.length) {
                finalData[k] = data2[j];
                indexOfPos[data2[j].pos - start + 1] = k;
                k++;
                j++;
            }
            return finalData;
        }

        public long query(int start, int end, SegNode node, int maxHeight, int minHeight, boolean isLR,int []maxObtained) {
            // System.out.println("querying:"+start+","+end+" in "+node.start+","+node.end+"range:"+minHeight+":"+maxHeight);
            if (node.start > end || node.end < start) {
                // System.out.println("no overlap");
                return 0;
            }

            if (node.start >= start && node.end <= end) {
                // System.out.println("overlap at:"+node.start+","+node.end);
                int len = node.data.length;
                if (node.data[len - 1].h > maxHeight) {
                    // System.out.println("higher pole of length:"+node.data[len-1].h);
                    return -1;
                }
                Data stdata = new Data(0, minHeight, start);
                Data eData = new Data(0, maxHeight, end);
                int endIndex = firstIndexOf(node.data, eData);
                int stIndex = lastIndexOf(node.data, stdata);
                // int endIndex = Arrays.binarySearch(node.data, 1, node.data.length, eData);
                // int stIndex = Arrays.binarySearch(node.data, 1, node.data.length, stdata);
                // if (endIndex < 0) {
                // endIndex *= -1;
                // endIndex--;
                // endIndex--;
                // }
                // if (stIndex < 0) {
                // stIndex *= -1;
                // stIndex--;
                // }
                if(endIndex==node.data.length)
                endIndex--;
                // System.out.println("Index:"+stIndex+","+endIndex+" search key:"+minHeight+","+maxHeight);
                // for(int i=1;i<node.data.length;i++){
                // System.out.print(node.data[i].h+",");
                // }
                // System.out.println();

                long ans = 0l;
                int currPos;
                if (isLR) {
                    currPos = start-1;
                } else {
                    currPos = end+1;
                }
                maxObtained[0]=minHeight;
                int currH;
                int prevH=-1;
                for (int i = stIndex; i <= endIndex; i++) {
                    currH=node.data[i].h;
                    if(currH==prevH){
                        if(isLR){
                            if(node.data[i-1].pos<node.data[i].pos){
                                currPos=node.data[i].pos;
                                ans-=node.data[i-1].a;
                                ans+=node.data[i].a;
                            }
                        }else{
                            if(node.data[i-1].pos>node.data[i].pos){
                                currPos=node.data[i].pos;
                                ans-=node.data[i-1].a;
                                ans+=node.data[i].a;
                            }
                        }
                    }
                    // System.out.println("currPos:"+currPos);
                    if (isLR && node.data[i].pos > currPos) {
                        ans += node.data[i].a;
                        maxObtained[0]=Math.max(maxObtained[0], node.data[i].h);
                        // System.out.println("adding:"+node.data[i].pos+", currPos:"+currPos);
                        currPos=node.data[i].pos;
                    }else
                    if(!isLR && node.data[i].pos<currPos){
                        // System.out.println("rev adding:"+node.data[i].pos+", currPos:"+currPos);
                        ans+=node.data[i].a;
                        maxObtained[0]=Math.max(maxObtained[0], node.data[i].h);
                        // System.out.println("before assigning:"+node.data[i].pos+","+currPos);
                        currPos=node.data[i].pos;
                        // System.out.println("after assigning:"+node.data[i].pos+","+currPos);
                        
                    }
                }
                return ans;
            }
            // System.out.println("partial overlap at "+node.start+","+node.end);
            long leftAns = query(start, end, node.left, maxHeight, minHeight,isLR,maxObtained);
            int max1=maxObtained[0];
            // System.out.println("back at "+node.start+","+node.end);
            long rightAns = query(start, end, node.right, maxHeight, minHeight,isLR,maxObtained);
            int max2=maxObtained[0];
            // System.out.println("back at "+node.start+","+node.end);
            if (leftAns == -1 || rightAns == -1) {
                return -1;
            }
            // System.out.println("left ans:"+leftAns+", rightAns"+rightAns);
            long actualAns;
            // System.out.println("at:"+node.start+","+node.end+" max1:"+max1+",max2:"+max2);
            if(!isLR){
                actualAns=leftAns;
                if(max2>max1){
                    actualAns+=rightAns;
                }
            }else{
                actualAns=rightAns;
                if(max1>max2){
                    actualAns+=leftAns;
                }
            }
            // System.out.println("returning :"+actualAns);
            maxObtained[0]=Math.max(max1, max2);
            return actualAns;
        }

        public void pointUpdate(int index, long increment, SegNode node) {
            if (node.start == index && node.end == index) {
                node.data[1].a = increment;
                return;
            }
            if (index < node.start || index > node.end) {
                return;
            }
            int mid = (node.start + node.end) / 2;
            if (index > mid) {
                pointUpdate(index, increment, node.right);
            } else {
                pointUpdate(index, increment, node.left);
            }
            int in = node.indexOfPos[index - node.start + 1];
            // System.out.println("updating a of index:"+in+" at "+node.start+","+node.end);
            node.data[in].a = increment;
        }

        static class SegNode {
            Data dataLR[];
            Data dataRL[];
            long accLR[];
            long accRL[];
            SegNode left;
            SegNode right;
            int start;
            int end;
            int indexOfPos[];

            boolean isLeaf() {
                return (start == end);
            }
        }

        static class Data implements Comparable<Data> {
            long a;
            int h;
            int pos;

            public Data(long a, int h, int pos) {
                this.a = a;
                this.h = h;
                this.pos = pos;
            }

            @Override
            public int compareTo(Data o) {
                if (this.h == o.h)
                    return this.pos - o.pos;
                return this.h - o.h;
            }
        }

        public void print(SegNode node, boolean wantLazy) {
            if (node == null) {
                return;
            }
            for (int i = 1; i <= node.end - node.start + 1; i++) {
                debug(node.data[i].h + "(" + node.data[i].pos + "),");
            }
            debugn("(" + node.start + "," + node.end + ")");
            print(node.left, wantLazy);
            print(node.right, wantLazy);
        }
    }

    static void debugn(Object obj) {
        if (SHOW_LOGS) {
            System.out.println(obj);
        }
    }

    static void debug(Object obj) {
        if (SHOW_LOGS) {
            System.out.print(obj);
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