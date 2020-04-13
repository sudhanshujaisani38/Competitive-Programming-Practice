import java.util.Scanner;

class Codevita_Pattern_Printing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max=((n * n) + n);
		StringBuffer string1;
		StringBuffer string2;
		int firstStart=1;
		int digitsToTake=n;
		int secondStart=max-digitsToTake+1;

		for (int i = 0; i < n; i++) {
			string1=new StringBuffer();
			string2=new StringBuffer();
			int starCount = 2 * i;
			while (starCount-- > 0)
				string1.append("*");

			digitsToTake=n-i;
			for(int j=0;j<digitsToTake;j++){
				if(j==(digitsToTake-1)){
					string1.append(firstStart+j);
					string2.append(secondStart+j);
				}
				else{
					string1.append(firstStart+j).append("0");
					string2.append(secondStart+j).append("0");
				}
			}
			firstStart+=(digitsToTake);
			secondStart-=(digitsToTake-1);
			System.out.println(string1.append("0").append(string2).toString());
		}
	}
}



















