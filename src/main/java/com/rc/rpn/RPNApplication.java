package com.rc.rpn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RPNApplication {

    public static final String NOT_REVERSE_POLISH_NOTATION_TRY_BACKWARDS = "Not Reverse Polish Notation try backwards";

    public static void main(String[] args) throws IOException {

        if(args.length < 1){
            System.err.println("Usage : Java RPNApplication <input-file> ");
            return;
        }

        RPNCalculator rpnCalculator = new RPNCalculator();

        Files.lines(Path.of(args[0]))
                .filter(line -> !line.trim().isEmpty())
                .map(line -> line +  " = "  + rpnCalculator.evaluate(line).map(Object::toString)
                        .orElse(NOT_REVERSE_POLISH_NOTATION_TRY_BACKWARDS))
                        .forEach(System.out ::println);





    }





}
