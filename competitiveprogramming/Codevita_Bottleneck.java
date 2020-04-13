
import java.util.Arrays;
import java.util.Scanner;
class Codevita_Bottleneck {
	static Scanner fastReader=new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int n = fastReader.nextInt();
			int visibleBottleCount=0;
			long arr[]=new long[n];
			for(int i=0;i<n;i++){
				arr[i]=fastReader.nextLong();
			}
			Arrays.sort(arr);
			long stackTops[]=new long[n];
			Arrays.fill(stackTops,Integer.MAX_VALUE);
			for(int i=(n-1);i>=0;i--){
				for(int j=0;j<=visibleBottleCount;j++){
					if(j==visibleBottleCount){
						stackTops[visibleBottleCount]=arr[i];
						visibleBottleCount++;
						break;
					}
					if(arr[i]<stackTops[j]){
						stackTops[j]=arr[i];
						break ;
					}
				}
			}
			System.out.println(visibleBottleCount);
		}catch (Exception e){
			return;
		}
	}
}
