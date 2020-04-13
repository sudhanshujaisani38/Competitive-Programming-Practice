import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class CountAll {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int sum;
	public static void main(String[] args) {
		try {
			int n = Integer.parseInt(br.readLine());
			sum=n;
			String strArr[]=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				int num=Integer.parseInt(strArr[i]);
				int limit=Math.min(num,n);
				if(num%2==0) {
					for (int j = 2; j <= limit; j += 2) {
						if (num % j == 0) {
						System.out.println("num="+num+" j="+j);
							sum++;
						}
					}
				}else {
					for (int j = 3; j <= limit; j += 2) {
						if (num % j == 0) {
						System.out.println("num="+num+" j="+j);
							sum++;
						}
					}
				}
			}
			System.out.println(sum);
		}catch (Exception e){
			System.out.println("error");
			return;
		}
	}
}
