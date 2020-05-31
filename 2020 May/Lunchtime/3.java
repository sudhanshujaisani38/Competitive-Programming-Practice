//this problem didn't worked without fast reader -_-
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Graph {
	int noOfNodes;
	HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
	boolean isVisited[];
	int parentOf[];
	int depth[];

	public Graph(int n) {
		this.noOfNodes = n;
		isVisited = new boolean[n + 1];
		depth = new int[n + 1];
		parentOf = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			adjList.put(i, new ArrayList<Integer>());
		}
	}

	public void addEdge(int x, int y) {
		adjList.get(x).add(y);
		adjList.get(y).add(x);
	}

	private void actualDFS(int src, int d) {
		isVisited[src] = true;
		this.depth[src] = d;
		ArrayList<Integer> neighbours = adjList.get(src);
		for (Integer neighbour : neighbours) {
			if (!isVisited[neighbour]) {
				parentOf[neighbour] = src;
				actualDFS(neighbour, d + 1);
			}
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			Graph g = new Graph(n);
			int a[] = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < (n - 1); i++) {
				int first = sc.nextInt();
				int sec = sc.nextInt();
				g.addEdge(first, sec);
			}
			g.actualDFS(1, 0);
			// Arrays.stream(g.depth).forEach(e -> System.out.print(e + ","));
			// System.out.println();
			// Arrays.stream(g.parentOf).forEach(e -> System.out.print(e + ","));
			// System.out.println();
			for (int i = 0; i < q; i++) {
				int first = sc.nextInt();
				int sec = sc.nextInt();
				int ans = g.solve(first, sec, a);
				System.out.println(ans);

			}
		}
	}

	private int solve(int first, int sec, int a[]) {
		boolean alreadyFound[] = new boolean[101];
		int d1 = depth[first];
		int d2 = depth[sec];
		if (d1 > d2) {
			while (d1 != d2) {
				if (alreadyFound[a[first]])
					return 0;
				alreadyFound[a[first]] = true;
				d1--;
				first = parentOf[first];
			}

		} else {
			while (d1 != d2) {
				if (alreadyFound[a[sec]])
					return 0;
				alreadyFound[a[sec]] = true;
				// list.add(a[sec]);
				d2--;
				sec = parentOf[sec];
			}

		}
		while (first != sec) {
			if (alreadyFound[a[first]])
				return 0;
			alreadyFound[a[first]] = true;
			if (alreadyFound[a[sec]])
				return 0;
			alreadyFound[a[sec]] = true;
			first = parentOf[first];
			sec = parentOf[sec];
		}
		if (alreadyFound[a[first]])
			return 0;
		alreadyFound[a[first]] = true;
		// System.out.println(list);
		// Arrays.stream(list).forEach(e->System.out.print(e+","));System.out.println();
		// Arrays.sort(list);
		int minDiff = Integer.MAX_VALUE;
		int prev = -1;
		for (int j = 1; j <= 100; j++) {
			if (alreadyFound[j]) {
				if (prev != -1) {
					int diff = j - prev;
					minDiff = Math.min(minDiff, diff);
				}
				prev = j;
			}

		}
		return minDiff;
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
