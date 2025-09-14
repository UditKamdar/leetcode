import java.util.*;

class Solution {
    Set<Character> vowels = Set.of('a','e','i','o','u');

    public String[] spellchecker(String[] wordlist, String[] queries) {
       
       Map<String, String> caseInsensitive = new HashMap<>();
       Map<String, String> vowelInsensitive = new HashMap<>();
       Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));

       for(String word: wordlist){
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(dvowel(lower), word);
       }
       
       String[] ans = new String[queries.length];
       for(int i = 0; i < queries.length; i++){
            String query = queries[i];

            if(exactWords.contains(query)){
                ans[i] = query; // exact match
            } 
            else {
                String lower = query.toLowerCase();
                if(caseInsensitive.containsKey(lower)){
                    ans[i] = caseInsensitive.get(lower); // capitalization match
                } else {
                    ans[i] = vowelInsensitive.getOrDefault(dvowel(lower), ""); // vowel match
                }
            }
       }
       return ans;
    }

    private String dvowel(String word){
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            if(vowels.contains(c)){
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
