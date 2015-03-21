/**
 * Problem: Find max profit using several transactions
 *
 * Solution: Perform a transaction whenver price goes down in adjacent days
 */

public class BestTimeStock2{
	public int maxProfit(int[] prices){
		if(prices==null || prices.length==0){
			return 0;
		}
		int len = prices.length;
		int profit = 0;
		for(int i=0; i<len-1; i++){
			int diff = prices[i+1] - prices[i];
			if(diff > 0){
				profit += diff;
			}
		}
		return profit;
	}
}