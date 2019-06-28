import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class BEG_BST_Operations {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int queries = fastReader.nextInt();
			Node rootNode=null;
			while (queries-->0) {
				String queryType = fastReader.next();
				int nodeValue=fastReader.nextInt();
				if(queryType.equals("i")){
					rootNode=Node.insert(rootNode,nodeValue,1);
				}else if(queryType.equals("d")){
					rootNode=Node.delete(rootNode,nodeValue);
				}
			}
			bufferedWriter.write(stringBuffer.toString());
			bufferedWriter.flush();
		}catch (Exception e){
			return;
		}
	}

//	private static int findPositionForFilling(int nodeValue, int rootIndex) {
//		int actualIndex=rootIndex-1;
//		if(isOccupied[actualIndex]){
//			int pos;
//			if(arr[actualIndex]<nodeValue)
//				pos= findPositionForFilling(nodeValue,(2*rootIndex)+1);
//			else
//				pos= findPositionForFilling(nodeValue,2*rootIndex);
//			return pos;
//		}else
//			return rootIndex;
//	}
//	private static int findPosition(int nodeValue, int rootIndex){
//		int actualIndex=rootIndex-1;
//		if(isOccupied[actualIndex]){
//			int pos;
//			if(arr[actualIndex]==nodeValue)
//				return actualIndex+1;
//			else if(arr[actualIndex]>nodeValue)
//				return findPosition(nodeValue,2*(actualIndex+1));
//			else
//				return findPosition(nodeValue,2*(actualIndex+1)+1);
//		}else{
//			out.println("--not found--");
//			return -1;
//		}
//	}

	static class FastReader {
			BufferedReader br;
			StringTokenizer st;

			public FastReader(){
				br=new BufferedReader(new InputStreamReader(in));
			}
			String next(){
				while (st==null||!st.hasMoreElements()){
					try {
						st=new StringTokenizer(br.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return st.nextToken();
			}
			int nextInt(){
				return parseInt(next());
			}
		}
		static class Node{
		int data;
		Node left,right;
		int position;

			public Node(int data, int position) {
				this.data = data;
				this.left=null;
				this.right=null;
				this.position = position;
			}

			static Node insert(Node root,int data, int position){
				if(root==null){
					stringBuffer.append(position).append("\n");
					 return new Node(data,position);
				}
				if (data>root.data){
					root.right=insert(root.right,data,(2*position)+1);
				}else if(data<root.data){
					root.left=insert(root.left,data,(2*position));
				}
				return root;
			}
			static Node delete(Node root,int data){
				if(root==null){
					return root;
				}
				if(root.data==data){
					stringBuffer.append(root.position).append("\n");
					root=null;
				}else if(root.data>data){
					root.left=delete(root.left,data);
				}else if(root.data<data){
					root.right=delete(root.right,data);
				}
				return root;
			}
		}
}
