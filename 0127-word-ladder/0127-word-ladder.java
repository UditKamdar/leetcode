class Pair {
    String word;
    int level;

    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // for(String s: wordList){
        //     set.add(s);
        // }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair p = q.poll();
            String currWord = p.word;
            int currLevel = p.level;

            if(currWord.equals(endWord)){
                return currLevel;
            }

            for(int i = 0; i < currWord.length(); i++){
                char[] arr = currWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    arr[i] = c;
                    String newWord = new String(arr);

                    if(set.contains(newWord)){
                        q.offer(new Pair(newWord, currLevel + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}