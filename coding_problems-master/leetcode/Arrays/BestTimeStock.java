//best time to buy and sell stock with only one transaction

public class BestTimeStock{
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){
            return 0;
        }
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        int len = prices.length;
        for(int i=0; i<len; i++){
        	//find min price to buy stock 
            buyPrice = Math.min(prices[i],buyPrice);
            //find max profit
            maxProfit = Math.max(maxProfit,prices[i]-buyPrice);
        }
        return maxProfit;
    }
}