package com.rohinisha;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils utils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    void beforeAllInit(){
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        utils = new MathUtils();
        testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());

    }

    @Test
    @DisplayName("Testing add method")
    @Tag("Math")
    void add() {
       int actual = utils.add(2 ,4);
       //assertEquals(6, actual, () ->"Add Method should add two number");
       assertThat(5).as("Add method should add two number").isEqualTo(actual);
    }

    @Test
    @Tag("Circle")
    void testComputeRadius() {
        assertEquals(314.1592653589793, utils.computeCircleRadius(10), () ->"Show the radius of the circle");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testDivide() {
        assumeTrue(true);
        assertThrows(ArithmeticException.class, () ->utils.divide(1,0), () ->"Exception not throws when divide by zero");
    }

    @Test
    @DisplayName("Multiply method")
    @Tag("Math")
    void testMultiply(){
           assertAll(
                () ->assertEquals(6, utils.multiply(2,3)),
                () ->assertEquals(4, utils.multiply(2,2)),
                 () ->assertEquals(2, utils.multiply(2,1))
        );
    }

    @Test
    @Disabled
    @DisplayName("Test Disabled")
    void testDisable() {

        fail("Hello Implement me");
    }

    @RepeatedTest(10)
    void testRepetition(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition " + repetitionInfo.getCurrentRepetition() + " out of " + repetitionInfo.getTotalRepetitions());
        assertEquals(10, repetitionInfo.getTotalRepetitions());
    }


}