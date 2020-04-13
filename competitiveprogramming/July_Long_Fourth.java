import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

class July_Long_Fourth {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			ArrayList<BigInteger>arr=new ArrayList();
			int n,minIndex=-1;
			BigInteger minSum,finalSum;
			while (testCases-->0) {
				n=fastReader.nextInt();
				arr.clear();
				finalSum=BigInteger.ZERO;
				for(int i=0;i<n;i++){
					arr.add(BigInteger.valueOf(fastReader.nextInt()));
				}
				for(int i=0;i<n-1;i++){
					minSum=BigInteger.valueOf(Integer.MAX_VALUE);
					for(int j=0;j<arr.size();j++){
						if(j==(arr.size()-1)){
							if(arr.get(arr.size()-1).add(arr.get(0)).compareTo(minSum)<0){
								minSum=arr.get(arr.size()-1).add(arr.get(0));
								minIndex=arr.size()-1;
							}
						}else{
							if(arr.get(j).add(arr.get(j+1)).compareTo(minSum)<0){
								minSum=arr.get(j).add(arr.get(j+1));
								minIndex=j;
							}
						}
					}
					arr.set(minIndex,minSum);
					if(minIndex==arr.size()-1){
						//System.out.println("adding "+arr.get(minIndex)+"and"+ arr.get(0));
						arr.remove(0);
					}else{
						//System.out.println("adding "+arr.get(minIndex)+"and"+ arr.get(minIndex+1));
						arr.remove(minIndex+1);
					}
					finalSum=finalSum.add(minSum);
				}
				stringBuffer.append(finalSum.intValue()).append("\n");
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
