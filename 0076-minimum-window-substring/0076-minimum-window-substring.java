class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        int count = 0;
        int start = 0;

        Map<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0){
                    count++;
                }
                
            }

            while(count == t.length()){
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                              
                char l = s.charAt(left);
                if(map.containsKey(l)){
                    map.put(l, map.get(l) + 1);
                    if(map.get(l) > 0){
                         count--;
                    }                 
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? ans : s.substring(start, start + minLength);
    }
}