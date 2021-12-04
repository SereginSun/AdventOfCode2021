package day3;

import app.Reader;
import app.Solution;

import java.math.BigInteger;
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
        List<String> store;
        store = input.getList();
        int[] onesCount = new int[12];
        int[] zeroesCount = new int[12];
        for (String line : store) {
            String[] lineArr = line.split("");

            for (int i = 0; i < lineArr.length; i++) {
                if (lineArr[i].equals("1")) {
                    onesCount[i]++;
                } else {
                    zeroesCount[i]++;
                }
            }
        }
        StringBuilder most = new StringBuilder();
        StringBuilder least = new StringBuilder();

        for (int i = 0; i < onesCount.length; i++) {
            if (onesCount[i] > zeroesCount[i]) {
                most.append("1");
                least.append("0");
            } else {
                most.append("0");
                least.append("1");
            }
        }

        BigInteger mostNumber = new BigInteger(most.toString(), 2);
        BigInteger leastNumber = new BigInteger(least.toString(), 2);
        int result = mostNumber.intValue() * leastNumber.intValue();
        output.accept(String.valueOf(result));
    }
}
