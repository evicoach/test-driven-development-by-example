package com.columnhack;

public class Dollar {
    int amount;
    public Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier){
        int product = this.amount * multiplier;
        return new Dollar(product);
    }
}
