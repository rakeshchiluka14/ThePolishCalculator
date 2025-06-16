package com.rc.rpn;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RPNCalculatorTest {

    private final RPNCalculator rpnCalculator = new RPNCalculator();

    @Test
    public void testSimpleAddition() {
        assertEquals(Optional.of(3.0), rpnCalculator.evaluate("1 2 + "));
    }

    @Test
    public void testComplexExpression() {
        assertEquals(Optional.of(4.0), rpnCalculator.evaluate("6 3 * 2 - sqrt"));
    }

    @Test
    public void testInvalidExpression() {
        assertEquals(Optional.empty(), rpnCalculator.evaluate("1 + 1"));
    }

    @Test
    public void testModAndAvg() {
        assertEquals(Optional.of(2.0), rpnCalculator.evaluate("10 4  mod "));
        assertEquals(Optional.of(5.0), rpnCalculator.evaluate("4 6 avg "));
    }

    @Test
    public void testSinAndCos() {
        assertTrue(rpnCalculator.evaluate("0 sin").isPresent());
        assertTrue(rpnCalculator.evaluate("0 cos").isPresent());
    }


}
