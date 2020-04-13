import java.util.Scanner;
//https://www.codechef.com/viewsolution/24336909
public class M_The_Next_Palindrome {
	static int mid=0;
	public static void main(String[] args) {
		try{
			Scanner sc=new Scanner(System.in);
			int testCases=sc.nextInt();
			while(testCases>0){
				int k =sc.nextInt();
				StringBuffer str=new StringBuffer(k+"");
				StringBuffer temp=new StringBuffer(k+"");
				mid=(str.length()-1)/2;
				//System.out.println("mid=char at:"+mid);
				if(str.length()%2==0){
					//System.out.println("even");
					int midDigit=Integer.parseInt(str.substring(mid,mid+1));
					int midDigit2=Integer.parseInt(str.substring(mid+1,mid+2));
					if(midDigit<=midDigit2){
						midDigit++;
						str.delete(mid,str.length());
						str.append(midDigit);
						temp.delete(mid,temp.length());
						temp.append(midDigit);
						str.append(temp.reverse());
					}
					else{
						str.delete(mid+1,str.length());
						temp.delete(mid+1,temp.length());
						str.append(temp.reverse());
					}

				}else{
					//System.out.println("odd");
//					System.out.println(str.toString());
					int midDigit=Integer.parseInt(str.substring(mid,mid+1));
//					System.out.println("midDigit:"+midDigit);
					str.delete(mid,str.length());
//					System.out.println("m1:"+str.toString());
					str.append(midDigit+1);
//					System.out.println("m2:"+str.toString());
//					System.out.println("temp:"+temp.toString());
					temp.delete(mid,temp.length());
//					System.out.println("temp:"+temp.toString());
					str.append(temp.reverse());
//					System.out.println("final:"+str.toString());
				}
				System.out.println(Integer.parseInt(str.toString()));
				testCases--;
			}
		}catch (Exception e){
			return;
		}

	}
}
