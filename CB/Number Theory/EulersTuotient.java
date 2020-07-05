//for a given n, find the number of i such that 0<i<n that are comprime with n
//that is: gcd(i,n)=1
class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println("phi(" + i + "):" + phi(i));
        }
    }

    // gives nth number in the euler's tuotient series
    private static int phi(int n) {
        int ans = n;
        for (int fac = 2; fac * fac <= n; fac++) {
            if (n % fac == 0) {
                ans = ans - ans / fac;
                while (n % fac == 0) {
                    n /= fac;
                }
            }
        }
        if (n > 1) {
            ans = ans - ans / n;
        }
        return ans;
    }
}