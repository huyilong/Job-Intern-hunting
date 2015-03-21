/**
 * Problem: Decide max profit with one transaction of buying and selling stock
 *
 * Solution: Track min price to buy stock and track max profit to sell stock
 */

public class BestTimeStock{
	public int maxProfit(int[] prices){
		if(prices==null || prices.length==0){
			return 0;
		}
		int minPrice = Integer.MAX_VALUE;
		int profit = 0;
		for(int price: prices){
			//current min price
			if(price < minPrice){
				minPrice = price;
				System.out.println("minprice: "+minPrice);
			}
			//current max profit
			if(price-minPrice > profit){
				profit = price-minPrice;
				System.out.println("profit:" +profit);
			}
		}
		return profit;
	}
}