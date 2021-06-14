
//link to the explanation: approach 4
//https://leetcode.com/problems/longest-palindromic-substring/solution/
class LongestPalindromicString {
    public String longestPalindrome(String s) {
        char str[] = s.toCharArray();
        int maxLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i < str.length; i++) {
            int len1 = palindromeLength(i, i, str);
            int len2 = palindromeLength(i, i + 1, str);
            if (len1 > maxLen || len2 > maxLen) {
                maxLen = Math.max(len1, len2);
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    int palindromeLength(int start, int end, char[] str) {
        int left = start, right = end;
        while (left >= 0 && right < str.length && str[left] == str[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}