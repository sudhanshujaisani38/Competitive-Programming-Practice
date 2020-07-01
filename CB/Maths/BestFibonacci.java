import java.util.HashMap;

//this method gets the fibonnaci in logn and without matrix exponentiation
class Main {
    public static void main(String[] args) {
        dp.put(1l, 1l);
        dp.put(0l, 1l);
        for(int i=2;i<20;i++){
            System.out.println(i+"th term is:"+fabonacci(i-2));
        }
    }

    static HashMap<Long, Long> dp = new HashMap<>();

    //returns (n+2)th term of fabonacci series in logn time
    static long fabonacci(long num) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }
        long k = num / 2;
        long ans;
        if ((num & 1) == 0) {
            ans = fabonacci(k) * fabonacci(k) + fabonacci(k - 1) * fabonacci(k - 1);
        } else {
            ans = fabonacci(k) * fabonacci(k + 1) + fabonacci(k - 1) * fabonacci(k);
        }
        dp.put(num,ans);
        return ans;
    }
}