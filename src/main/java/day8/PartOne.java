package day8;

import app.Reader;
import app.Solution;

import java.util.List;
import java.util.function.Consumer;

public class PartOne implements Solution {
    private final Reader input;
    private final Consumer<String> output;

    public PartOne(Reader input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void solution() {
        List<String> store = input.getList();
        int count = 0;
        for (String str : store) {
            String[] parts = str.split("\\|");
            String[] secondPart = parts[1].split(" ");
            for (String segments : secondPart) {
                if (segments.length() == 2 || segments.length() == 3 || segments.length() == 4 || segments.length() == 7) {
                    count++;
                }
            }
        }
        String result = String.format("Digits 1, 4, 7, or 8 appear %d times in output values.%n", count);
        output.accept(result);
    }
}
