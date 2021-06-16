
class MinimumWindowString {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int freqInS[] = new int[128];
        int freqInT[] = new int[128];
        int start = 0, end = -1;
        int left = 0, right = 0;
        int required = 0;
        int minLen = s.length() + 1;
        for (int i = 0; i < t.length(); i++) {
            freqInT[t.charAt(i)]++;
            if (freqInT[t.charAt(i)] == 1)
                required++;
        }
        boolean isValidWindow = false;
        while (right < s.length()) {
            char charAtEnd = s.charAt(right);
            freqInS[charAtEnd]++;
            if (freqInT[charAtEnd] == freqInS[charAtEnd]) {
                required--;
                if (required == 0) {
                    isValidWindow = true;
                }
            }
            while (left <= right && isValidWindow) {
                char charAtStart = s.charAt(left);
                freqInS[charAtStart]--;
                if (freqInS[charAtStart] < freqInT[charAtStart]) {
                    if (minLen > right - left + 1) {
                        minLen = right - left + 1;
                        start = left;
                        end = right;
                    }
                    isValidWindow = false;
                    required = 1;
                }
                left++;
            }
            right++;
        }
        return s.substring(start, end + 1);

    }
}