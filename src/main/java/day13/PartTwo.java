package day13;

import app.Reader;
import app.Solution;

import java.util.function.Consumer;

public class PartTwo extends PartOne implements Solution {
    public PartTwo(Reader input, Consumer<String> output) {
        super(input, output);
    }

    @Override
    public void solution() {
        readInput();
        Paper transparent = new Paper();
        transparent.init(dotsData);
        for (String foldCoordinate : foldsData) {
            transparent.fold(foldCoordinate);
        }
        transparent.buildMap();
        transparent.printMap();
    }
}
