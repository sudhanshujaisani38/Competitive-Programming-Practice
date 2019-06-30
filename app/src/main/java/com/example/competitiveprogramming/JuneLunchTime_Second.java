import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class JuneLunchTime_Second {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int boysEven=0,girlsEven=0;
			int n,temp,heightSum=0;
			while (testCases-->0) {
				boysEven=0;
				girlsEven=0;
				heightSum=0;
				n=fastReader.nextInt();
				for(int i=0;i<n;i++){
					temp=fastReader.nextInt();
					if((temp&1)==0){
						boysEven++;
					}
					heightSum+=temp;
				}
				for(int i=0;i<n;i++){
					temp=fastReader.nextInt();
					if((temp&1)==0){
						girlsEven++;
					}
					heightSum+=temp;
				}
				if(heightSum%2==0)
					heightSum/=2;
				else
					heightSum=(heightSum/2)+1;

				int heightReduced=Math.abs(boysEven-girlsEven);
				if(heightReduced%2==0)
					heightReduced/=2;
				else
					heightReduced=(heightReduced/2)+1;
				//System.out.println("sum:"+heightSum+" reduced:"+heightReduced);
				int ans=(heightSum)-(heightReduced);
				stringBuffer.append(ans).append("\n");
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
