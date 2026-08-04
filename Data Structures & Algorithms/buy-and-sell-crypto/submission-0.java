class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;
        int profit = 0;
        while (l < prices.length && r < prices.length) {
            profit = prices[r] - prices[l];
            if (profit < 0) {
                l = r;
                r = l+1;
            } else {
                maxProfit = Math.max(profit, maxProfit);
                r++;
            }
        }
        return maxProfit;
    }
}
