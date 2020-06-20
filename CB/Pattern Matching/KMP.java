//implementation of KMP alorithm for pattern matching in java
class Main{
    public static void main(String[] args) {
        String testingStr="ABAABCXABCXABXA";
        String pattern="ABCXABX";
        KMPSearch(testingStr,pattern);
    }

    private static void KMPSearch(String testingStr, String pattern) {
        int resetTable[]=buildResetTable(pattern);
        int n=testingStr.length();
        int j=0;
        for(int i=0;i<n;i++){
            System.out.println(testingStr.charAt(i)+"--"+pattern.charAt(j));
            if(j>=0 && testingStr.charAt(i)!=pattern.charAt(j)){
                System.out.println("==========");                
                j=resetTable[j];
            }
            if(j==pattern.length()-1){
                System.out.println("found at:"+(i-j));
                j=resetTable[j];
            }
            j++;
        }
    }

    private static int[] buildResetTable(String pattern) {
        int n=pattern.length();
        int resetTable[]=new int[n];
        int j=-1;
        for(int i=0;i<n;i++){
            resetTable[i]=j;
            if(j>=0 && pattern.charAt(j)!=pattern.charAt(i)){
                j=resetTable[j];
            }
            j++;
        }
        return resetTable;
    }
}