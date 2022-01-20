package com.dleinbach.npcprompt.utility;

import java.util.LinkedList;

public class DiceParser {

    private final LinkedList<Operation> operations;


    private record DiceOperation(int number, int diceValue) implements Operation {

        @Override
        public int calc(int currentValue) {
            return currentValue + Math.toIntExact(number * Math.round(((Math.random() * (diceValue - 1)) + 1)));
        }
    }

    public static DiceParser parse(String formula){
        LinkedList<Operation> operations = new LinkedList<>();
        StringBuilder operandBuilder = new StringBuilder();
        char operator = '0';
        for(char c : formula.toCharArray()){
            if(c >= '0' && c <= '9'){
                operandBuilder.append(c);
            }
            else {
                if(operator != '0'){
                    operations.add(compileOperation(operandBuilder.toString(), operator));
                    operandBuilder = new StringBuilder();
                }
                operator = c;
                operandBuilder.append(c);
            }
        }
        operations.add(compileOperation(operandBuilder.toString(), operator));

        return new DiceParser(operations);
    }

    private static Operation compileOperation(String operand, char operator) {
        switch (operator) {
            case 'd' -> {
                String[] operands = operand.split("d");
                return new DiceOperation(Integer.parseInt(operands[0]), Integer.parseInt(operands[1]));
            }
            case '+' -> {
                return new AddOperation(Integer.parseInt(operand.substring(1)));
            }
            case '-' -> {
                return new SubtractOperation(Integer.parseInt(operand.substring(1)));
            }
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        }
    }

    private DiceParser(LinkedList<Operation> operations) {
        this.operations = operations;
    }

    public int calc() {
        int total = 0;
        for (Operation o : operations){
            total = o.calc(total);
        }
        return total;
    }

    private record AddOperation(int i) implements Operation {

        @Override
        public int calc(int currentValue) {
            return currentValue+i;
        }
    }
    private record SubtractOperation(int i) implements Operation {

        @Override
        public int calc(int currentValue) {
            return currentValue-i;
        }
    }
}
