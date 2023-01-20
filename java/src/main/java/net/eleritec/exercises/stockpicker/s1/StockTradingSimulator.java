package net.eleritec.exercises.stockpicker.s1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StockTradingSimulator {

	public static void main(String[] args) {
		int[] prices = {5, 4, 8, 10, 7, 3, 2, 6, 5, 8};
		
		showProfit(new StockPickerA(), prices);
		showProfit(new StockPickerB(), prices);
	}	
	
	private static void showProfit(StockPicker picker, int...prices) {
		printResult(picker.getClass().getSimpleName(), prices, picker.getMaxProfit(prices));
	}
	
	private static void printResult(String strategy, int[] prices, int profit) {
		println("Max Profit (%s): %s -> %d", strategy, toString(prices), profit);
	}
	
	private static String toString(int[] array) {
		List<String> values = Arrays.stream(array).boxed().map(i->i.toString()).collect(Collectors.toList());
		return String.format("[%s]", String.join(",", values));
	}
	
	private static void println(String pattern, Object...args) {
		System.out.println(String.format(pattern, args));
	}
}
