package day9;

import app.Reader;
import app.Solution;

import java.util.ArrayList;
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
        int[][] map = initHeightMap(input.getList());
        int sum = 0;
        for (Point p : getListLows(map)) {
            int num = map[p.row][p.col];
            sum += num + 1;
        }
        String result = String.format("The sum of the risk levels of all the low points on our heightmap is %d.%n", sum);
        output.accept(result);
    }

    public int[][] initHeightMap(List<String> input) {
        int[][] map = new int[input.size()][input.get(0).length()];

        for(int row = 0; row < map.length; row++) {
            String line = input.get(row);
            for(int col = 0; col < map[row].length; col++)
                map[row][col] = Integer.parseInt(line.substring(col, col + 1));
        }
        return map;
    }

    public List<Point> getListLows(int[][] map) {
        List<Point> lowPoints = new ArrayList<>();
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[row].length; col++)
            {
                int curr = map[row][col];
                if(row - 1 >= 0 && curr >= map[row - 1][col])
                    continue;
                if(row + 1 < map.length && curr >= map[row + 1][col])
                    continue;
                if(col - 1 >= 0 && curr >= map[row][col - 1])
                    continue;
                if(col + 1 < map[row].length && curr >= map[row][col + 1])
                    continue;

                lowPoints.add(new Point(row, col));
            }
        }
        return lowPoints;
    }

    public Reader getInput() {
        return input;
    }

    public Consumer<String> getOutput() {
        return output;
    }
}
