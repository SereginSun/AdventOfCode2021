package day2;

import day1.SonarSweep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DivePartTwo {
    private int horizontal;
    private int depth;
    private int aim;

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public static void main(String[] args) throws IOException {
        InputStream is = SonarSweep.class.getResourceAsStream("/inputDive.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        DivePartTwo dive = new DivePartTwo();
        while ((line = br.readLine()) != null) {
            String[] store = line.split(" ");
            int value = Integer.parseInt(store[1]);
            switch (store[0]) {
                case("forward"):
                    int horiz = dive.getHorizontal() + value;
                    int dep = dive.getDepth() + dive.getAim() * value;
                    dive.setHorizontal(horiz);
                    dive.setDepth(dep);
                    break;
                case("down"):
                    int aim = dive.getAim() + value;
                    dive.setAim(aim);
                    break;
                case("up"):
                    dive.setAim(dive.getAim() - value);
                    break;
            }
        }
        System.out.printf("horizontal: %d%n", dive.getHorizontal());
        System.out.printf("depth: %d%n", dive.getDepth());
        System.out.printf("Multiplication: %d%n", dive.getHorizontal() * dive.getDepth());
    }
}
