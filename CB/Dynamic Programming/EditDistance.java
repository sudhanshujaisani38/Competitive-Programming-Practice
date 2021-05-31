class EditDistance {
    int dp[][];
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        dp = new int[len1+1][len2+1];
        for(int i =0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                dp[i][j] = -1;
            }
        }
        return minDistance(word1.toCharArray(),word2.toCharArray(),len1,len2);        
    }
    
    //this returns the ans for word1 upto length len1 and word2 upto length len2
     public int minDistance(char[] word1, char[] word2,int len1, int len2) {
         
        //base case:
         if(len1 == 0)return len2; //if word1 is empty we need to insert all chars of word2
         if(len2==0)return len1;//if word2 is empty we need to remove all chars of word1   

         if(dp[len1][len2]!=-1)
         {
             return dp[len1][len2];
         }

         //if the last chars of both strings match, recurr for rest of strings
         if(word1[len1-1]==word2[len2-1])
         {
             dp[len1][len2] = minDistance(word1,word2,len1-1,len2-1);  
         }
         //if not, then you can do either of the 3 operations
         else
         {
             int ansOnReplace = minDistance(word1,word2,len1-1,len2-1); //after replacing, last chars will become equal so recurr for rest
             int ansOnRemove = minDistance(word1,word2, len1-1,len2); //after removing a char from word1, length of word1 will decrease
             int ansOnInsert = minDistance(word1,word2, len1,len2-1); //after inserting a char,last char of strings would match, so one char of word2 will decrease
             dp[len1][len2] = Math.min(ansOnReplace, Math.min(ansOnRemove, ansOnInsert))+1;
         }
         return dp[len1][len2];         
     }
    
}