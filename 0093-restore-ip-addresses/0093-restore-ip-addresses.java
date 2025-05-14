class Solution {  
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),ans);

        return ans;      
    }

    public void backtrack(String s, int start, List<String> path, List<String> ans){
        if(path.size() == 4 && s.length() == start){
            ans.add(String.join(".",path));
            return;
        }

        for(int len = 1; len <=3; len++){
            if(start + len > s.length()) break;

            String segment = s.substring(start,start + len);
            if((segment.startsWith("0") && segment.length() > 1) || Integer.parseInt(segment) > 255) continue;

            path.add(segment);
            backtrack(s,start + len, path, ans);
            path.remove(path.size() - 1);
        }
    }
}