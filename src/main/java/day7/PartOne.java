package day7;

import app.Part;
import app.Reader;
import app.Solution;

import java.util.List;
import java.util.function.Consumer;

import static java.lang.Math.abs;

public class PartOne extends Part implements Solution {

    public PartOne(Reader input, Consumer<String> output) {
        super(input, output);
    }

    @Override
    public void solution() {
        List<Integer> crabPosition = super.getListCrabPositions(super.getInput());
        int min = crabPosition.stream()
                .min(Integer::compareTo)
                .get();
        int max = crabPosition.stream()
                .max(Integer::compareTo)
                .get();

        long lowerCost = Integer.MAX_VALUE;

        for (int i = min; i <= max; i++) {
            long cost = getCostToPost(crabPosition, i);
            if (cost < lowerCost) {
                lowerCost = cost;
            }
        }

        getOutput().accept(String.valueOf(lowerCost));
    }

    public Long getCostToPost(List<Integer> positions, int toPosition) {
        long cost = 0;
        for (int num : positions) {
            cost += abs(num - toPosition);
        }
        return cost;
    }
}
