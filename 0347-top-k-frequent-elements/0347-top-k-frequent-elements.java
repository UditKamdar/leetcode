class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        int[] ans = new int[k];
        int index = 0;
        while(k > 0){
            ans[index] = pq.poll();
            index++;
            k--;
        }

        return ans;
    }
}