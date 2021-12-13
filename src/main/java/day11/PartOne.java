package day11;

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
        Grid grid = new Grid();
        grid.init(store);
        int flash = 0;
        for (int step = 0; step < 100; step++) {
            flash += grid.flashOctopus();
            grid.resetFlashedOctopus();
        }
        String result1 = String.format("After 100 steps, there will be %d flashes.%n", flash);
        output.accept(result1);
    }
}
