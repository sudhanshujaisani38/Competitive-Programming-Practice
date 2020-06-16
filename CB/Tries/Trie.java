import java.util.HashMap;

public class Trie {
    Node rootNode;
    public Trie(){
        rootNode=new Node('\0');
    }
    void insert(String word){
        Node node=rootNode;
        int n=word.length();
        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            if(node.children.get(c)!=null){
                node=node.children.get(c);
            }else{
                Node newNode=new Node(c);
                node.children.put(c,newNode);
                node=newNode;
            }
        }
        node.isTerminal=true;
    }
    boolean isPresent(String word){
        Node node=rootNode;
        int n=word.length();
        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            if(node.children.get(c)==null){
                return false;
            }else{
                node=node.children.get(c);
            }
        }
        return node.isTerminal;
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        String words[]={"hi","hello","hey","hola"};
        for(String word:words){
            trie.insert(word);
        }
        String words2[]={"hi","hello","hey","hola","there","h"};
        for(String word:words2){
            System.out.println(word+":"+trie.isPresent(word));
        }
    }

    static class Node{
        char data;
        HashMap<Character,Node> children;
        boolean isTerminal;
        public Node(char data){
            System.out.println("new node:"+data);
            this.data=data;
            this.children=new HashMap<>();
            isTerminal=false;
        }
    }
}