
public class LongestSubstringWithAtmost2UniqueChars {
    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2
     *          distinct characters
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        if (s.length() == 0)
            return 0;
        char charAt[] = s.toCharArray();
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(charAt[0]);
        int count[] = new int[128];
        int ans = 0;
        while (right < s.length()) {
            set.add(charAt[right]);
            count[charAt[right]]++;
            while (set.size() > 2 && left < right) {
                char leftChar = charAt[left];
                count[leftChar]--;
                left++;
                if (count[leftChar] == 0)
                    set.remove(leftChar);
            }
            if (set.size() <= 2) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }
}