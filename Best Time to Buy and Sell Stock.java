// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
    public int maxProfit(int[] prices) {
            int le = prices.length, maxD = 0, min = Integer.MAX_VALUE;

    for (int i = 0; i < le; i++){ 
        min = Math.min(min, prices[i]);
        maxD = Math.max(maxD, prices[i] - min);
    }

    return maxD;  
    }
}
