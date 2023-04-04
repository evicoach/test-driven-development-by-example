package com.columnhack.module_one;

public class Franc extends Money {

    @Override
    public String currency() {
        return currency;
    }

    protected Franc(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Franc)) {
            return false;
        }

        Franc franc = (Franc) obj;
        return this.amount == franc.amount;
    }
}
