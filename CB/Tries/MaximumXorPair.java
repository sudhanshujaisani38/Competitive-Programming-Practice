import java.util.HashMap;

//given an array of numbers, find the pair which will give highest xor value.
class Trie {
    Node rootNode;

    public Trie() {
        rootNode = new Node(123);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        int numbers[] = { 3, 5, 25, 8, 15 };
        trie.addNumber(numbers[0]);
        int num1 = -1, num2 = -1, maxXor = 0;
        for (int i = 1; i < numbers.length; i++) {
            int xor = trie.solve(numbers[i]);
            if (xor > maxXor) {
                maxXor = xor;
                num1 = numbers[i];
                num2 = num1 ^ maxXor;
            }
            trie.addNumber(numbers[i]);
        }
        System.out.println("maximum xor will be:"+num1 + "^" + num2 + "=" + maxXor);
    }

    private int solve(int num) {
        Node node = rootNode;
        int num2=0;
        for (int bit = 31; bit >= 0; bit--) {
            int bitValue = (1 << bit) & num;
            if (bitValue != 0)
                bitValue = 1;
            int requiredValue=1-bitValue;
            if(node.children.containsKey(requiredValue)){
                if(requiredValue==1){
                    num2=num2|(1<<bit);
                }
                node=node.children.get(requiredValue);                
            }else{
                node=node.children.get(bitValue);
                if(bitValue==1){
                    num2=num2|(1<<bit);
                }
            }
        }
        System.out.println("for "+num+": "+num2);
        return num^num2;
    }

    public void addNumber(int n) {
        Node node = rootNode;
        for (int i = 31; i >= 0; i--) {
            int bitValue = (1 << i) & n;
            if (bitValue != 0) {
                bitValue = 1;
            }
            if (node.children.containsKey(bitValue)) {
                node = node.children.get(bitValue);
            } else {
                Node newNode = new Node(bitValue);
                node.children.put(bitValue, newNode);
                node = newNode;
            }
        }
        node.isTerminal = true;
    }

    static class Node {
        int bitValue;
        HashMap<Integer, Node> children = new HashMap<>();
        boolean isTerminal = false;

        public Node(int data) {
            bitValue = data;
        }
    }
}