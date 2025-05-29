class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || target == 0) return result;

        dfs(candidates,target,0,result, new ArrayList<>());

        return result;
    }


    void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> path){
        
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(candidates[i] <= target){
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, result, path);
                path.remove(path.size() - 1);
            }
        }
    }
}