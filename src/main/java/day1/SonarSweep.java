package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SonarSweep {
    public static void main(String[] args) throws IOException {

        InputStream is = SonarSweep.class.getResourceAsStream("/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        int first = 0;
        int second;
        int count = 0;
        while ((line = br.readLine()) != null) {
            second = Integer.parseInt(line);
            if (first == 0) {
                System.out.print(line + " ");
                System.out.println("(N/A - no previous measurement)");
            }
            if (second > first && first != 0) {
                System.out.print(line + " ");
                System.out.println("(increased)");
                count++;
            } else if (first > second) {
                System.out.print(line + " ");
                System.out.println("(decreased)");
            }
            first = second;
        }
        System.out.println(count);
    }
}
