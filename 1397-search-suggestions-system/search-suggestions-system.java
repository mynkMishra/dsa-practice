class Solution {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        TrieNode(){
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word){

        TrieNode node = root;

        for(char ch: word.toCharArray()){
            int idx = ch - 'a';

            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }

    public void dfsWithPrefix(TrieNode node, String prefix, List<String> list){

        if(list.size() == 3){
            return;
        }

        if(node.isEnd){
            list.add(prefix);
        }
        
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                dfsWithPrefix(node.children[i], prefix + (char)(97 + i), list);
            }
        }
    }

    public List<String> search(String str){

        TrieNode node = root;
        StringBuilder sb = new StringBuilder();

        List<String> l = new ArrayList<String>();
        for(char ch: str.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] != null){
                node = node.children[idx];
            }else{
                return l;
            }
        }

        dfsWithPrefix(node, str, l);

        return l;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();

        for(String str: products){
            insert(str);
        }

        List<List<String>> ans = new ArrayList<List<String>>();

        for(int i = 1; i <= searchWord.length(); i++){
            ans.add(search(searchWord.substring(0, i)));
        }

        return ans;
    }
}