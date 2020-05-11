import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            int grid[][] = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Particle particle[] = new Particle[n];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y= sc.nextInt();
                x--;y--;
                int p= sc.nextInt();
                particle[i]=new Particle(p, grid[x][y], x, y, i);
            }
            ArrayList<Pair>pairs=new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(particle[i].isSideAdj(particle[j])){
                        pairs.add(new Pair(particle[i],particle[j]));
                    }
                }
            }
            // System.out.println("adj pairs:"+pairs);
            int max = (1 << n) - 1;
            int maxV = 0;
            int neededSign[]=new int[n];
            for (int i = 0; i <= max; i++) {
                int signs=i;
                int sign[] = new int[n];
                int index = 0;
                while (signs != 0) {
                    if ((signs & 1) == 1) {
                        sign[index] = -1;                        
                    }
                    signs = signs >> 1;
                    index++;
                }

                for (int z = 0; z < n; z++) {
                    if (sign[z] == 0) {
                        sign[z] = 1;
                    }
                }
                // System.out.print("v for:"+i);
                int v = calcMaxFor(sign, n,particle,pairs);
                
                if (v > maxV) {
                    maxV = v;
                    neededSign=sign;
                }
            }
            System.out.println(maxV);
            for(int i=0;i<n;i++){
                System.out.print(neededSign[i]+" ");
            }
            System.out.println();
        }
    }

    private static int calcMaxFor(int sign[], int n, Particle p[],ArrayList<Pair> pairs) {
        // System.out.println("calculating part 1");

        int part1 = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println("adding:"+(sign[i]*p[i].p)+"x"+p[i].h);
            part1 += (sign[i] * p[i].p * p[i].h);
        }
        // System.out.println("calculating part 2");
        int part2 = 0;
        for (int i = 0; i < pairs.size(); i++) {
            Particle p1=pairs.get(i).first;
            Particle p2=pairs.get(i).sec;
            // System.out.println("adding: "+(p1.p*sign[p1.i])+" x "+(p2.p*sign[p2.i]));
            part2+=(p1.p*p2.p*sign[p1.i]*sign[p2.i]);
        }
        // System.out.println("="+part1+"+"+part2+"="+(part1+part2));
        return part1 + part2;
    }
    static class Pair{
        Particle first;
        Particle sec;
        public Pair(Particle x,Particle y){
            first=x;
            sec=y;
        }
        @Override
        public String toString() {
            return "("+first+","+sec+")";
        }
       
        // public boolean equals(Pair pair) {
        //    boolean straight=(this.first==pair.first) &&(this.sec==pair.sec);
        //    boolean cross=(this.first==pair.sec)&&(this.sec==pair.first);
        //    return straight||cross;
        // }
    }
    static class Particle{
        int p;
        int h;
        int x;
        int y;
        int i;
        public Particle(int p, int h,int x,int y,int i) {
            this.p=p;
            this.h=h;
            this.x=x;
            this.y=y;
            this.i=i;
        }
        public boolean isSideAdj(Particle particle){
            boolean c1=(this.x==particle.x)&&((this.y==particle.y+1) || (this.y==particle.y-1));
            boolean c2=(this.y==particle.y) &&((this.x==particle.x+1)||(this.x==particle.x-1));
            return c1||c2;
        }
        @Override
        public String toString() {
            return "particle:"+i;
        }
    }
}