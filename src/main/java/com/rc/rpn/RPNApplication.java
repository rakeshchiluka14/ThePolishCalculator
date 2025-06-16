package com.rc.rpn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class RPNApplication {

    public static final String NOT_REVERSE_POLISH_NOTATION_TRY_BACKWARDS = "Not Reverse Polish Notation try backwards";

    public static void main(String[] args) throws IOException {

        if(args.length < 1){
            System.err.println("Usage : Java RPNApplication <input-file> ");
            return;
        }

        String inputFile =  args[0];
        String outputFile =  args.length > 1  ? args [1] : "output.txt";   // default output file.

        RPNCalculator rpnCalculator = new RPNCalculator();

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));

            List<String> results = lines.stream()
                    .map(line -> {
                        Optional<Double> result = RPNCalculator.evaluate(line);
                        String output = result.map(String::valueOf)
                                .orElse("Not Reverse Polish Notation try backwards");
                        return line + " = " + output;
                    })
                    .toList();

            Files.write(Paths.get(outputFile), results);

            System.out.println("Results written to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }



    }





}
