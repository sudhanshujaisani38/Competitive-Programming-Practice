import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

class BEG_Ciel_and_Receipt {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
	static StringBuffer stringBuffer=new StringBuffer();
	static int[] menuItem=new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048};
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int count;
			while (testCases-->0) {
				count=0;
				int num=fastReader.nextInt();
				for(int i=11;i>-1;i--){
//					out.println(menuItem[i]);
					count+=(num/menuItem[i]);
//					out.println(menuItem[i]+":"+num/menuItem[i]);
					num=num%menuItem[i];
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
}
