package day2;

import day1.SonarSweep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Dive {
    private int horizontal;
    private int depth;

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

    public static void main(String[] args) throws IOException {
        InputStream is = SonarSweep.class.getResourceAsStream("/inputDive.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        Dive dive = new Dive();
        while ((line = br.readLine()) != null) {
            String[] store = line.split(" ");
            int result;
            switch (store[0]) {
                case("forward"):
                    result = dive.getHorizontal() + Integer.parseInt(store[1]);
                    dive.setHorizontal(result);
                    break;
                case("down"):
                    result = dive.getDepth() + Integer.parseInt(store[1]);
                    dive.setDepth(result);
                    break;
                case("up"):
                    result = dive.getDepth() - Integer.parseInt(store[1]);
                    dive.setDepth(result);
                    break;
            }
        }
        System.out.printf("horizontal: %d%n", dive.getHorizontal());
        System.out.printf("depth: %d%n", dive.getDepth());
        System.out.printf("Multiplication: %d%n", dive.getHorizontal() * dive.getDepth());
    }
}
