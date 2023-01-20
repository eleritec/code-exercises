import stock_picker_a
import stock_picker_b


def pick_stocks():
    prices = [5, 4, 8, 10, 7, 3, 2, 6, 5, 8]
    
    show_profit("A", stock_picker_a.get_max_profit, prices)
    show_profit("B", stock_picker_b.get_max_profit, prices)

def show_profit(s_name, picker_fn, prices):
    profit = picker_fn(prices)
    print("Max Profit (Picker_{}): {} -> {}".format(s_name, prices, profit))

if __name__ == "__main__":
    pick_stocks()