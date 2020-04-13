
import java.util.Scanner;

public class CV_String_Rotation {
	public static void main(String[] args) {
		try{

			Scanner sc=new Scanner(System.in);
			String string=sc.next();
			int q=sc.nextInt();
			StringBuffer stringBuffer=new StringBuffer(string);
			StringBuffer temp=new StringBuffer();
			while (q-->0){
				String dir=sc.next();
				int mag=sc.nextInt();
				if(dir.equals("L")){
					stringBuffer.append(stringBuffer.subSequence(0,mag));
//				System.out.println("after append:"+stringBuffer);
					stringBuffer.delete(0,mag);
//				System.out.println("after delete:"+stringBuffer);
				}else{
					stringBuffer.insert(0,stringBuffer.subSequence(stringBuffer.length()-mag,stringBuffer.length()));
//				System.out.println("after append:"+stringBuffer);
					stringBuffer.delete(string.length(),stringBuffer.length());
//				System.out.println("after delete:"+stringBuffer);
				}
				temp.append(stringBuffer.charAt(0));
			}
//		System.out.println(temp);
			if(string.contains(stringBuffer)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}catch (Exception e){
			return;
		}
	}
}
