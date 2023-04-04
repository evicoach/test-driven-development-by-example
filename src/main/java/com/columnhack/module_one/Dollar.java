package com.columnhack.module_one;

public class Dollar extends Money {

    @Override
    public String currency() {
        return currency;
    }

    protected Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }


}
