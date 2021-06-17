
class ReorganiseString {
    class Pair implements Comparable<Pair> {
        int key;
        char val;

        public int compareTo(Pair pair) {
            return pair.key - this.key;
        }

        Pair(int key, char val) {
            this.key = key;
            this.val = val;
        }
    }

    public String reorganizeString(String s) {
        int len = s.length();
        if (len <= 1)
            return s;
        int maxFreq = (len + 1) / 2;
        ArrayList<Pair> freq = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            freq.add(new Pair(0, (char) ('a' + i)));
        }
        for (int i = 0; i < len; i++) {
            Pair pair = freq.get(s.charAt(i) - 'a');
            pair.key++;
        }
        Collections.sort(freq);
        Pair pair = freq.get(0);
        if (pair.key > maxFreq)
            return "";
        char chArray[] = new char[len];
        int index = 0;
        for (Pair p : freq) {
            for (int i = 0; i < p.key; i++) {
                if (index >= len)
                    index = 1;
                chArray[index] = p.val;
                index += 2;
            }
        }
        return String.valueOf(chArray);

    }
}