package com.rc.rpn;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RPNCalculator {

    private static final Map<String, Function<Deque<Double>, Boolean>> operations = createOperations();


    public static Optional<Double> evaluate(String input) {

        if (input == null || input.trim().isEmpty())
            return Optional.empty();

        Deque<Double> deque = new ArrayDeque<>();
        String[] tokens = input.trim().split("\\s+");

        for (String token : tokens) {
            if (operations.containsKey(token)) {
                boolean success = operations.get(token).apply(deque);
                if (!success)
                    return Optional.empty();
            } else {
                try {
                    deque.push(Double.parseDouble(token));
                } catch (NumberFormatException numberFormatException) {
                    return Optional.empty();
                }
            }
        }
        return deque.size() == 1 ? Optional.of(deque.pop()) : Optional.empty();
    }

    private static Map<String, Function<Deque<Double>, Boolean>> createOperations() {
        Map<String, Function<Deque<Double>, Boolean>> stringFunctionHashMap = new HashMap<>();

        //Binary operations
        stringFunctionHashMap.put("+", binary((a, b) -> a + b));
        stringFunctionHashMap.put("-", binary((a, b) -> a - b));
        stringFunctionHashMap.put("*", binary((a, b) -> a * b));
        stringFunctionHashMap.put("/", binary((a, b) -> a / b));
        stringFunctionHashMap.put("mod", binary((a, b) -> a % b));
        stringFunctionHashMap.put("avg", binary((a, b) -> (a + b) / 2));

        //unary operations
        stringFunctionHashMap.put("sqrt", unary(Math::sqrt));
        stringFunctionHashMap.put("sin", unary((Math::sin)));
        stringFunctionHashMap.put("cos", unary(Math::cos));

        return stringFunctionHashMap;
    }

    private static Function<Deque<Double>, Boolean> binary(BiFunction<Double, Double, Double> doubleBiFunction) {
        return stack -> {
            if (stack.size() < 2) return false;
            double b = stack.pop();
            double a = stack.pop();
            stack.push(doubleBiFunction.apply(a, b));
            return true;
        };

    }

    private static Function<Deque<Double>, Boolean> unary(Function<Double, Double> doubleFunction) {
        return stack -> {
            if (stack.isEmpty()) return false;
            double a = stack.pop();
            stack.push(doubleFunction.apply(a));
            return true;
        };

    }


}
