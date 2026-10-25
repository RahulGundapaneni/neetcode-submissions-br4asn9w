class Solution {
    public int maxProfit(int[] prices) {
        int prev = 0;
        int l = prices.length - 1;
        int result = 0;
        for(int i = 1; i <= l; i++) {
            if(prices[i] < prices[prev]) {
                prev  = i;
            }
            result = Math.max(result, prices[i] - prices[prev]);
        }
        return result;
    }
}
