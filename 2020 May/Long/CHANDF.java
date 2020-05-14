import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testCases = sc.nextLong();
        while (testCases-- > 0) {
            ArrayList<Long> possibleAns = new ArrayList<>();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long temp = 0l;
            long noOfBitsInR = getNoOfBits(r);
            long obviousBits = 0l;
            for (long bit = noOfBitsInR; bit >=0; bit--) {
                long bitVal = (1l << bit);
                // System.out.println("bit:"+bitVal);
                if ((bitVal & r) != (bitVal & l)) {
                    break;
                } else {
                    obviousBits++;
                    temp = temp | (bitVal & r);
                }
            }
            // System.out.println("value after setting the obvious bits:" + temp+":"+toBinary(temp));
            for (long bit = noOfBitsInR - obviousBits; bit >= 0; bit--) {
                long bitValue = (1l << bit);
                if ((r & bitValue) > 0) {
                    // System.out.println("oring"+temp+" with "+(bitValue - 1));
                    possibleAns.add(temp | (bitValue - 1));
                    temp = temp | bitValue;
                }
            }
            possibleAns.add(l);
            possibleAns.add(r);
            // System.out.println(possibleAns);
            long maxAns=0;
            long zz=l;
            for(Long z:possibleAns){
                long currAns=func(x, y, z);
                if(currAns>maxAns){
                    zz=z;
                    maxAns=currAns;
                }
            }
            // System.out.println("max value was given by:"+zz);
            long or=x|y;
            // System.out.println("or valu:"+or);
            for(long bit=noOfBitsInR;bit>=0;bit--){
                long bitValue=(1l<<bit);
                if((bitValue&or)==0 && (zz&(~bitValue))>=l){
                    // System.out.println("removing unneccesary bit at:"+bitValue);
                    zz=zz&(~bitValue);
                }
            }
            System.out.println(zz);
        }
    }

    static long func(long x, long y, long z) {
        return ((x & z) * (y & z));
    }

    static long getNoOfBits(long num) {
        long ans = 0;
        while (num != 0) {
            ans++;
            num = num >> 1;
        }
        return ans - 1;
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
}