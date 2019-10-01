import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class SEPT_LT19_1 {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			nextCase:while (testCases-->0) {
				int n=fastReader.nextInt();
				int m=fastReader.nextInt();
				int cat[]=new int[m+1];
				int alreadyEatenCountOfCat[]=new int[n+1];
				for(int i=1;i<=m;i++){
					cat[i]=fastReader.nextInt();
				}
				int expected=0;
				Arrays.fill(alreadyEatenCountOfCat,0);
				for(int i=1;i<=m;i++){
//					System.out.println(i+" Expected:"+expected);

					if(alreadyEatenCountOfCat[cat[i]]!=expected){
//						System.out.println("aborting..expected "+expected+"found "+alreadyEatenCountOfCat[cat[i]]);
						stringBuffer.append("NO").append("\n");
						continue nextCase;
					}else{
						alreadyEatenCountOfCat[cat[i]]++;
					}
					if(i%n==0){
						//System.out.println("incrementing");
						expected++;
					}
				}
				stringBuffer.append("YES").append("\n");

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
