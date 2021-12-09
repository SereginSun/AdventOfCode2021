package day8;

import app.Reader;
import app.Solution;

import java.util.Arrays;
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
        List<String> store = input.getList();
        int sum = 0;
        for (String str : store) {
            String[] parts = str.split(" \\| ");
            String[] firstPart = parts[0].split(" ");
            getSortArr(firstPart);
            String[] secondPart = parts[1].split(" ");
            getSortArr(secondPart);
            Map<Integer, String> combination = new HashMap<>();
            getUniqueCombinations(firstPart, combination);
            getCombinationWithLength5And6(firstPart, combination);
            int num = convertToNum(combination, secondPart);
            sum += num;
        }
        String result = String.format("If we add up all the output values, we get: %d.%n", sum);
        output.accept(result);

    }

    private void getSortArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            char[] toSort = arr[i].toCharArray();
            Arrays.sort(toSort);
            arr[i] = new String(toSort);
        }
    }

    private void getUniqueCombinations(String[] part, Map<Integer, String> combination) {
        for (String code : part) {
            switch (code.length()) {
                case 2:
                    combination.put(1, code);
                    break;
                case 3:
                    combination.put(7, code);
                    break;
                case 4:
                    combination.put(4, code);
                    break;
                case 7:
                    combination.put(8, code);
                    break;
            }
        }
    }

    private void getCombinationWithLength5And6(String[] part, Map<Integer, String> combination) {
        for (String code : part) {
            if (code.length() == 6) {
                if (isNum(combination.get(4), code)) {
                    combination.put(9, code);
                } else if (isNum(combination.get(1), code)) {
                    combination.put(0, code);
                } else {
                    combination.put(6, code);
                }
            }
        }
        for (String code : part) {
            if (code.length() == 5) {
                if (isNum(combination.get(1), code)) {
                    combination.put(3, code);
                } else if (isNum(code, combination.get(6))) {
                    combination.put(5, code);
                } else {
                    combination.put(2, code);
                }
            }
        }
    }

    private boolean isNum(String uniqueCode, String code) {
        boolean result = true;
        for (char ch : uniqueCode.toCharArray()) {
            if (!code.contains(String.valueOf(ch))) {
                result = false;
                break;
            }
        }
        return result;
    }

    private int convertToNum(Map<Integer, String> combinations, String[] secondPart) {
        int number = 0;
        for (String code : secondPart) {
            for (Map.Entry<Integer, String> entry : combinations.entrySet()) {
                if (entry.getValue().equals(code)) {
                    number = (number * 10) + entry.getKey();
                }
            }
        }
        return number;
    }
}
