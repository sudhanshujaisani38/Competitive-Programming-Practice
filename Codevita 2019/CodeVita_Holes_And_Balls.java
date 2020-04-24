import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class CodeVita_Holes_And_Balls {
	static FastReader fastReader = new FastReader();
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer = new StringBuffer();

	public static void main(String[] args) {
		try {
			int holesDiameter[] = new int[50];
			int ballsDiameter[] = new int[1000];
			int filledAmountOfHole[] = new int[50];
			Arrays.fill(filledAmountOfHole, 0);
			int noOfHoles = fastReader.nextInt();
			for (int i = 0; i < noOfHoles; i++) {
				holesDiameter[i] = fastReader.nextInt();
			}
			int noOfBalls = fastReader.nextInt();
			for (int i = 0; i < noOfBalls; i++) {
				ballsDiameter[i] = fastReader.nextInt();
			}
			for (int i = 0; i < noOfBalls; i++) {
				for (int j = (noOfHoles-1); j>=0; j--) {
					if (ballsDiameter[i] <= holesDiameter[j]) {
						if (filledAmountOfHole[j] <(j + 1)) {
							filledAmountOfHole[j]++;
							stringBuffer.append((j + 1) + " ");
							break;
						}
					}
					if(j==0)
						stringBuffer.append(0+" ");
				}
			}
			stringBuffer.append("\n");
			bufferedWriter.write(stringBuffer.toString());
			bufferedWriter.flush();
		} catch (Exception e) {
			return;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
