class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        Queue<List<String>> q = new LinkedList<>();
        q.offer(list);
    
        Set<String> visitedInLevel = new HashSet<>();
        int level = 1;
        boolean foundShortest = false;


        while(!q.isEmpty()){
            List<String> currList = q.poll();
            String currWord = currList.get(currList.size() - 1);

            if(currWord.equals(endWord)){
                if(result.isEmpty()) {
                    result.add(new ArrayList<>(currList));
                } else if(result.get(0).size() == currList.size()){
                    result.add(new ArrayList<>(currList));
                }
                foundShortest = true;
            }

            if(currList.size() > level){
                set.removeAll(visitedInLevel);
                visitedInLevel.clear();

                level = currList.size();

                if(foundShortest) break;
            }

            for(int i =0; i < currWord.length(); i++){
                char[] arr = currWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    if (arr[i] == c) continue; 
                    arr[i] = c;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        // list.add(newWord);
                        // q.offer(list);
                        // list.remove(list.size() - 1);
                        List<String> newList = new ArrayList<>(currList);
                        newList.add(newWord);
                        q.offer(newList);
                        visitedInLevel.add(newWord);
                    }
                }
            }
        }
        return result;
    }
}