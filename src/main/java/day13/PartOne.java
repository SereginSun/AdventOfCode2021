package day13;

import app.Reader;
import app.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PartOne implements Solution {
    private final Reader input;
    private final Consumer<String> output;
    protected List<String> dotsData = new ArrayList<>();
    protected List<String> foldsData = new ArrayList<>();

    public PartOne(Reader input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void solution() {
        readInput();
        Paper transparent = new Paper();
        transparent.init(dotsData);
        transparent.fold(foldsData.get(0));
        String result = String.format("After the first fold, %d points will be visible.%n", transparent.getDotsNumber());
        output.accept(result);
    }

    protected void readInput() {
        boolean loadingDots = true;
        for (String line : input.getList()) {
            if (line.isEmpty()) {
                loadingDots = false;
                continue;
            }
            if (loadingDots) {
                dotsData.add(line);
            } else {
                foldsData.add(line.replace("fold along ", ""));
            }
        }
    }
}
