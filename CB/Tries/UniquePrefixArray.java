import java.util.HashMap;

//given an array of strings, find the unique prefixes of every string and if no unique prefix exists, print -1
class Trie {
    Node rootNode;
    public Trie(){
        rootNode=new Node('\0');
    }
    public void insert(String word){
        Node node=rootNode;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(node.children.containsKey(c)){
                node=node.children.get(c);
                node.noOfRepetitions++;
            }else{
                Node newNode=new Node(c);
                node.children.put(c, newNode);
                node=newNode;
            }
        }
        node.isTerminal=true;
    }
    public static void main(String...args){
        Trie trie=new Trie();
        String words[]={"dog","dove","duck","tiger","tigers"};
        for(String word:words){
            trie.insert(word);
        }
        for(String word:words){
            String uniquePrefix=trie.getUniquePrefix(word);
            System.out.println(word+":"+uniquePrefix);
        }
    }

    private String getUniquePrefix(String word) {
        String uniquePrefix="";
        Node node=rootNode;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            node=node.children.get(c);
            uniquePrefix+=c;
            if(node.noOfRepetitions==1){
                return uniquePrefix;
            }
        }
        return "-1";
    }

    static class Node {
        char data;
        HashMap<Character, Node> children = new HashMap<>();
        boolean isTerminal = false;
        int noOfRepetitions;

        public Node(char data) {
            System.out.println("new node:"+data);
            this.data = data;
            this.noOfRepetitions=1;
        }
    }
}