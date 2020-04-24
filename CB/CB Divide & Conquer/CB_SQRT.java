import java.util.Scanner;

class CB_SQRT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int precision = sc.nextInt(); //p must be less than 9, because double can take that much only
            double ans = sqrt(n, precision);
            System.out.println(ans);
        }
    }

    private static double sqrt(int n, int precision) {
        int start=0,end=n,mid;  //since sqrt of any no will be between 0 and n,therfore start=0 & end=n;
        double currentAns=0;

        //find out the decimal part using binary search
        while(end>start){
            mid=(start+end)/2;
            if(mid*mid==n){
                return mid;
            }else if(mid*mid>n){
                end=mid-1;
            }else{
                start=mid+1;
                currentAns=mid;
            }
        }
        
        double decimalPlace=1; 
        //now the decimal part
        for(int i=0;i<precision;i++){
            decimalPlace/=10;
            int decValue=0;
            double tempAns=currentAns;
            double ans=tempAns;
            while(tempAns*tempAns<n){
                ans=tempAns;
                decValue++;
                tempAns=currentAns+(decimalPlace*decValue);                
            }
            currentAns=ans;            
        }
        return currentAns;
    }
}