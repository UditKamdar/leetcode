class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int maxValue = Collections.max(map.values());
        int sum = 0;
        for(int val : map.values()){
            if(val == maxValue){
                sum += val;
            }
        }
        return sum;
    }
}