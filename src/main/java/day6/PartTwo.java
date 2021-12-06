package day6;

import app.Reader;
import app.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<String> store = new ArrayList<>(input.getList());

        Map<Integer, Long> fishMap = new HashMap<>();

        String[] ageArr = store.get(0).split(",");
        for (String s : ageArr) {
            int age = Integer.parseInt(s);
            long value = fishMap.getOrDefault(age, 0L) + 1L;
            fishMap.put(age, value);
        }

        int afterDays = 256;

        reproduction(fishMap, afterDays);

        long sum = 0;
        for (Long count : fishMap.values()) {
            sum += count;
        }
        output.accept(String.valueOf(sum));
    }

    private void reproduction(Map<Integer, Long> fishMap, int days) {
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < 9; j++) {
                fishMap.put(j-1, fishMap.getOrDefault(j, 0L));
            }
            fishMap.put(6, fishMap.getOrDefault(6, 0L) + fishMap.get(-1));
            fishMap.put(8, fishMap.remove(-1));
        }
    }
}
