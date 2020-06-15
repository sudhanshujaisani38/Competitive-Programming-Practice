import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.Polygon;

class Main {
    static class Point implements Comparable<Point> {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x)
                return (int)(this.y - o.y);
            else
                return (int)(this.x - o.x);
        }

        @Override
        public boolean equals(Object obj) {
            return this.compareTo((Point) obj) == 0;
        }
    }

    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int q = fastReader.nextInt();
                int x[] = new int[n];
                int y[] = new int[n];
                List<Point> points = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    x[i] = fastReader.nextInt();
                    y[i] = fastReader.nextInt();
                    points.add(new Point(x[i], y[i]));

                }

                Collections.sort(points);
                // System.out.println("sorted"+points);
                
                List<Polygon> layers=createLayers(points);
                query:while(q-->0){
                    int xx=fastReader.nextInt();
                    int yy=fastReader.nextInt();
                    for(int i=layers.size()-1;i>=0;i--){
                        Polygon p=layers.get(i);
                        if(p.contains(xx,yy)){
                            for(int j=0;j<p.npoints-1;j++){
                                if (isColinear(new Point(p.xpoints[j], p.ypoints[j]),new Point(xx,
                                yy) ,new Point(p.xpoints[j + 1], p.ypoints[j + 1])  )) {
                                    System.out.println(i);
                                    continue query;
                                }
                            }
                            System.out.println(i+1);
                            continue query;
                        }
                    }
                    System.out.println(0);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static boolean existsBetween(long x1, long y1, long x2, long y2, long x3, long y3) {

        return distance(x1, y1, x3, y3) + distance(x2, y2, x3, y3) == distance(x1, y1, x2, y2);

    }

    public static double distance(long x1, long y1, long x2, long y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    private static List<Polygon> createLayers(List<Point> points) {
        List<Point> copyPoints = new ArrayList<>();
        copyPoints.addAll(points);
        List<Polygon> pList=new ArrayList<>();
        Polygon p=null;
        while((p=convexHull(copyPoints))!=null){
            pList.add(p);
            // System.out.println(toString(p));
        }
        return pList;
    }
    public static String toString(Polygon p) {
        if (p.npoints == 0)
            return "[ ]";
        String s = "";
        s = s + "[ ";
        for (int i = 0; i < p.npoints; i++)
            s = s + p.xpoints[i] + "," + p.ypoints[i] + " ";
        s = s + "]";
        return s;
    }

    static Polygon convexHull(List<Point> copyPoints) {

        if (copyPoints.size() < 3)
            return null;
        List<Point> points = new ArrayList<>();
        points.addAll(copyPoints);
        int n = points.size();
        Point p1 = points.get(0), p2 = points.get(n - 1);
        ArrayList<Point> up = new ArrayList<>();
        ArrayList<Point> down = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || !isAntiClockWise(p1, points.get(i), p2)) {
                while (up.size() >= 2 && isAntiClockWise(up.get(up.size() - 2), up.get(up.size() - 1), points.get(i))) {
                    up.remove(up.size() - 1);
                }
                up.add(points.get(i));
            }
            if (i == n - 1 || !isClockWise(p1, points.get(i), p2)) {
                while (down.size() >= 2
                        && isClockWise(down.get(down.size() - 2), down.get(down.size() - 1), points.get(i))) {
                    down.remove(down.size() - 1);
                }
                down.add(points.get(i));
            }
        }

        points.clear();
        Polygon p = new Polygon();
        for (int i = 0; i < up.size(); i++) {
            points.add(up.get(i));
            p.addPoint((int)up.get(i).x, (int)up.get(i).y);
            copyPoints.remove(up.get(i));
        }
        for (int i = down.size() - 2; i >= 0; i--) {
            points.add(down.get(i));
            p.addPoint((int)down.get(i).x, (int)down.get(i).y);
            copyPoints.remove(down.get(i));
        }
        // System.out.println(points);
        return p;

    }

    static boolean isClockWise(Point a, Point b, Point c) {
        return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) < 0;
    }

    static boolean isAntiClockWise(Point a, Point b, Point c) {
        return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) > 0;
    }

    static boolean isColinear(Point a, Point b, Point c) {
        return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) == 0;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}