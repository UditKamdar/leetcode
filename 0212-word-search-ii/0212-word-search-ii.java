class Solution {
    class TrieNode{
        boolean isEndOfWord = false;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    
    int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(String word: words){
            addWordIntoTrie(word);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){  
                dfs(board,i,j,ans, new StringBuilder(),visited, root);
            }
        }  
        return ans; 
    }

    public void addWordIntoTrie(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isEndOfWord = true;
    }


    public void dfs(char[][] board,int row, int column, List<String> ans, StringBuilder sb, boolean[][] visited, TrieNode node){
        if(row < 0 || row == board.length || column < 0 || column == board[0].length) return;
        if(visited[row][column]) return;

        char ch = board[row][column];
        if(node.children[ch-'a'] == null) return;

        visited[row][column] = true;
        sb.append(ch);
        node = node.children[ch - 'a'];

        if(node.isEndOfWord){
            ans.add(sb.toString());
            node.isEndOfWord = false;
        }

        for(int[] dir : directions){
            dfs(board, row + dir[0], column + dir[1], ans, sb, visited, node);
        }

        visited[row][column] = false;
        sb.setLength(sb.length() - 1);
    }
}