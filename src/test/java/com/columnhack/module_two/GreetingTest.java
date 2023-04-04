package com.columnhack.module_two;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    Greeting greeting;

    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before - I am only called once.");
    }

    @BeforeEach
    public void setUp(){
         greeting = new Greeting();

    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorld() {
        System.out.println(greeting.helloWorld("Evi"));
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void afterAll() {

    }

    @DisplayName(value = "Testing with a list of parameters")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Guru", "Framework"})
    public void testValueSource(String value){
        System.out.println("Printing out " + value);
    }
}