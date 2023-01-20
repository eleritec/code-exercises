def get_max_profit(prices):
    profit = 0
    position = 0
    price_count = len(prices)
    anchor = 0 if price_count < 1 else prices[0]

    # start from 1 since the 0th index can't trigger a trade
    for i, current in enumerate(prices[1:]): 
        last_price = i==price_count-2

        # determine whether we've exceeded a local min/max
        inflection = current > anchor # default to no-position
        if position > 0 and not last_price:
            # reverse if we currently hold a position
            inflection = current < anchor

        # if we hit an inflection point, execute a trade
        if inflection:
            # if we don't have a position, the issue a buy order
            if position == 0:
                position = anchor
                # if we're on the last price element while holding a position and we
				# hit an inflection point, then do one last sell before we exit
                if last_price:
                    profit += current - position
            # otherwise, issue a sell order
            else:
                sell_price = max(current, anchor) if last_price else anchor
                profit += sell_price - position
                position = 0
                
        # track the local min/max price value
        anchor = current

    return profit
