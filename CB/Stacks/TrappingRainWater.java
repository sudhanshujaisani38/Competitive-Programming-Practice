public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int n = heights.length;
        int prevMaxIdx = -1;
        int prevMax = 0;
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            int idx = i - 1;
            int temp = 0;
            while (idx > prevMaxIdx && heights[idx] < curr) {
                int min = Math.min(prevMax, curr); //this is imp.
                temp += (min - heights[idx]);
                heights[idx] = curr;
                idx--;
            }
            if (idx >= 0) {
                trapped += temp;
            }
            if (curr >= prevMax) {
                prevMax = curr;
                prevMaxIdx = i;
            }
        }
        return trapped;
    }
}