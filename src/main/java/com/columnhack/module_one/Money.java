package com.columnhack.module_one;

public abstract class Money {
    protected String currency;
    protected int amount;

    public abstract String currency();

    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public abstract Money times(int multiplier);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Money)) {
            return false;
        }
        Money money = (Money) obj;
        return this.amount == money.amount
                && this.getClass().equals(obj.getClass());
    }
}
