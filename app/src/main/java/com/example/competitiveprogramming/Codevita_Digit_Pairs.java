import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Codevita_Digit_Pairs {
	static Scanner fastReader = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int n = fastReader.nextInt();
			String arr[] = new String[500];
			int evenIndexPairs[] = new int[10];
			int oddIndexPairs[] = new int[10];
			Arrays.fill(evenIndexPairs, 0);
			Arrays.fill(oddIndexPairs, 0);
			String bitScores[] = new String[500];
			for (int i = 0; i < n; i++) {
				arr[i] = fastReader.next();
			}
			for (int i = 0; i < n; i++) {
				int minDigit = findMaxDigit(arr[i]);
				int maxDigit = findMinDigit(arr[i]);
				int bitScore = (11 * maxDigit + 7 * minDigit) % 100;
				if (bitScore >=10)
					bitScores[i] = "" + bitScore;
				else
					bitScores[i] = "0" + bitScore;
//				System.out.println(arr[i] + ": maxDigit=" + maxDigit + " minDigit=" + minDigit + " bitScore=" + bitScores[i]);
			}
//			System.out.println();
			for (int i = 0; i < n; i += 2) {
				int msb = Character.getNumericValue(bitScores[i].charAt(0));
				oddIndexPairs[msb]++;
			}
			if(n>2) {
				for (int i = 1; i < n; i += 2) {
					int msb = Character.getNumericValue(bitScores[i].charAt(0));
					evenIndexPairs[msb]++;
				}
			}
//			Arrays.stream(evenIndexPairs).forEach(ele -> System.out.print(ele + " "));
//			System.out.println();
//			Arrays.stream(oddIndexPairs).forEach(ele -> System.out.print(ele + " "));
//			System.out.println();
			int ans = 0;
			for (int i = 0; i < 10; i++) {
				if (evenIndexPairs[i] == 2) {
					ans += 1;
				} else if (evenIndexPairs[i] > 2) {
					ans += 2;
				}

				if (oddIndexPairs[i] == 2) {
					ans += 1;
				} else if (oddIndexPairs[i] > 2) {
					ans += 2;
				}
			}
			System.out.println(ans);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private static int findMinDigit(String s) {
		int maxDigit = 0;
		for (int i = 0; i < 3; i++) {
			if ((s.charAt(i) - '0') > maxDigit) {
				maxDigit = (s.charAt(i) - '0');
			}
		}
		return maxDigit;
	}

	private static int findMaxDigit(String s) {
		int minDigit = 9;
		for (int i = 0; i < 3; i++) {
			if ((s.charAt(i) - '0') < minDigit) {
				minDigit = (s.charAt(i) - '0');
			}
		}
		return minDigit;
	}

}
