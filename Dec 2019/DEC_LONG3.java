import java.util.*;
class DEC_LONG3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Character,Integer>mapPos=new HashMap<>();
        HashMap<Character,Integer>mapDiff=new HashMap<>();
        int t=sc.nextInt();
        outer: while(t-->0){

            int n=sc.nextInt();
            String s=sc.next();
            int ans=n;
            for(int i=(n-1);i>=0;i--){
//                System.out.println(s.charAt(i));
                if(mapPos.get(s.charAt(i))==null){
                    mapPos.put(s.charAt(i),i);
                    mapDiff.put(s.charAt(i),n);
                }else{
                    // cout<<"found:"<<s[i]<<" at "<<i+1;
                    int tempDiff=mapPos.get(s.charAt(i))-i;
                    if(tempDiff<mapDiff.get(s.charAt(i))){
                        if(ans>tempDiff){
                            ans=tempDiff;
                        }
                        mapDiff.put(s.charAt(i),tempDiff);
                    }
                }
//                System.out.println("diff"+mapDiff);
//                System.out.println("lastpos:"+mapPos);
            }
            System.out.println(n-ans);
        }
    }
}