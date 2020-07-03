//given a number n (upto 10^18), find the count of numbers that are divisible by any of the prime number
//less than 20
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases=sc.nextInt();
        int primes[]={2,3,5,7,11,13,17,19};
        while(testCases-->0){
            long n=sc.nextLong();
            int maxCombinations=(1<<primes.length)-1;
            long ans=0l;
            for(int i=1;i<=maxCombinations;i++){
                ans+=solve(n,i,primes);
            }
            System.out.println(ans);

        }
    }

    //returns signed ans for a particular combination
    private static long solve(long n, int i,int primes[]) {
        int setBits=0;
        int bit=0;
        long prod=1;
        while(i!=0){
            if((i&1)!=0){
                prod=prod*primes[bit];
                setBits++;
            }
            i=i>>1;
            bit++;            
        }
        long ans=n/prod;
        if(setBits%2==0){
            return -1*ans;
        }
        return ans;
    }
}