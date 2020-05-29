//implementation of Fabonacci using Top Down & Bottom Up DP
public class Fabonacci{
    int []dpTopDn;
    int []dpBotmUp;
    int maxRange;
    Fabonacci(int n){
        maxRange=n;
        dpTopDn=new int[n+1];
    }

    int fabonacciTopDn(int n,int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dpTopDn[n]!=0){
            return dpTopDn[n];
        }else{
            int ans=fabonacciTopDn(n-1, dp)+fabonacciTopDn(n-2, dp);
            dpTopDn[n]=ans;
            return ans;
        }
    }

    void initializedpBotmUp(){
        if(dpBotmUp==null){             //if not already initialized
            dpBotmUp=new int[maxRange+1];
            dpBotmUp[0]=0;
            dpBotmUp[1]=1;
            for(int i=2;i<=maxRange;i++){
                dpBotmUp[i]=dpBotmUp[i-1]+dpBotmUp[i-2];
            }
        }
    }
    int fabonacciBotmUp(int n){
        initializedpBotmUp();
        return dpBotmUp[n];
    }

    public static void main(String[] args) {
        Fabonacci f=new Fabonacci(20);
        System.out.println(f.fabonacciBotmUp(1)+"-"+f.fabonacciTopDn(1,f.dpTopDn));
        System.out.println(f.fabonacciBotmUp(2)+"-"+f.fabonacciTopDn(2,f.dpTopDn));
        System.out.println(f.fabonacciBotmUp(3)+"-"+f.fabonacciTopDn(3,f.dpTopDn));
        System.out.println(f.fabonacciBotmUp(4)+"-"+f.fabonacciTopDn(4,f.dpTopDn));
        System.out.println(f.fabonacciBotmUp(5)+"-"+f.fabonacciTopDn(5,f.dpTopDn));
        System.out.println(f.fabonacciBotmUp(6)+"-"+f.fabonacciTopDn(6,f.dpTopDn));
        System.out.println(f.fabonacciBotmUp(7)+"-"+f.fabonacciTopDn(7,f.dpTopDn));
        System.out.println(f.fabonacciBotmUp(8)+"-"+f.fabonacciTopDn(8,f.dpTopDn));
    }


}