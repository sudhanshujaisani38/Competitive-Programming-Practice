import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Graph {
	int noOfNodes;
	HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
	boolean isVisited[];
	HashMap<Pair,Integer> ans=new HashMap<>();
	// static int dp[][];
	// static boolean ansAvailable[][];

	public Graph(int n) {
		this.noOfNodes = n;
		isVisited = new boolean[n];
		ans=new HashMap<>();
		// dp = new int[n + 1][n + 1];
		// ansAvailable = new boolean[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			adjList.put(i, new ArrayList<Integer>());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
			for (int i = 0; i < q; i++) {
				g.isVisited = new boolean[n + 1];
				int first = sc.nextInt();
				int sec = sc.nextInt();
				if (g.ans.get(new Pair(first,sec))!=null) {
					System.out.println(g.ans.get(new Pair(first,sec)));
					continue;
				}
				int parentOf[] = new int[n + 1];
				g.actualDFS(first, sec, parentOf);
				int parent = sec;
				ArrayList<Integer> list = new ArrayList<>();
				while (parent != first) {
					list.add(a[parent]);
					parent = parentOf[parent];
				}
				list.add(a[first]);
				// System.out.println(list);
				Collections.sort(list);
				int minDiff = Integer.MAX_VALUE;
				for (int j = 0; j < list.size() - 1; j++) {
					int diff = list.get(j + 1) - list.get(j);
					minDiff = Math.min(minDiff, diff);
				}
				// dp[first][sec] = minDiff;
				// ansAvailable[first][sec] = true;
				g.ans.put(new Pair(first,sec), minDiff);
				g.ans.put(new Pair(sec,first), minDiff);
				System.out.println(minDiff);
			}
		}
	}

	public void addEdge(int x, int y) {
		adjList.get(x).add(y);
		adjList.get(y).add(x);
	}

	private boolean actualDFS(int src, int dest, int parentOf[]) {
		// System.out.print(src + ",");
		isVisited[src] = true;
		ArrayList<Integer> neighbours = adjList.get(src);
		for (Integer neighbour : neighbours) {
			if (!isVisited[neighbour]) {
				parentOf[neighbour] = src;
				if (neighbour == dest) {
					return true;
				}
				boolean destFound = actualDFS(neighbour, dest, parentOf);
				if (destFound) {
					return true;
				}

			}
		}
		return false;
	}

	static class Pair implements Comparable<Pair>{
		int first;
		int sec;

		public Pair(int d, int c) {
			first = d;
			sec = c;
		}

		@Override
		public int compareTo(Pair o) {
			if(o.first==this.first && o.sec==this.sec){
				return 0;
			}
			return this.first-o.first;
		}
		
	}

}