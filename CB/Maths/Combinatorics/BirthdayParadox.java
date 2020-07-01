//find minimum no of people in a room such that
// probabilty of 2 people having the same birthday is p (here,50%)
class Main {
    public static void main(String[] args) {
        float p = 0.7f;
        float q = 1;
        float numerator = 365;
        float denom = 365;
        int ans = 0;
        float maxQ=1-p;
        while (q > maxQ) {
            q = q * (numerator / denom);
            numerator--;
            ans++;
            System.out.println("people:" + ans + ", probability:" + (1f - q));
        }
        System.out.println(ans);
    }
}