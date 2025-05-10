
class WordDictionary {
    
    class TrieNode{
        boolean isEndOfWord = false;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = null;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
        node = node.children[c-'a'];
        }

        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return search(word,0,root);
    }

    public boolean search(String word, int index, TrieNode node){
        if(index == word.length()) return node.isEndOfWord;

        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode ch : node.children){
                if( ch != null && search(word,index + 1, ch)){
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children[c-'a'];
            return child != null && search(word,index + 1, child);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */