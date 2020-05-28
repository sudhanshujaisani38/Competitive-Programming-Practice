import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map.Entry;

//given a number of transactions betweeen people,
//find the minimum no of transactions to settle down the amounts.

class SplitwiseApp{
    HashMap<String,Integer> amountToSettle =new HashMap<>();

    public static void main(String[] args) {
        SplitwiseApp splitwiseApp=new SplitwiseApp();
        splitwiseApp.makeTransaction("A","B",100);
        splitwiseApp.makeTransaction("B","C",20);
        splitwiseApp.makeTransaction("C","D",80);
        splitwiseApp.makeTransaction("D","A",50);
        splitwiseApp.settleAmounts();
    }

    private void settleAmounts() {
        System.out.println(this.amountToSettle);
        TreeSet<Pair> treeSet=new TreeSet<>();
        for(Entry<String,Integer> entry:amountToSettle.entrySet()){
            if(entry.getValue()!=0){
                treeSet.add(new Pair(entry.getKey(),entry.getValue()));
            }
        }
        while(!treeSet.isEmpty()){
            Pair low=treeSet.pollFirst();
            Pair high=treeSet.pollLast();
            int settlementAmount=Math.min(-1*low.amount, high.amount);
            System.out.println(low.person+" pays "+settlementAmount+" to "+high.person);
            Pair l=new Pair(low.person, low.amount+settlementAmount);
            Pair h=new Pair(high.person, high.amount-settlementAmount);
            if(l.amount!=0){
                treeSet.add(l);
            }
            if(h.amount!=0){
                treeSet.add(h);
            }
        }
    }

    private void makeTransaction(String sender, String receiver, int amount) {
        int sendersCurrentAmount=amountToSettle.getOrDefault(sender, 0);
        int receiversCurrentAmount=amountToSettle.getOrDefault(receiver, 0);
        amountToSettle.put(sender, sendersCurrentAmount+amount);
        amountToSettle.put(receiver, receiversCurrentAmount-amount);
    }

    

    static class Pair implements Comparable<Pair>{
        String person;
        int amount;

        public Pair(String p, int a) {
            person = p;
            amount = a;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.amount-o.amount!=0){
                return this.amount-o.amount;
            }
            return this.person.compareTo(o.person);
        }
        
    }


}