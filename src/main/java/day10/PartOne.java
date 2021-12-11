package day10;

import app.Reader;
import app.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;

public class PartOne implements Solution {
    protected final Reader input;
    protected final Consumer<String> output;

    public PartOne(Reader input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void solution() {
        List<String> store = input.getList();

        int sum = 0;

        Map<Character, Integer> points = new HashMap<>();
        points.put(')', 3);
        points.put(']', 57);
        points.put('}', 1197);
        points.put('>', 25137);

        for (String line : store) {
            Stack<Character> stack = getStackWithoutLegalChunk(line);
            Character ch = findFirstInvalidCharacter(stack);
            if (ch == ' ') {
                continue;
            }
            sum += points.get(ch);

        }
        String result = String.format("General evaluation of syntax errors is %d.%n", sum);
        output.accept(result);
    }

    Stack<Character> getStackWithoutLegalChunk(String line) {
        Stack<Character> stack = new Stack<>();
        String[] symbolArr = line.split("");
        for (String chunk : symbolArr) {
            if (stack.isEmpty()) {
                stack.add(' ');
            }
            Character top = stack.peek();
            char current = chunk.charAt(0);
            if ((top == '(' && current == ')')
                    || (top == '[' && current == ']')
                    || (top == '<' && current == '>')
                    || (top == '{' && current == '}')) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        return stack;
    }

    Character findFirstInvalidCharacter(Stack<Character> stack) {
        Stack<Character> copyOfStack = (Stack<Character>) stack.clone();
        char invalid = ' ';
        while (!copyOfStack.isEmpty()) {
            Character pop = copyOfStack.pop();
            switch (pop) {
                case ')':
                    invalid = ')';
                    break;
                case ']':
                    invalid = ']';
                    break;
                case '>':
                    invalid = '>';
                    break;
                case '}':
                    invalid = '}';
                    break;
            }
        }
        return invalid;
    }
}
