import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

class July_Long_Second {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	static HashSet<Integer> hashSet=new HashSet();
	static HashSet<Integer> evenOnes=new HashSet<>();
	static HashSet<Integer> oddOnes=new HashSet<>();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int q,x;
			HashSet<Integer>temp=new HashSet();
			while (testCases-->0) {
				evenOnes.clear();
				oddOnes.clear();
				hashSet.clear();
				q=fastReader.nextInt();
				for(int i=0;i<q;i++){
					x=fastReader.nextInt();
					temp.clear();
					for(int num:hashSet){
						temp.add(num^x);
						findSet(num^x);
					}
					hashSet.add(x);
					hashSet.addAll(temp);
					findSet(x);
//					System.out.println(hashSet);
//					for(int num:hashSet){
//						findSet(num);
//					}
					stringBuffer.append(evenOnes.size()+" "+oddOnes.size()+"\n");
					//System.out.println("evenOnes: "+evenOnes);
					//System.out.println("odd Ones: "+oddOnes);
					//System.out.println("Even digits: "+evenOnes.size());
					//System.out.println("Odd digits: "+oddOnes.size());
				}
			}
			bufferedWriter.write(stringBuffer.toString());
			bufferedWriter.flush();
		}catch (Exception e){
			return;
		}
	}

	private static void findSet(int num) {
		if(evenOnes.contains(num)||oddOnes.contains(num)){
			//System.out.println(num+" is already in a set");
			return;
		}
		int temp=num;
		boolean isCountEven=true;

		//System.out.println(num+"-->");
		while(num!=0){
			if((num&1)==1) {
				isCountEven = !isCountEven;
				//System.out.println("1 at 2 ki power:"+k);
			}
			num=num>>1;
			//System.out.println(num);
		}
		if(isCountEven){
			evenOnes.add(temp);
			//System.out.println("adding "+temp+" to even set");
		}else {
			oddOnes.add(temp);
			//System.out.println("adding "+temp+" to odd set");
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
		int nextInt(){
			return Integer.parseInt(next());
		}
	}
}
