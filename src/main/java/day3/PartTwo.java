package day3;

import app.Reader;
import app.Solution;

import java.math.BigInteger;
import java.util.ArrayList;
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
        List<String> store = new ArrayList<>(input.getList());
        String oxygenGenerator = getRating(store, '1');
        int oxygenRating = new BigInteger(oxygenGenerator, 2).intValue();
        String CO2Scrubber = getRating(store, '0');
        int CO2Rating = new BigInteger(CO2Scrubber, 2).intValue();
        int lifeSupportRating = oxygenRating * CO2Rating;
        output.accept(String.valueOf(lifeSupportRating));
    }

    private String getRating(List<String> input, char criteria) {
        List<String> result = new ArrayList<>(input);
        for (int i = 0; i < result.get(0).length(); i++) {
            if (result.size() == 1) {
                break;
            }
            int count = 0;
            for (String s : result) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            int middle = (result.size() + 1) / 2;
            char most = getChar(criteria, count, middle);
            int index = i;
            result.removeIf(num -> num.charAt(index) == most);
        }
        return result.get(0);
    }

    private char getChar(char criteria, int count, int middle) {
        if (criteria == '1') {
            return (count >= middle) ? '0' : '1';
        } else {
            return (count < middle) ? '0' : '1';
        }
    }
}
