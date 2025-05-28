class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(buy < prices[i]){
                max = max + prices[i] - buy;
            }
            buy = prices[i];
        }
        return max;
    }
}