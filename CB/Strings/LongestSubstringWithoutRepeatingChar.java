
class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        boolean isPresent[] = new boolean[128];
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            while (left != right && isPresent[s.charAt(right)]) {
                isPresent[s.charAt(left)] = false;
                left++;
            }
            ans = Math.max(right - left + 1, ans);
            isPresent[s.charAt(right)] = true;
            right++;
        }
        return ans;
    }
}