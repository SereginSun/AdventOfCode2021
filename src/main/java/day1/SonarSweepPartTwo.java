package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SonarSweepPartTwo {
    public static void main(String[] args) throws IOException {
        InputStream is = SonarSweepPartTwo.class.getResourceAsStream("/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        List<Integer> numbers = new ArrayList<>();
        int count = 0;
        while ((line = br.readLine()) != null) {
            numbers.add(Integer.valueOf(line));
        }
        for (int i = 0; i < numbers.size() - 3; i++) {
            if (numbers.get(i) < numbers.get(i + 3)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
