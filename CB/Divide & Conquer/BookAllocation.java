
//given n books and m students, minimize the maximum no of pages any of the student has to read
//e.g books: 10,20,30,40 and noOfStudents=2, ans=60 (student1 reads 10,20,30 and student2 reads 40)
//given:the no of pages are in sorted order
import java.util.Scanner;

class BookAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfBooks = sc.nextInt();
        int arr[] = new int[noOfBooks];
        int max=0;
        for (int i = 0; i < noOfBooks; i++) {
            arr[i] = sc.nextInt();
            max+=arr[i];
        }
        int noOfStudents = sc.nextInt();

        //giving min=arr[lastbook] because atleast one book will be assigned to every
        //student and in that case arr[lastbook] will be the ans.
        int ans = solveBookAllocationProblem(arr, noOfStudents, arr[noOfBooks-1], max);
        System.out.println(ans);
    }

    //given, that the ans lies between min & max inclusive,
    //solves the book allocation problem.
    private static int solveBookAllocationProblem(int[] arr, int noOfStudents,int min,int max) {
        int mid;
        int ans=max;
        while(max>min){
            mid=(min+max)/2;
            if(checkIfPossible(arr, noOfStudents, mid)){    //if mid can be ans, try 
                                                            //to minimize it by calling it on left part
                                                            //else it will be in right part
                ans=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return ans;
    }

    static boolean checkIfPossible(int arr[],int noOfStudents,int max){
        int booksRead=0;
        int noOfBooks=arr.length;
        while(noOfStudents-->0){                    //loop untill all students have read
            int noOfPages=0;
            for(int i=booksRead;i<noOfBooks;i++){   //try to read books untill max no of pages are read by
                                                    //the current student
                if(noOfPages+arr[i]<=max){
                    noOfPages+=arr[i];
                    booksRead++;
                }else{
                    break;
                }

                if(booksRead==noOfBooks){           //if all the books have been read
                    return true;
                }
            }
        }
        return false;                               //if some books are left but all students have read
    }
}