import java.io.BufferedReader;
import java.io.InputStreamReader;

class BEG_Enormous_input_test {
	static BufferedReader br;
	static int count=0;
	public static void main(String[] args) {
		int arr[]=new int[10000000];
		br=new BufferedReader(new InputStreamReader(System.in));
		count=0;
		try{
			String[] str=br.readLine().split(" ");
			int n=Integer.parseInt(str[0]);
			int k=Integer.parseInt(str[1]);
			for(int i=0;i<n;i++){
				 arr[i]=Integer.parseInt(br.readLine());
			}
			for(int i=0;i<n;i++){
				if(arr[i]%k==0)count++;
			}
			System.out.println(count);
		}catch (Exception e){
			System.out.println("io error");
			return;
		}
	}
}
