import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class BEG_Piece_of_code {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	static ArrayList<Character> arrayList=new ArrayList<>();

	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			while (testCases-->0) {
				String str=fastReader.next();
				int arr[]=new int[str.length()];
				for(int i=0;i<str.length();i++){
					if(!arrayList.contains(str.charAt(i)))
						arrayList.add(str.charAt(i));
					arr[arrayList.indexOf(str.charAt(i))]++;
				}
				Arrays.sort(arr);
				int sum=0;
				for(int i=0;i<str.length()-1;i++){
					sum+=arr[i];
				}
				if(sum==arr[str.length()-1])
					stringBuffer.append("YES\n");
				else
					stringBuffer.append("NO\n");
			}
			bufferedWriter.write(stringBuffer.toString());
			bufferedWriter.flush();
		}catch (Exception e){
			return;
		}
	}

	static class FastReader {
			BufferedReader br;
			StringTokenizer st;

			public FastReader(){
				br=new BufferedReader(new InputStreamReader(System.in));
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
			String nextLine(){
				String str="";
				try {
					str=br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return str;
			}
			int nextInt(){
				return Integer.parseInt(next());
			}
			long nextLong(){
				return Long.parseLong(next());
			}
			double nextDouble(){
				return Double.parseDouble(next());
			}
		}
}
