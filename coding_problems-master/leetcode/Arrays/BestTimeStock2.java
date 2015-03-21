//best time to buy and sell stock with multiple transactions

public class BestTimeStock2{
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){
            return 0;
        }
        int len = prices.length;
        int profit = 0;
        
        for(int i=0; i<len-1; i++){
            int diff = prices[i+1] - prices[i];
            //gain profit whenever find an ascending sequence
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }
}