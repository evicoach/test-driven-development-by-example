package com.columnhack;

import com.columnhack.module_one.Dollar;
import com.columnhack.module_one.Franc;
import com.columnhack.module_one.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    @DisplayName("Should return the result of dollar multiplied by an integer")
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    @DisplayName(value = "Two currency objects with same value should be equal")
    void testEquality() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    @DisplayName("Should return the result of franc multiplied by an integer")
    void testMultiplicationFranc() {
        Franc five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }


    @Test
    @DisplayName(value = "Two Franc objects with same value should be equal")
    void testEqualityFranc() {
    }

    @Test
    @DisplayName(value = "Test currency")
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @DisplayName("CSV Test")
    @ParameterizedTest(name = "{displayName} [{index}] - {arguments}")
    @CsvFileSource(resources = {"/input.csv"}, numLinesToSkip = 1)
    public void csvTest(String state, int num1, int num2) {
        System.out.printf("The state is %s\n," +
                        " first address is %d\n," +
                        " and second address is %d\n",
                state, num1, num2);
    }

    @DisplayName("Arguments from method")
    @ParameterizedTest(name = "{displayName} [{index}] - {arguments}")
    @MethodSource(value = "getArgs")
    public void testArgumentFromMethod(String state, int addr1, int addr2){
        System.out.printf("The state is %s\n," +
                        " first address is %d\n," +
                        " and second address is %d\n",
                state, addr1, addr2);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
                Arguments.of("FL", 5, 1),
                Arguments.of("OH", 2, 8),
                Arguments.of("MI", 3, 5)
        );
    }
}
