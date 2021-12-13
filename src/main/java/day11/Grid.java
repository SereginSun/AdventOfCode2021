package day11;

import java.util.*;

public class Grid {
    private final int[][] map;

    public Grid() {
        this.map = new int[10][10];
    }

    public void init(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            for (int j = 0; j < line.length(); j++) {
                int energy = Integer.parseInt(line.substring(j, j + 1));
                map[i][j] = energy;
            }
        }
    }

    public int flashOctopus() {
        int flash = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Stack<Octopus> toFlash = new Stack<>();
                toFlash.push(new Octopus(i, j));
                while (!toFlash.isEmpty()) {
                    Octopus dumbo = toFlash.pop();
                    map[dumbo.getRow()][dumbo.getCol()] += 1;
                    if (map[dumbo.getRow()][dumbo.getCol()] == 10) {
                        flash++;
                        addAllNeighboringOctopuses(map, toFlash, dumbo);
                    }
                }
            }
        }
        return flash;
    }

    public void addAllNeighboringOctopuses(int[][] map, Stack<Octopus> toFlash, Octopus dumbo) {
        if (dumbo.getRow() - 1 >= 0) {
            toFlash.add(new Octopus(dumbo.getRow() - 1, dumbo.getCol()));
        }
        if (dumbo.getRow() - 1 >= 0 && dumbo.getCol() + 1 < map[dumbo.getCol()].length) {
            toFlash.add(new Octopus(dumbo.getRow() - 1, dumbo.getCol() + 1));
        }
        if (dumbo.getCol() + 1 < map[dumbo.getRow()].length) {
            toFlash.add(new Octopus(dumbo.getRow(), dumbo.getCol() + 1));
        }
        if (dumbo.getRow() + 1 < map.length && dumbo.getCol() + 1 < map[dumbo.getRow()].length) {
            toFlash.add(new Octopus(dumbo.getRow() + 1, dumbo.getCol() + 1));
        }
        if (dumbo.getRow() + 1 < map.length) {
            toFlash.add(new Octopus(dumbo.getRow() + 1, dumbo.getCol()));
        }
        if (dumbo.getRow() + 1 < map.length && dumbo.getCol() - 1 >= 0) {
            toFlash.add(new Octopus(dumbo.getRow() + 1, dumbo.getCol() - 1));
        }
        if (dumbo.getCol() - 1 >= 0) {
            toFlash.add(new Octopus(dumbo.getRow(), dumbo.getCol() - 1));
        }
        if (dumbo.getRow() - 1 >= 0 && dumbo.getCol() - 1 >= 0) {
            toFlash.add(new Octopus(dumbo.getRow() - 1, dumbo.getCol() - 1));
        }
    }

    public void resetFlashedOctopus() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > 9) {
                    map[i][j] = 0;
                }
            }
        }
    }

    public int getAmountOctopus() {
        return map.length * map[0].length;
    }
}
