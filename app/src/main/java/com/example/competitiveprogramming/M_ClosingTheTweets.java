import java.util.Arrays;
import java.util.Scanner;

class M_ClosingTheTweets {
	public static void main(String[] args) {
		try{
			Scanner sc=new Scanner(System.in);
			int tweetsOpen=0;
			int n=sc.nextInt();
			int k=sc.nextInt();sc.nextLine();
			boolean[] array=new boolean[n];
			Arrays.fill(array,false);
			for(int i=0;i<k;i++){
				String clickString=sc.nextLine();
				if(clickString.startsWith("CLICK")){
					int tweetNo =Integer.parseInt(clickString.split(" ")[1]);
					array[tweetNo-1]=!array[tweetNo-1];
					if (array[tweetNo-1])tweetsOpen++;
					else tweetsOpen--;
				}else{
					Arrays.fill(array,false);
					tweetsOpen=0;
				}
				System.out.println(tweetsOpen);
			}
		}catch(Exception e){return;}//TO avoid NZEC
	}
}