class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];

        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int i =0; i < nums.length; i++){
           if(!dq.isEmpty() && dq.peek() == i - k){     // when we write peek() it means peekFirst()
                dq.poll();                              // when we write poll() it means pollFirst()
           }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offer(i);
            if(i >= k - 1){
                ans[index++] = nums[dq.peek()];
            }
        }

        return ans;
    }
}