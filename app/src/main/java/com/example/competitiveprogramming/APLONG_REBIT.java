

import java.util.Stack;
import java.util.Scanner;

class APLONG_REBIT {
    static Fraction a,A,ans1,ans0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String input = sc.next();
             a=new Fraction(1,1);
             A=new Fraction(1,1);
             ans1=new Fraction(1,1);
             ans0=new Fraction(1,1);
            evaluate(input);
        }
    }


    public static void evaluate(String s) {
        Stack<Character> operations = new Stack<Character>();
        char first;

        for(int index=0;index<s.length();index++) {

            first = s.charAt(index);
            switch (first) {
                case '&':
                case '|':
                case '^':
                    operations.push(first);
                    break;
                case ')':
                    changeFraction( operations);
                    break;
                case '(':
                case '#':
                    break;
                default: // Illegal character
                    throw new IllegalArgumentException("Illegal character");
            }
            System.out.println("After char at index:"+index+"--> 0:"+ans0+" 1:"+ans1+" a:"+a+" A:"+A);
        }
    }


    public static void changeFraction(Stack<Character> operations ) {
        switch (operations.peek()) {
            case '&':
                ans0.num*=9;
                ans0.denom*=16;

                ans1.denom*=16;

                a.num*=3;
                a.denom*=16;

                A.num*=3;
                A.denom*=16;
            break;
            case '|':

                ans1.num*=9;
                ans1.denom*=16;

                ans0.denom*=16;

                a.num*=3;
                a.denom*=16;

                A.num*=3;
                A.denom*=16;
                break;
            case '^':
                ans0.denom*=4;
                ans1.denom*=4;
                a.denom*=4;
                A.denom*=4;
                break;
            default:  // This statement should be unreachable since only the aforementioned values get sent to the method...
                throw new IllegalArgumentException("Illegal operation");
        }
        operations.pop();
    }
    static class Fraction{
        long num,denom;
        Fraction(int num,int denom){
            this.num=num;
            this.denom=denom;
        }

        @Override
        public String toString() {
            return "("+num+"/"+denom+")";
        }
    }
}