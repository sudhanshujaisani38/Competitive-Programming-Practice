import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class July_Long_Fifth {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	static final int myElement=Integer.MAX_VALUE;
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int n,f,min=Integer.MAX_VALUE;
			ArrayList<Integer>arr=new ArrayList<>();
			while (testCases-->0) {
				min=Integer.MAX_VALUE;
				n=fastReader.nextInt();
				for(int i=0;i<(n-1);i++){
					arr.add(fastReader.nextInt());
					if(min>arr.get(i))
						min=arr.get(i);
				}
				f=fastReader.nextInt();
				if(min>f){
					stringBuffer.append("impossible").append("\n");
					continue;
				}
				int index=0;
				while(arr.size()>=2){
					if(index!=(arr.size()-1)){
						if((arr.get(index+1)!=myElement)&&(arr.get(index)!=myElement)){
							System.out.println("Removed:" + arr.get(index + 1));
							arr.remove(index + 1);
							index++;
						}else if(arr.get(index+1)==myElement){

						}else if(arr.get(index)==myElement){
								index++;
								continue;
						}
					}
					if((arr.get(index+1)!=myElement)&&(arr.get(index)!=myElement)){
						if(index!=(arr.size()-1)) {
							System.out.println("Removed:" + arr.get(index + 1));
							arr.remove(index + 1);
							index++;
						}else{
							System.out.println("Removed:" + arr.get(0));
							arr.remove(0);
							index=0;
						}
					}else if(arr.get(index+1)==myElement){

					}else if(arr.get(index)==myElement){
						if(index!=(arr.size()-1))
							index++;
						else
							index--;
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
