package edu.purdue.marsha88.cs180calc;

import java.util.Stack;


public class Calculator {

    private CalculatorViewInterface view;

    private String answer = "";
    private static boolean willDelete = true;
    private boolean afterEqual = false;
    Stack<String> stack;


    public Calculator(CalculatorViewInterface view) {
        stack = new Stack<>();
        this.view = view;
    }

    public boolean containsDeciamal(String s) {
        if (s.contains(".")) {
            return true;
        }
        return false;
    }

    public boolean canAddDigit(String s) {
        String[] theSplit = s.split("\\.");
        if (theSplit.length > 1) {
            if (theSplit[1].length() >= 2) {
                return false;
            }
        }
        return true;
    }


    public void inputDigit(char act) {

        String[] thesplit = answer.split(" ");



        if ( afterEqual && thesplit.length == 1) {
            answer = Character.toString(act);
            afterEqual= false;
            stack.push(answer);
            view.display(answer);
            return;
        }

        if (thesplit.length == 3 && !canAddDigit(thesplit[2])) {
            view.invalid();

            return;
        }
        if (thesplit.length == 1 && !canAddDigit(thesplit[0])) {
            view.invalid();

            return;
        }

        if (thesplit.length == 2) {
            answer += " " + Character.toString(act);
            view.display(answer);
            stack.push(answer);
            return;
        }


        answer += act;
        stack.push(answer);
        view.display(answer);

    }


    public void equal() {
        String[] theSplit = answer.split(" ");

        if (theSplit.length != 3) {
            view.invalid();

            return;
        }
        double d = 0;
        double first = Double.parseDouble(theSplit[0]);
        double second = Double.parseDouble(theSplit[2]);
        try {
            switch (theSplit[1]) {
                case "+":
                    d = first + second;
                    break;
                case "-":
                    d = first - second;
                    break;
                case "x":
                    d = first * second;
                    break;
                case "/":
                    d = first / second;
            }
            answer = String.format("%.2f", d);
            view.display(answer);
            afterEqual = true;
            stack.push(answer);
        } catch (ArithmeticException e) {
            if (theSplit[0].equals("0")) {
                view.display("NaN");
                stack.push("NaN");
            }
            if (first < 0) {
                view.display("-Infinity");
                stack.push("-Infinity");
            }
            if (first > 0) {
                view.display("Infinity");
                stack.push("Infinity");
            }
            afterEqual = true;
        }
    }

    public void dot() {

        if (answer.length() < 1) {
            view.invalid();
            return;
        }
        if (answer.equals("")) {
            view.invalid();

            return;
        }
        if (answer.equals("Infinity") || answer.equals("-Infinity") || answer.equals("NaN")) {
            view.invalid();

            return;
        }

        String[] theSplit = answer.split(" ");

        if (theSplit.length == 1 && containsDeciamal(theSplit[0])) {
            view.invalid();

            return;
        }
        if (theSplit.length == 2) {
            view.invalid();

            return;
        }

        if (theSplit.length == 3 && containsDeciamal(theSplit[2])) {
            view.invalid();

            return;
        }

        answer += ".";
        view.display(answer);
        stack.push(answer);
    }


    public void operator(char op) {

        String[] theSplit = answer.split(" ");
        if(answer.length() == 0){
            view.invalid();

            return;
        }
        if (theSplit.length == 2) {
            answer = answer.replace(theSplit[1], Character.toString(op));
            view.display(answer);
            return;
        }
        if (theSplit.length == 3) {
            view.invalid();

            return;
        }
        if (answer.equals("Infinity") || answer.equals("-Infinity") || answer.equals("NaN")) {
            view.invalid();

            return;
        }

        answer += " " + op;
        view.display(answer);
        stack.push(answer);

    }

    public void delete() {
        String[] theSplit = answer.split(" ");
        if (stack.isEmpty()) {
            answer = "";
            view.display(answer);
            return;
        }

        if (afterEqual) {
            if (!willDelete) {
                view.invalid();

                return;
            }
            if (theSplit.length == 1) {
                willDelete = false;

            }
        }

        stack.pop();
        if(!stack.isEmpty()) {
            answer = stack.peek();
        }
        else{
            answer = "";
        }
        willDelete = true;
        view.display(answer);

    }
    public void clear(){
        stack.clear();
        answer = "";
        view.display(answer);
    }
}
