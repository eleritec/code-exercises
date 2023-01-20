package net.eleritec.exercises.stockpicker.s1;

public class StockPickerB implements StockPicker {

	@Override
	public int getMaxProfit(int[] prices) {
		int profit = 0;
		int current = 0;		
		int position = 0;
		int anchor = prices.length==0? 0: prices[0];

		// start from 1 since the 0th index can't trigger a trade
		for (int i = 1; i < prices.length; i++) {
			current = prices[i];
			boolean lastPrice = i==prices.length-1;
			
			// determine whether we've exceeded a local min/max
			boolean inflection = current > anchor; // default to having no-position
			if(position > 0 && !lastPrice) {
				// reverse if we currently hold a position
				inflection = current < anchor;
			}

			// if we've reached an inflection point, then make a trade
			if (inflection) {
				// if we have no position, then we'll do a buy
				if (position == 0) {
					position = anchor;
					// if we're on the last price element while holding a position and we
					// hit an inflection point, then do one last sell before we exit
					if (lastPrice) {
						profit += current - position;
					}
				// otherwise, sell
				} else {
					int sellPrice = lastPrice? Math.max(current, anchor): anchor;
					profit += sellPrice - position;
					position = 0;
				}
			}
			// track the local min/max price value
			anchor = current;
		}
		return profit;
	}

}
