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

			// if we've reached an inflection point, then make a trade
			if (isInflection(current, position, anchor, lastPrice)) {
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
	
	private boolean isInflection(int currentPrice, int position, int anchor, boolean lastPrice) {
		// if we don't currently have a position, then trigger a buy if we detect the 
		// prices is starting to increase (we exceeded the local minimum).
		if(position==0) {
			return currentPrice > anchor;
		}

		// normally trigger a sell if we detect the price is starting to decrease.
		// also trigger a sell if we're on the last available price and it's a local maximum.
		return lastPrice? currentPrice > anchor: currentPrice < anchor;
	}
}
