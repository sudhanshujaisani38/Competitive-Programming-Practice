import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Codevita_Dole_out_Cadbury {
	static Scanner fastReader=new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int minLength=fastReader.nextInt();
			int maxLength=fastReader.nextInt();
			int minWidth=fastReader.nextInt();
			int maxWidth=fastReader.nextInt();
			int ans=0;
			for(int i=minLength;i<=maxLength;i++){
				for(int j=minWidth;j<=maxWidth;j++){
					int length=i;
					int width=j;
					//System.out.println("For: "+length+"x"+width+": ");
					while(length!=width){
						int min=Math.min(length,width);
						if(min==length){
							width-=length;
							ans++;
						}
						else{
							length-=width;
							ans++;
						}
						//System.out.println("Current dimension:"+length+"x"+width);
					}
					ans++;
				}
			}
			System.out.print(ans);
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
