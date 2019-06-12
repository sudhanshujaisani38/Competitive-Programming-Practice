import java.io.BufferedReader;
import java.io.InputStreamReader;
class BEG_Add_two_numbers {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try{
			int testCases=Integer.parseInt(br.readLine());
			while (testCases-->0){
				String str[]=br.readLine().split(" ");
				int a=Integer.parseInt(str[0]);
				int b=Integer.parseInt(str[1]);
				System.out.println(a+b);
			}
		}catch (Exception e){
			return;
		}
	}
}
