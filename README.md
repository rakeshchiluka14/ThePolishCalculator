# ThePolishCalculator
A Reverse Polish Notation Calculator


# Reverse Polish Notation (RPN) Calculator - Java 8/17

This project is a simple and clean implementation of a Reverse Polish Notation (RPN) calculator written in Java, using modern Java 8+ features and test-driven development.

##  Features

- Supports:
    - `+`, `-`, `*`, `/`
    - `sqrt`, `sin`, `cos`
    - `mod`, `avg`
- Validates expressions and reports invalid RPN input
- Uses Java 8 features (lambdas, streams, Optional)
- Written using TDD and JUnit 5

## Build Requirements

- Java 8 or Java 17
- Maven 3.x

## Run the Application

```bash
mvn clean install
Go to the file RPNApplication in intellij and right Click and run the application


In IntelliJ IDEA: Pass arguments to your program

Open Run Configuration:
Go to Run > Edit Configurations...
Select your Run Configuration for RPNApplication
Set Program Arguments:
In the field labeled "Program arguments", enter:
input.txt
(Assuming input.txt is in the root of your project or the working directory)
Click Apply > OK

Run the program again.

Sample input.txt file
If you haven’t created one yet, here’s an example input.txt:

1 2 +
3 4 *
6 3 * 2 - sqrt
1 + 1
4 2 - 2 - 1000 *
10 4 mod
8 4 avg
9 sin
16 sqrt
Place this file in your project root, or wherever your working directory is (shown in the run config or terminal).


OR

java -cp target/classes com.rc.rpn.RPNApplication input.txt
