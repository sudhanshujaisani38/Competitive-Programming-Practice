import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class CB_Generate_Parantheses{
    static ArrayList<String> answers=new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        generateParantheses(n,0,"");
        Collections.sort(answers);
        for(int i=answers.size()-1;i>=0;i--){
            System.out.println(answers.get(i));
        }
    }

    private static void generateParantheses(int n,int bracketsOpen,String s) {
        //base case
        if(bracketsOpen==0 && s.length()==2*n){
            answers.add(s);
            return;
        }
        //recursive case
        if(bracketsOpen<n && s.length()<2*n)             //check if opening bracket can be inserted next: 
                                                        //it can be inserted only if maximum of (n-1) brackets are open
                                                        // and there is still space to enter something
        generateParantheses(n, bracketsOpen+1, s+"(");

        if(bracketsOpen>0 && s.length()<2*n)             //check if closing bracket can be inserted next
                                                        //it can be inserted only if atleast one bracket is open
                                                        //and there is still space to enter something
        generateParantheses(n, bracketsOpen-1, s+")");

    }
}