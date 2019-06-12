import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class BEG_Small_factorials {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try{
			int testCases=Integer.parseInt(br.readLine());
			while (testCases-->0){
				BigInteger fact=new BigInteger("1");
				int num=Integer.parseInt(br.readLine());
				for(int i=1;i<=num;i++){
					fact=fact.multiply(new BigInteger(i+""));
				}
				System.out.println(fact);
			}
		}catch (Exception e){
			return;
		}
	}
}
