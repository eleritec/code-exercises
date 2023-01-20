package net.eleritec.exercises.stockpicker.s1;

public class StockPickerA implements StockPicker {

	@Override
	public int getMaxProfit(int[] prices) {
		int profit = 0;
		int current = 0;
		int anchor = prices.length==0? 0: prices[0];
		
		// start from 1 since the 0th index can't trigger a trade
		for(int i=1; i<prices.length; i++) {
			current = prices[i];

			if(current > anchor) {
				// record the larger of the potential profit values
				profit = Math.max(profit, current - anchor);	
			}
			
			anchor = Math.min(anchor, current);
		}
		
		return profit;
	}

}
