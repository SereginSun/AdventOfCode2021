package day10;

import app.Reader;
import app.Solution;

import java.util.*;
import java.util.function.Consumer;

public class PartTwo extends PartOne implements Solution {
    private final Reader input;
    private final Consumer<String> output;

    public PartTwo(Reader input, Consumer<String> output) {
        super(input, output);
        this.input = input;
        this.output = output;
    }

    @Override
    public void solution() {
        List<String> store = input.getList();
        Map<Character, Integer> points = new HashMap<>();
        points.put(')', 1);
        points.put(']', 2);
        points.put('}', 3);
        points.put('>', 4);
        List<Long> scores = new ArrayList<>();
        for (String line : store) {
            Stack<Character> stack = getStackWithoutLegalChunk(line);
            Character ch = findFirstInvalidCharacter(stack);
            if (ch != ' ') {
                continue;
            }
            char[] toCompleteStack = completeStack(stack);
            long score = 0;
            for (char c : toCompleteStack) {
                score *= 5;
                score += points.get(c);
            }
            scores.add(score);
        }
        scores.sort(Long::compareTo);

        int middle = (scores.size() / 2);
        Long middleScore = scores.get(middle);

        String result = String.format("Middle score is %d.%n", middleScore);
        output.accept(result);
    }

    private char[] completeStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Character pop = stack.pop();

            if (pop == '[') {
                sb.append("]");
            } else if (pop == '<') {
                sb.append(">");
            } else if (pop == '(') {
                sb.append(")");
            } else if (pop == '{') {
                sb.append("}");
            }
        }
        return sb.toString().toCharArray();
    }
}
