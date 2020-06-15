import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int p = fastReader.nextInt();
                int rowQueries[] = new int[n];
                int colQueries[] = new int[n];
                int remInRow[] = new int[n];
                int remInCol[] = new int[n];
                boolean alreadyFull = false;
                boolean alreadyEmpty = false;
                for (int i = 0; i < n; i++) {
                    if (alreadyFull) {
                        rowQueries[i] = (n - i) * (n);
                        continue;
                    }
                    if (alreadyEmpty) {
                        rowQueries[i] = 0;
                        continue;
                    }
                    System.out.println(1 + " " + (i + 1) + " 1 " + n + " " + n);
                    System.out.flush();
                    rowQueries[i] = fastReader.nextInt();
                    if (rowQueries[i] == (n - i) * (n)) {
                        alreadyFull = true;
                    }
                    if (rowQueries[i] == 0) {
                        alreadyEmpty = true;
                    }
                }
                colQueries[0] = rowQueries[0];
                alreadyFull = (rowQueries[0]==n*n);
                alreadyEmpty = false;
                for (int i = 1; i < n; i++) {
                    if (alreadyFull) {
                        colQueries[i] = (n - i) * (n);
                        continue;
                    }
                    if (alreadyEmpty) {
                        colQueries[i] = 0;
                        continue;
                    }
                    System.out.println(1 + " 1 " + (i + 1) + " " + n + " " + n);
                    System.out.flush();
                    colQueries[i] = fastReader.nextInt();
                    if (colQueries[i] == (n - i) * (n)) {
                        alreadyFull = true;
                    }
                    if (colQueries[i] == 0) {
                        alreadyEmpty = true;
                    }
                }
                for (int i = 0; i < n - 1; i++) {
                    remInRow[i] = rowQueries[i] - rowQueries[i + 1];
                }
                for (int i = 0; i < n - 1; i++) {
                    remInCol[i] = colQueries[i] - colQueries[i + 1];
                }

                remInRow[n - 1] = rowQueries[n - 1];
                remInCol[n - 1] = colQueries[n - 1];
                int mm[][] = new int[n][n];
                int ans[][] = new int[n][n];
                boolean isAlreadyProcessed[][] = new boolean[n][n];
                int total1 = rowQueries[0];
                int pBU[] = new int[n];
                int pBL[] = new int[n];
                outer: for (int i = 0; i < n / 2; i++) {
                    int restColsLeft = total1 - remInCol[0];
                    int restColsRight = total1 - remInCol[n - 1];
                    int LU = 1, RU = 1, LL = 1, RL = 1;
                    boolean LU2 = false, RU2 = false, LL2 = false, RL2 = false;
                    for (int j = 0; j < n / 2; j++) {
                        if (total1 == 0) {
                            break outer;
                        }
                        int j2 = n - 1 - j;
                        int i2 = n - 1 - i;
                        int alreadyProcessedRightLow = 0;
                        int alreadyProcessedRightUp = 0;
                        for (int col = j + 1; col < n; col++) {
                            alreadyProcessedRightLow += pBL[col];
                            alreadyProcessedRightUp += pBU[col];
                        }
                        int alreadyProcessedLeftLow = 0;
                        int alreadyProcessedLeftUp = 0;
                        for (int col = j2 - 1; col >= 0; col--) {
                            alreadyProcessedLeftLow += pBL[col];
                            alreadyProcessedLeftUp += pBU[col];
                        }

                        if (remInRow[i] != 0 && remInCol[j] != 0 && !isAlreadyProcessed[i][j]) {
                            if (LU != 0) {
                                if (!LU2) {
                                    System.out.println(1 + " " + (i + 2) + " " + (j + 2) + " " + n + " " + n);
                                    System.out.flush();
                                    mm[i][j] = fastReader.nextInt();
                                } else {
                                    mm[i][j] = (n - i - 1) * (n - j - 1);
                                }
                                if (mm[i][j] == (n - i - 1) * (n - j - 1)) {
                                    if (!LU2) {
                                        int end = Math.min(j2, n / 2);
                                        for (int ii = i + 1; ii < n / 2; ii++) {
                                            for (int jj = j + 1; jj < n / 2; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBU[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsRight--;
                                                    restColsLeft--;
                                                    alreadyProcessedLeftUp++;
                                                    total1--;
                                                    mm[i][j]--;
                                                }
                                            }
                                        }
                                        
                                        for (int ii = i + 1; ii < n / 2; ii++) {
                                            for (int jj = n / 2; jj < n; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBU[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsLeft--;
                                                    restColsRight--;
                                                    alreadyProcessedRightUp++;
                                                    total1--;
                                                    mm[i][j]--;
                                                }
                                            }
                                        }
                                        // int starti = Math.max(i + 1, n / 2);
                                        for (int ii = n/2; ii < n; ii++) {
                                            for (int jj = j+1; jj < n / 2; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBL[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsLeft--;
                                                    restColsRight--;
                                                    alreadyProcessedLeftLow++;
                                                    total1--;
                                                    mm[i][j]--;
                                                }
                                            }
                                        }
                                        for (int ii = n/2; ii < n; ii++) {
                                            for (int jj = n / 2; jj < n; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBL[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsRight--;
                                                    restColsLeft--;
                                                    alreadyProcessedRightLow++;
                                                    total1--;
                                                }
                                            }
                                        }

                                    }
                                    LU2 = true;
                                }
                                mm[i][j] -= alreadyProcessedRightLow;
                                LU = mm[i][j];
                            } else {
                                mm[i][j] = 0;
                            }
                            int onesAhead = restColsLeft - (mm[i][j]);
                            ans[i][j] = remInRow[i] - onesAhead;
                            if (ans[i][j] == 1) {
                                pBU[j]++;
                                remInRow[i]--;
                                restColsRight--;
                                alreadyProcessedLeftUp++;
                                remInCol[j]--;
                                total1--;
                            }
                        }

                        if (remInRow[i] != 0 && remInCol[j2] != 0 && !isAlreadyProcessed[i][j2]) {
                            if (j2 != n / 2) {
                                if (RU != 0) {
                                    if (!RU2) {
                                        System.out.println(1 + " " + (i + 2) + " " + 1 + " " + n + " " + j2);
                                        System.out.flush();
                                        mm[i][j2] = fastReader.nextInt();
                                    } else {
                                        mm[i][j2] = (n - i - 1) * j2;
                                    }
                                    if (mm[i][j2] == (n - i - 1) * j2) {
                                        if (!RU2) {
                                            int end = Math.min(j2, n / 2);
                                            for (int ii = i + 1; ii < n / 2; ii++) {
                                                for (int jj = 0; jj < end; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBU[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsRight--;
                                                        restColsLeft--;
                                                        alreadyProcessedLeftUp++;
                                                        total1--;
                                                        mm[i][j2]--;
                                                    }
                                                }
                                            }
                                            for (int ii = i + 1; ii < n / 2; ii++) {
                                                for (int jj = n / 2; jj < j2; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBU[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsLeft--;
                                                        restColsRight--;
                                                        alreadyProcessedRightUp++;
                                                        total1--;
                                                        mm[i][j2]--;
                                                    }
                                                }
                                            }
                                            int starti = Math.max(i + 1, n / 2);
                                            for (int ii = starti; ii < n; ii++) {
                                                for (int jj = 0; jj < n / 2; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBL[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsLeft--;
                                                        restColsRight--;
                                                        alreadyProcessedLeftLow++;
                                                        total1--;
                                                    }
                                                }
                                            }
                                            for (int ii = starti; ii < n; ii++) {
                                                for (int jj = n / 2; jj < j2; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBL[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsRight--;
                                                        restColsLeft--;
                                                        alreadyProcessedRightLow++;
                                                        total1--;
                                                        mm[i][j2]--;
                                                    }
                                                }
                                            }

                                        }
                                        RU2 = true;

                                    }
                                    mm[i][j2] -= alreadyProcessedLeftLow;
                                    RU = mm[i][j2];

                                } else {
                                    mm[i][j2] = 0;
                                }
                                int onesAhead = restColsRight - (mm[i][j2]);
                                // System.out.println("onesahead=" + restColsRight + "-" + (mm[i][j2]));
                                ans[i][j2] = remInRow[i] - onesAhead;
                                // System.out.println("ans=" + remInRow[i] + "-" + onesAhead);

                            } else {
                                ans[i][j2] = 1;
                            }
                            if (ans[i][j2] == 1) {
                                pBU[j2]++;
                                alreadyProcessedRightUp++;
                                restColsLeft--;
                                remInRow[i]--;
                                remInCol[j2]--;
                                total1--;
                            }
                        }
                        if (remInRow[i2] != 0 && remInCol[j] != 0 && !isAlreadyProcessed[i2][j]) {
                            if (i2 != n / 2) {

                                if (LL != 0) {
                                    if (!LL2) {
                                        System.out.println(1 + " 1 " + (j + 2) + " " + (n - i - 1) + " " + n);
                                        System.out.flush();
                                        mm[i2][j] = fastReader.nextInt();
                                    } else {
                                        mm[i2][j] = (n - i - 1) * (n - j - 1);
                                    }

                                    if (mm[i2][j] == (n - i - 1) * (n - j - 1)) {
                                        if(!LL2){
                                            for (int ii = 0; ii < n / 2; ii++) {
                                                for (int jj = j+1; jj < n / 2; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBU[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsRight--;
                                                        restColsLeft--;
                                                        alreadyProcessedLeftUp++;
                                                        total1--;
                                                        mm[i2][j]--;
                                                    }
                                                }
                                            }
                                            
                                            for (int ii = 0; ii < n / 2; ii++) {
                                                for (int jj = n / 2; jj < n; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBU[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsLeft--;
                                                        restColsRight--;
                                                        alreadyProcessedRightUp++;
                                                        total1--;
                                                    }
                                                }
                                            }
                                            // int starti = Math.max(i + 1, n / 2);
                                            for (int ii = n/2; ii < i2; ii++) {
                                                for (int jj = j+1; jj < n / 2; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBL[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsLeft--;
                                                        restColsRight--;
                                                        alreadyProcessedLeftLow++;
                                                        total1--;
                                                        mm[i2][j]--;
                                                    }
                                                }
                                            }
                                            for (int ii = n/2; ii < i2; ii++) {
                                                for (int jj = n / 2; jj < n; jj++) {
                                                    if (!isAlreadyProcessed[ii][jj]) {
                                                        // System.out.println("processing " + ii + "," + jj);
                                                        isAlreadyProcessed[ii][jj] = true;
                                                        ans[ii][jj] = 1;
                                                        pBL[jj]++;
                                                        remInCol[jj]--;
                                                        remInRow[ii]--;
                                                        restColsRight--;
                                                        restColsLeft--;
                                                        alreadyProcessedRightLow++;
                                                        total1--;
                                                        mm[i2][j]--;
                                                    }
                                                }
                                            }
                                        }
                                        LL2 = true;
                                    }
                                    mm[i2][j] -= alreadyProcessedRightUp;
                                    LL = mm[i2][j];
                                } else {
                                    mm[i2][j] = 0;
                                }
                                int onesAhead = restColsLeft - (mm[i2][j]);
                                ans[i2][j] = remInRow[i2] - onesAhead;

                            } else {
                                ans[i2][j] = 1;
                            }
                            if (ans[i2][j] == 1) {
                                pBL[j]++;
                                alreadyProcessedLeftLow++;
                                restColsRight--;
                                remInRow[i2]--;
                                remInCol[j]--;
                                total1--;
                            }

                        }
                        if (remInRow[i2] != 0 && remInCol[j2] != 0 && !isAlreadyProcessed[i2][j2]) {
                            // if (j2 != n / 2 ) {

                            if (RL != 0) {
                                if (!RL2) {
                                    System.out.println(1 + " 1 1 " + i2 + " " + j2);
                                    System.out.flush();
                                    mm[i2][j2] = fastReader.nextInt();
                                } else {
                                    mm[i2][j2] = (i2 * j2);
                                }
                                if (mm[i2][j2] == (i2 * j2)) {
                                    if(!RL2){
                                        for (int ii = 0; ii < n / 2; ii++) {
                                            for (int jj = 0; jj < n / 2; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBU[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsRight--;
                                                    restColsLeft--;
                                                    alreadyProcessedLeftUp++;
                                                    total1--;
                                                }
                                            }
                                        }
                                        
                                        for (int ii = 0; ii < n / 2; ii++) {
                                            for (int jj = n / 2; jj < j2; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBU[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsLeft--;
                                                    restColsRight--;
                                                    alreadyProcessedRightUp++;
                                                    total1--;
                                                    mm[i2][j2]--;
                                                }
                                            }
                                        }
                                        // int starti = Math.max(i + 1, n / 2);
                                        for (int ii = n/2; ii < i2; ii++) {
                                            for (int jj = 0; jj < n / 2; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBL[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsLeft--;
                                                    restColsRight--;
                                                    alreadyProcessedLeftLow++;
                                                    total1--;
                                                    mm[i2][j2]--;
                                                }
                                            }
                                        }
                                        for (int ii = n/2; ii < i2; ii++) {
                                            for (int jj = n / 2; jj < j2; jj++) {
                                                if (!isAlreadyProcessed[ii][jj]) {
                                                    // System.out.println("processing " + ii + "," + jj);
                                                    isAlreadyProcessed[ii][jj] = true;
                                                    ans[ii][jj] = 1;
                                                    pBL[jj]++;
                                                    remInCol[jj]--;
                                                    remInRow[ii]--;
                                                    restColsRight--;
                                                    restColsLeft--;
                                                    alreadyProcessedRightLow++;
                                                    total1--;
                                                    mm[i2][j2]--;
                                                }
                                            }
                                        }
                                    }
                                    RL2 = true;
                                }
                                mm[i2][j2] -= alreadyProcessedLeftUp;
                                RL = mm[i2][j2];

                            } else {
                                mm[i2][j2] = 0;
                            }
                            int onesAhead = restColsRight - (mm[i2][j2]);
                            ans[i2][j2] = remInRow[i2] - onesAhead;

                            // }else{
                            // ans[i2][j2]=1;
                            // }
                            if (ans[i2][j2] == 1) {
                                alreadyProcessedRightLow++;
                                pBL[j2]++;
                                restColsLeft--;
                                remInRow[i2]--;
                                remInCol[j2]--;
                                total1--;
                            }

                        }

                        restColsLeft -= remInCol[j + 1];
                        restColsRight -= remInCol[j2 - 1];
                    }
                }
                System.out.println(2);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(ans[i][j] + " ");
                    }
                    System.out.println();
                    System.out.flush();
                }
                int response = fastReader.nextInt();
                if (response == -1) {
                    return;
                }
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}