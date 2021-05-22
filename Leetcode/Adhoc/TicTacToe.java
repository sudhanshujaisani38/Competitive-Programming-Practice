import java.io.*;
import java.util.*;

class Main {
    static char empty = '_';
    static final int VALID_DRAW_OR_WON = 1;
    static final int GAME_NOT_FINISHED = 2;
    static final int INVALID_STATE = 3;

    static void redirectIO() {
        try {
            final String INPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/input.txt";
            final String OUTPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/output.txt";
            System.setOut(new PrintStream(new File(OUTPUT_FILE)));
            File inputFile = new File(INPUT_FILE);
            inputFile.createNewFile();
            System.setIn(new FileInputStream(inputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        redirectIO();
        FastReader fastReader = new FastReader();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer stringBuffer = new StringBuffer();
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {

                char board[][] = new char[3][3];
                for (int i = 0; i < 3; i++) {
                    board[i] = fastReader.next().toCharArray();
                }
                int ans = solve(board);
                 System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    static int solve(char board[][]) {
        // check no of winners
        boolean wonX = false;
        boolean wonO = false;
        int wins = 0;
        if (board[0][0] != empty && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            if (board[0][0] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }
        if (board[1][0] != empty && board[1][0] == board[1][1] && board[1][1] == board[1][2]){
            if (board[1][0] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }
        if (board[2][0] != empty && board[2][0] == board[2][1] && board[2][1] == board[2][2]){
            if (board[2][0] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }

        if (board[0][0] != empty && board[0][0] == board[1][0] && board[1][0] == board[2][0]){
            if (board[0][0] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }
        if (board[0][1] != empty && board[0][1] == board[1][1] && board[1][1] == board[2][1]){
            if (board[0][1] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }
        if (board[0][2] != empty && board[0][2] == board[1][2] && board[1][2] == board[2][2]){
            if (board[0][2] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }

        if (board[0][0] != empty && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            if (board[0][0] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }
        if (board[0][2] != empty && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            if (board[0][2] == 'X') {
                wonX = true;
            } else {
                wonO = true;
            }
            wins++;
        }

        if (wins>1 && wonO)
            return INVALID_STATE;
        int countX = 0, countO = 0, countEmpty = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case 'X':
                        countX++;
                        break;
                    case 'O':
                        countO++;
                        break;
                    case '_':
                        countEmpty++;
                        break;                   
                }
            }
        }
        int diff = countX - countO;
        if (diff < 0 || diff > 1)
            return INVALID_STATE;
        if (diff == 0 && wonX)
            return INVALID_STATE;
        if(diff==1 && wonO){
            return INVALID_STATE;
        }

        if (wins == 0 && countEmpty > 0)
            return GAME_NOT_FINISHED;

        return VALID_DRAW_OR_WON;
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