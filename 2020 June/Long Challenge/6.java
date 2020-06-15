import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int src[] = new int[3];
            int target[] = new int[3];
            ArrayList<Integer> slist = new ArrayList<>();
            ArrayList<Integer> tlist = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                src[i] = sc.nextInt();
            }
            for (int i = 0; i < 3; i++) {
                target[i] = sc.nextInt();
                if (src[i] != target[i]) {
                    slist.add(src[i]);
                    tlist.add(target[i]);
                }
            }
            if (slist.size() == 0) {
                System.out.println(0);
                continue;
            }
            if (is1Possible(slist, tlist)) {
                System.out.println(1);
                continue;
            }
            if ((src[0] <= 10 && src[0] >= -10) && (src[1] <= 10 && src[1] >= -10) && (src[2] <= 10 && src[2] >= -10)
                    && (target[0] <= 10 && target[0] >= -10) && (target[1] <= 10 && target[1] >= -10)
                    && (target[2] <= 10 && target[2] >= -10)) {
                if (is2PossibleBF(slist, tlist)) {
                    System.out.println(2);
                    continue;
                }
            } else if (is2Possible(slist, tlist)) {
                System.out.println(2);
                continue;
            }
            System.out.println(3);
        }
    }

    private static boolean is2Possible(ArrayList<Integer> slist, ArrayList<Integer> tlist) {
        if (slist.size() == 2) {
            return true;
        }
        int t0 = tlist.get(0), t1 = tlist.get(1), t2 = tlist.get(2);
        int s0 = slist.get(0), s1 = slist.get(1), s2 = slist.get(2);
        int diffs[] = new int[3];
        int facts[] = new int[3];
        diffs[0] = t0 - s0;
        diffs[1] = t1 - s1;
        diffs[2] = t2 - s2;
        if (s1 != 0 && t1 % s1 == 0) {
            facts[1] = t1 / s1;
        } else {
            facts[1] = Integer.MAX_VALUE;
        }
        if (s2 != 0 && t2 % s2 == 0) {
            facts[2] = t2 / s2;
        } else {
            facts[2] = Integer.MAX_VALUE;
        }
        if (s0 != 0 && t0 % s0 == 0) {
            facts[0] = t0 / s0;
        } else {
            facts[0] = Integer.MAX_VALUE;
        }
        if (diffs[0] == diffs[1])
            return true;
        if (diffs[1] == diffs[2])
            return true;
        if (diffs[0] == diffs[2])
            return true;

        if (facts[0] != Integer.MAX_VALUE && facts[0] == facts[1])
            return true;
        if (facts[0] != Integer.MAX_VALUE && facts[0] == facts[2])
            return true;
        if (facts[2] != Integer.MAX_VALUE && facts[2] == facts[1])
            return true;

        if (facts[0] == facts[1] * facts[2])
            return true;
        if (facts[1] == facts[0] * facts[2])
            return true;
        if (facts[2] == facts[0] * facts[1])
            return true;
        if (diffs[0] == diffs[1] + diffs[2])
            return true;
        if (diffs[1] == diffs[0] + diffs[2])
            return true;
        if (diffs[2] == diffs[0] + diffs[1])
            return true;

        if (s1 * facts[2] + diffs[0] == t1)
            return true;
        if (s1 * facts[0] + diffs[2] == t1)
            return true;
        if ((s1 + diffs[0]) * facts[2] == t1)
            return true;
        if ((s1 + diffs[2]) * facts[0] == t1)
            return true;

        if (s2 * facts[0] + diffs[1] == t2)
            return true;
        if (s2 * facts[1] + diffs[0] == t2)
            return true;
        if ((s2 + diffs[0]) * facts[1] == t2)
            return true;
        if ((s2 + diffs[1]) * facts[0] == t2)
            return true;

        if (s0 * facts[1] + diffs[2] == t0)
            return true;
        if (s0 * facts[2] + diffs[1] == t0)
            return true;
        if ((s0 + diffs[1]) * facts[2] == t0)
            return true;
        if ((s0 + diffs[2]) * facts[1] == t0)
            return true;
        Point pt = lineLineIntersection(s1, 1, t1, s2, 1, t2);
        if (pt.x != Integer.MAX_VALUE && pt.y != Integer.MAX_VALUE) {
            if (s0 * pt.x + pt.y == t0 || s0 * pt.x == t0 || s0 + pt.y == t0) {
                // System.out.println("common pt:"+pt);
                return true;
            }
        }
        pt = lineLineIntersection(s0, 1, t0, s2, 1, t2);
        if (pt.x != Integer.MAX_VALUE && pt.y != Integer.MAX_VALUE) {
            if (s1 * pt.x + pt.y == t1 || s1 * pt.x == t1 || s1 + pt.y == t1) {
                // System.out.println("common pt:"+pt);
                return true;
            }
        }
        pt = lineLineIntersection(s0, 1, t0, s1, 1, t1);
        if (pt.x != Integer.MAX_VALUE && pt.y != Integer.MAX_VALUE) {
            if (s2 * pt.x + pt.y == t2 || s2 * pt.x == t2 || s2 + pt.y == t2) {
                // System.out.println("common pt:"+pt);
                return true;
            }
        }
        pt = lineLineIntersection2(s0, t0, s1, t1);
        if (pt.x != Integer.MAX_VALUE && pt.y != Integer.MAX_VALUE) {
            if ((s2 + pt.y) * pt.x == t2 || s2 * pt.x == t2 || s2 + pt.y == t2) {
                // System.out.println("common pt2:"+pt);
                return true;
            }
        }
        pt = lineLineIntersection2(s2, t2, s1, t1);
        if (pt.x != Integer.MAX_VALUE && pt.y != Integer.MAX_VALUE) {
            if ((s0 + pt.y) * pt.x == t0 || s0 * pt.x == t0 || s0 + pt.y == t0) {
                // System.out.println("common pt2:"+pt);
                return true;
            }
        }
        pt = lineLineIntersection2(s0, t0, s2, t2);
        if (pt.x != Integer.MAX_VALUE && pt.y != Integer.MAX_VALUE) {
            if ((s1 + pt.y) * pt.x == t1 || s1 * pt.x == t1 || s1 + pt.y == t1) {
                // System.out.println("common pt2:"+pt);
                return true;
            }
        }

        return false;
    }

    static Point lineLineIntersection(double a1, double b1, double c1, double a2, double b2, double c2) {
        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } else {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            int xint = (int) x;
            int yint = (int) y;
            if (xint == x && yint == y) {
                return new Point(xint, yint);
            } else {
                return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    static Point lineLineIntersection2(double s1, double t1, double s2, double t2) {
        double determinant = t1 - t2;

        if (determinant == 0) {
            return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } else {
            double y = (s1 * t2 - t1 * s2) / determinant;
            double x = Integer.MAX_VALUE;
            if (y != 0) {
                x = t1 / (s1 + y);
            }
            int xint = (int) x;
            int yint = (int) y;
            if (x != Integer.MAX_VALUE && xint == x && yint == y) {
                return new Point(xint, yint);
            } else {
                return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    private static boolean is1Possible(ArrayList<Integer> slist, ArrayList<Integer> tlist) {
        if (slist.size() == 1) {
            return true;
        }
        boolean isAllZero = true;
        for (int i = 0; i < tlist.size(); i++) {
            if (tlist.get(i) != 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero) {
            return true;
        }
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i = 0; i < slist.size(); i++) {
            hs1.add(tlist.get(i) - slist.get(i));
        }
        if (hs1.size() == 1) {
            return true;
        }

        HashSet<Integer> hs2 = new HashSet<>();
        for (int i = 0; i < slist.size(); i++) {
            int s = slist.get(i);
            int t = tlist.get(i);
            if (s == 0) {
                hs2.add(Integer.MAX_VALUE);
            } else if (t % s == 0) {
                hs2.add(t / s);
            } else {
                hs2.add(Integer.MAX_VALUE);
            }
        }
        if (hs2.contains(Integer.MAX_VALUE)) {
            return false;
        }
        if (hs2.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    private static boolean is2PossibleBF(ArrayList<Integer> slist, ArrayList<Integer> tlist) {
        if (slist.size() == 2) {
            return true;
        }
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            hs1.add(tlist.get(i) - slist.get(i));
        }
        if (hs1.size() == 2) {
            return true;
        }
        HashSet<Integer> hs2 = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int s = slist.get(i);
            int t = tlist.get(i);
            if (s == 0) {
                hs2.add(Integer.MAX_VALUE);
            } else if (t % s == 0) {
                hs2.add(t / s);
            } else {
                hs2.add(Integer.MAX_VALUE);
            }
        }
        if (!hs2.contains(Integer.MAX_VALUE) && hs2.size() == 2) {
            return true;
        }
        int t0 = tlist.get(0), t1 = tlist.get(1), t2 = tlist.get(2);
        int s0 = slist.get(0), s1 = slist.get(1), s2 = slist.get(2);
        for (int diff = -200; diff <= 200; diff++) {
            for (int factor = -100; factor <= 100; factor++) {
                if ((s0 * factor == t0 || (s0 + diff) * factor == t0 || s0 + diff == t0)
                        && (s1 * factor == t1 || (s1 + diff) * factor == t1 || s1 + diff == t1)
                        && (s2 * factor == t2 || (s2 + diff) * factor == t2 || s2 + diff == t2))
                    return true;
            }
        }
        for (int diff = -200; diff <= 200; diff++) {
            for (int factor = -100; factor <= 100; factor++) {
                if ((s0 + diff == t0 || (s0 * factor) + diff == t0 || s0 * factor == t0)
                        && (s1 + diff == t1 || (s1 * factor) + diff == t1 || s1 * factor == t1)
                        && (s2 + diff == t2 || (s2 * factor) + diff == t2 || s2 * factor == t2))
                    return true;
            }
        }
        for (int factor1 = -100; factor1 <= 100; factor1++) {
            for (int factor2 = -100; factor2 <= 100; factor2++) {
                if ((s0 * factor2 == t0 || s0 * factor1 * factor2 == t0 || s0 * factor1 == t0)
                        && (s1 * factor2 == t1 || s1 * factor1 * factor2 == t1 || s1 * factor1 == t1)
                        && (s2 * factor2 == t2 || s2 * factor1 * factor2 == t2 || s2 * factor1 == t2))
                    return true;
            }
        }
        for (int diff1 = -200; diff1 <= 200; diff1++) {
            for (int diff2 = -200; diff2 <= 200; diff2++) {
                if ((s0 + diff2 == t0 || s0 + diff1 + diff2 == t0 || s0 + diff1 == t0)
                        && (s1 + diff2 == t1 || s1 + diff1 + diff2 == t1 || s1 + diff1 == t1)
                        && (s2 + diff2 == t2 || s2 + diff1 + diff2 == t2 || s2 + diff1 == t2))
                    return true;
            }
        }

        return false;
    }

}