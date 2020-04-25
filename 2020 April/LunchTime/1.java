import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            int testCases = sc.nextInt();
            while (testCases-- > 0) {
                int n = sc.nextInt();
                int dollarsToSpend = sc.nextInt();
                dollarsToSpend = 100 - dollarsToSpend;
                int prices[] = new int[n];
                int isFwd[] = new int[n];
                for (int i = 0; i < n; i++) {
                    prices[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    isFwd[i] = sc.nextInt();
                }
                ArrayList<Integer> def = new ArrayList<>();
                ArrayList<Integer> fwd = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if (isFwd[i] == 1) {
                        fwd.add(prices[i]);
                    } else {
                        def.add(prices[i]);
                    }
                }
                Collections.sort(fwd);
                Collections.sort(def);
                int deff,fwdd;
                if(fwd.size()>0){
                    fwdd=fwd.get(0);
                }else{
                    fwdd=Integer.MAX_VALUE;
                    System.out.println("no");
                    continue;
                }
                if(def.size()>0){
                    deff=def.get(0);
                }else{
                    deff=Integer.MAX_VALUE;
                    System.out.println("no");
                    continue;
                }
                int tot = deff+fwdd;
                if (tot > dollarsToSpend) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}