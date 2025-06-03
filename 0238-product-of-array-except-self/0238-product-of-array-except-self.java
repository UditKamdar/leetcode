class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int curr = 1;
        for(int i =0; i< nums.length;i++){
            ans[i] = curr;
            curr *= nums[i];
        }

        curr = 1;
        for(int j = nums.length-1;j>=0;j--){
            ans[j] *= curr;
            curr *= nums[j];
        }
        return ans;
    }
}