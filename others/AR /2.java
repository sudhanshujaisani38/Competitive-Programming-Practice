import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[100001];
        precomputeA(100000, a);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                System.out.println(calcD(i, a));
            }
        }
    }

    private static long calcD(int n,int a[]) {
        long ans = 0l;
        for (int i = 1; i <= n; i++) {
            long curr = calcC(i, a);
            ans += curr;
            // System.out.println("c(" + i + "):" + curr);
        }
        return ans;

    }

    private static void precomputeA(int n, int[] phi) {
        for (int i = 1; i <= n; i++) {
            phi[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (phi[i] == i) {
                phi[i]--;
                for (int fac = 2; fac * i <= n; fac++) {
                    phi[fac * i] -= (phi[fac * i] / i);
                }
            }
        }
    }

    // calculates b(n) in root n
    static long calcB(int n, int a[]) {
        long sum = 0l;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += a[i];
                if ((n / i) != i)
                    sum += a[n / i];
            }
        }
        return sum;
    }

    static long calcC(int n, int a[]) {
        long b = calcB(n, a);
        long ans = 0l;
        for (long fac = 2; fac * fac <= b; fac++) {
            while (b % fac == 0) {
                ans++;
                b /= fac;
            }
        }
        if (b > 1)
            ans++;
        return ans;
    }
}