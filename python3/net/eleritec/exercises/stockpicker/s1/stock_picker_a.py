def get_max_profit(prices):
    profit = 0
    anchor = 0 if len(prices) < 1 else prices[0]
    
    # start from 1 since the 0th index can't trigger a trade
    for current in prices[1:]:
        if current > anchor:
            # record the larger of the potential profit values
            profit = max(profit, current - anchor)

        anchor = min(anchor, current)

    return profit