class Solution {

    class TrieNode{
        boolean isPresent;
        TrieNode[] children;
        int count;

        TrieNode(boolean v){
            this.isPresent = v;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode(false);
    public int prefixCount(String[] words, String pref) {
        
        for(String word: words){
            addWordToTrie(word, root);
        }

        return search(0, pref, root);
    }

    public int search(int idx, String pref, TrieNode root){

        if(idx == pref.length()){
            return root.count;
        }

        int ascii = pref.charAt(idx) - 'a';
        if(root.children[ascii] == null){
            return 0;
        }

        return search(idx + 1, pref, root.children[ascii]);
    }
    public void addWordToTrie(String word, TrieNode root){
        
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new TrieNode(true);
            }
            node.children[idx].count++;
            node = node.children[idx];
        }
    }
}