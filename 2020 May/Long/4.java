import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long min = Math.min(x, y);
            long max = Math.max(x, y);
            long finalAns = 0l;
            boolean firstSet = false;
            boolean secondSet = false;
            for (long i = getNoOfBits(min); i >= 0; i--) {
                long one=1l;
                long mask = (one << i) & min;
                // System.out.println("trying to set:" + (1 << i));
                if (mask > 0 && (mask | finalAns) <= r) {
                    finalAns = finalAns | mask;
                    firstSet = true;
                    break;
                } else {
                    // System.out.println("cannot set:" + (one << i)+"mask:"+i+" res:"+(mask|finalAns));
                }
            }
            // System.out.println("1 bit set from" + min + ":" + finalAns);
            // System.out.println("got bits of:" + min + "=" + finalAns);
            for (long i = getNoOfBits(max); i >= 0; i--) {
                long one=1l;
                long mask = (one << i) & max;
                // System.out.println("trying to set:" + (1 << i));
                if (mask > 0 && (mask | finalAns) <= r) {
                    finalAns = finalAns | mask;
                    secondSet = true;
                    break;
                } else {
                    // System.out.println("cannot set:" + (one << i)+"mask:"+i+" res:"+(mask|finalAns));
                }
            }

            // System.out.println("1 bit set from" + max + ":" + finalAns);
            if (firstSet && secondSet) {
                long or = min | max;
                System.out.println("or="+or);
                for (long i = getNoOfBits(or); i >= 0; i--) {
                    long one=1l;
                    long mask = (one << i) & or;

                    // System.out.println("trying to set:" + (1 << i));
                    if (mask > 0 && (mask | finalAns) <= r) {
                        finalAns = finalAns | mask;
                        // break;
                    } else {
                        // System.out.println("cannot set:" + (one << i)+"mask:"+i+" res:"+(mask|finalAns));
                    }
                }
                System.out.println(finalAns);
            }else{
                // System.out.println("one of the bits were empty");
                finalAns=0;
                System.out.println(0);
            }
            long bruteForceAns=solveBruteForce(x,y,l,r);
            System.out.println("f=" + toBinary(finalAns));
            if(bruteForceAns!=finalAns){
                System.out.println("----brute force:"+bruteForceAns+",finalAns:"+finalAns+"----");
                System.out.println("for f:"+func(x,y,finalAns));
                System.out.println("for b:"+func(x,y,bruteForceAns));
            }else{
                System.out.println(bruteForceAns+"="+finalAns);
            }
        }
    }

    private static long solveBruteForce(long x, long y, long l, long r) {
        long maxAns=0;
        long num=l;
        for(long z=9110650557l;z<=13345673423l;z++){
            long currAns=func(x,y,z);
            // System.out.println("for:"+z+",ans:"+currAns);
            if(currAns>maxAns){
                maxAns=currAns;
                num=z;
            }
        }
        printAns(x, y, num);
        return num;
    }

    static long getNoOfBits(long num) {
        long ans = 0;
        while (num != 0) {
            ans++;
            num = num >> 1;
        }
        return ans;
    }

    static long func(long x, long y, long z) {
        return ((x & z) * (y & z));
    }

    static void printAns(long l, long r, long z) {
        System.out.println("x=" + toBinary(l));
        System.out.println("y=" + toBinary(r));
        System.out.println("z=" + toBinary(z));
        
    }

    static String toBinary(long z) {
        String str = "";
        if (z == 0) {
            return "0";
        }
        while (z > 0) {
            str = (z & 1) + str;
            z = z >> 1;
        }
        return str;
    }



    static long unsetBit(long num, long mask) {
        return num & (~mask);
    }
}