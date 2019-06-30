import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class BEG_Cutting_Recipes {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	static int arr[]=new int[50];
	public static void main(String[] args) {
		try {int min=0;
			int testCases = fastReader.nextInt();
			while (testCases-->0) {
				Arrays.fill(arr,0);
				int num=fastReader.nextInt();
				for(int i=0;i<num;i++){
					arr[i]=fastReader.nextInt();
					if(arr[i]<min)
						min=arr[i];
				}
				if(min==1){
					for (int i=0;i<num;i++){
						stringBuffer.append(arr[i]).append("\n");
					}
					continue;
				}
				for(int i=min;i>1;i--){
					int val;
					boolean found=true;
					for(int j=0;j<num;j++)
						if(j%i!=0) {
							found=false;
						}
					if(found){
						for (int i2=0;i2<num;i2++){
							stringBuffer.append(arr[i2]/2).append("\n");
						}
					}
				}
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
