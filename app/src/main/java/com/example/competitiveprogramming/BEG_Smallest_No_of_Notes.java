import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BEG_Smallest_No_of_Notes {
static FastReader fastReader=new FastReader();
static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
static StringBuffer stringBuffer=new StringBuffer();
static int notes[]=new int[]{1,2,5,10,50,100};
public static void main(String[] args) {
	try {
		int testCases = fastReader.nextInt();
		int count;
		while (testCases-->0) {
			count=0;
			int num=fastReader.nextInt();
			for(int i=5;i>-1;i--){
				count+=num/notes[i];
				num=num%notes[i];
				if(num==0)break;
			}
			stringBuffer.append(count).append("\n");
		}
		bufferedWriter.write(stringBuffer.toString());
		bufferedWriter.flush();
	}catch (Exception e){
		e.printStackTrace();
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
