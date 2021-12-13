package day11;

import app.Reader;
import app.Solution;

import java.util.List;
import java.util.function.Consumer;

public class PartTwo implements Solution {
    private final Reader input;
    private final Consumer<String> output;

    public PartTwo(Reader input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void solution() {
        List<String> store = input.getList();
        Grid grid = new Grid();
        grid.init(store);
        int step = 0;
        int flash = 0;
        while (flash < grid.getAmountOctopus()) {
            step++;
            flash = grid.flashOctopus();
            grid.resetFlashedOctopus();
        }
        String result2 = String.format("All octopuses will flash after %d steps.%n", step);
        output.accept(result2);
    }
}
