package day7;

import app.Reader;

import java.util.List;
import java.util.function.Consumer;

import static java.lang.Math.abs;

public class PartTwo extends PartOne {

    public PartTwo(Reader input, Consumer<String> output) {
        super(input, output);
    }

    @Override
    public Long getCostToPost(List<Integer> positions, int toPosition) {
        long cost = 0;
        for (int num : positions) {
            long distance = abs(num - toPosition);
            cost += (distance * (distance + 1)) / 2L;
        }
        return cost;
    }
}
