import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Codevita_Prime_Face {
	static FastReader fastReader=new FastReader();
	public static void main(String[] args) {
		try {
			int maxChar='0';
			String strNum=fastReader.next();
			int s=fastReader.nextInt();
			for(int i=0;i<strNum.length();i++){
				if(strNum.charAt(i)>maxChar)
					maxChar=strNum.charAt(i);
			}
			maxChar=valueOfChar(maxChar);
			int minBase=maxChar+1;
			int minNum=0;
			System.out.println(minBase);
			for(int i=0;i<strNum.length();i++){
				minNum+=((valueOfChar(strNum.charAt(i)))*(Math.pow(minBase,i)));
			}
			System.out.println(minNum);
		}catch (Exception e){
			return;
		}
	}
	static  int valueOfChar(int ch){

		if(ch>='0'&& ch<='9')
			ch-=48;
		else if(ch>='A' && ch<='Z')
			ch-=55;
		return  ch;
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
