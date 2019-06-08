import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class M_FlippingCoins {
	static int count=0;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int q = Integer.parseInt(str[1]);
			int arr[] = new int[n];

			Arrays.fill(arr, 0);
			for (int i = 0; i < q; i++) {
				String[] str2 = br.readLine().trim().split(" ");
				int operation = Integer.parseInt(str2[0]);
				int start = Integer.parseInt(str2[1]);
				int end = Integer.parseInt(str2[2]);
				if (operation == 0) {
					count = start;
					//System.out.println("start="+start+" end="+end);
					Arrays.stream(Arrays.copyOfRange(arr, start, end + 1)).forEach((val) -> {
						arr[count++] = val == 0 ? 1 : 0;
					});
					//Arrays.stream(arr).forEach((val)->System.out.print("_"+val));
					//System.out.println();
				} else {
					//Arrays.stream(arr).forEach((val)->System.out.print(" "+val));
					//System.out.println();
					count = 0;
					Arrays.stream(Arrays.copyOfRange(arr, start, end + 1)).forEach((val) -> {
						if (val == 1) count++;
					});
					System.out.println(count);
				}
			}
		}catch (Exception e){

		}
	}
}
