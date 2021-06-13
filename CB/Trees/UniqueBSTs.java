//formula for catalin number: fac(2n)/(fac(n)*fac(n+1))
//try to get catalinNumber(n) from catalinNumber(n-1), to get the logic

class UniqueBSTs {
    public int numTrees(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= (4 * i - 2);
            ans /= (i + 1);
        }
        return (int) ans;
    }
}