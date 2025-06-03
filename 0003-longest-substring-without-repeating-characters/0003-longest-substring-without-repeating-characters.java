class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for(int right =0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }           
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);

            // to Get Actual String
                //int start = 0;
                // if(right-left+1 > max){
                //     max = right - left + 1;
                //     start = left;
                // }
                //return s.substring(start,index+max);
        }
        return max;
    }
}