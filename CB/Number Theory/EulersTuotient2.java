//given an integer n, find euler's tuotient for i= 1 to n
//using seives theorem here.
class Main{
    public static void main(String[] args) {
        int n=20;
        int phi[]=new int[n+1];
        preComputePhi(n,phi);
        for(int i=1;i<=n;i++){
            System.out.println("phi("+i+"):"+phi[i]);
        }
    }

    private static void preComputePhi(int n, int[] phi) {
        for(int i=1;i<=n;i++){
            phi[i]=i;
        }
        for(int i=2;i<=n;i++){
            if(phi[i]==i){
                phi[i]=i-1;
                for(int fac=2;(fac*i)<=n;fac++){
                    phi[fac*i]-=(phi[fac*i]/i);
                }
            }
        }        
    }
}