import java.util.HashMap;

class MostFrequentSubtreeSum {
    HashMap<Integer,Integer> sumFrequency = new HashMap<>();
    int maxFreq = 0;
    int size = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        addSumToMap(root);
        int index = 0;
        int arr[] = new int[size];
        for(int sum: sumFrequency.keySet())
        {
            if(sumFrequency.get(sum)==maxFreq)
                arr[index++] = sum;
        }
        return arr;
    }
    int addSumToMap(TreeNode root)
    {
        if(root==null)return 0;
        int sum = addSumToMap(root.left)+addSumToMap(root.right)+root.val;
        int freq = sumFrequency.getOrDefault(sum,0);
        freq++;
        if(freq>maxFreq)
        {
            size=1;
            maxFreq = freq;
        }
        else if(freq==maxFreq)
        {            
            size++;
        }
        sumFrequency.put(sum,freq);
        return sum;
    }
}