class Solution {
    public String reorganizeString(String s) {
        int set[] = new int[26];
        for(char c: s.toCharArray()){
            int digit = c - 'a';
            set[digit]++;
        }

        int max = 0, letter = 0;
        for(int i =0; i < set.length; i++){
            if(set[i] > max){
                max = set[i];
                letter = i;
            }
        } 

        if(max > (s.length() + 1)/2) return "";
        char[] result = new char[s.length()];
        int index = 0;

        while(max > 0){
            char c = (char) (letter + 'a');
            result[index] = c;
            index += 2;
            max--;
        }

        for(int i =0; i < set.length; i++){
            if(i == letter) continue;
            while(set[i] > 0){
                if(index >= result.length) index = 1;
                result[index] = (char) (i + 'a');
                set[i]--;
                index += 2;
            }
        }
        return new String(result);
    }
}