import java.util.Scanner;

//Given an integer N which is a power of 2, i.e N=2^k, you have to fill a floor 
//of NxN with L shaped tiles such that there exists exactly one hole where there is
//no tile.
//This hole can be anywhere it doesn't matters
class TrominoTiling{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //n=2,4,8,16....
        solveTrominoTiling(n,n/2,n/2);
    }
    //given the dimension of floor and the position of hole,
    //this function tries to fill the floor with L shaped tiles
    //and prints it.
    private static void solveTrominoTiling(int n, int i, int j) {
        //base case
        if(n==2){

        }
        //recursive case
        else{

        }
    }
}