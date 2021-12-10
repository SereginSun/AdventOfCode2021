package day9;

import app.Reader;
import app.Solution;

import java.util.*;
import java.util.function.Consumer;

public class PartTwo extends PartOne implements Solution {
    private final Reader input;
    private final Consumer<String> output;

    public PartTwo(Reader input, Consumer<String> output) {
        super(input, output);
        this.input = getInput();
        this.output = getOutput();
    }

    @Override
    public void solution() {
        int[][] map = initHeightMap(input.getList());
        List<Long> largest = new ArrayList<>();
        for (Point point : getListLows(map)) {
            Set<Point> visited = new HashSet<>();
            Queue<Point> toVisit = new LinkedList<>();
            toVisit.add(point);
            while (toVisit.size() > 0) {
                Point current = toVisit.poll();
                if (visited.contains(current)) {
                    continue;
                }
                visited.add(current);
                int row = current.row;
                int col = current.col;
                if(row - 1 >= 0 && map[row - 1][col] != 9) {
                    Point down = new Point(row - 1, col);
                    if(!visited.contains(down))
                        toVisit.add(down);
                }
                if(row + 1 < map.length && map[row + 1][col] != 9) {
                    Point up = new Point(row + 1, col);
                    if(!visited.contains(up))
                        toVisit.add(up);
                }
                if(col - 1 >= 0 && map[row][col - 1] != 9) {
                    Point left = new Point(row, col - 1);
                    if(!visited.contains(left))
                        toVisit.add(left);
                }
                if(col + 1 < map[row].length && map[row][col + 1] != 9) {
                    Point right = new Point(row, col + 1);
                    if(!visited.contains(right))
                        toVisit.add(right);
                }
            }
            largest.add((long) visited.size());
            largest.sort(Long::compareTo);
            largest.sort(Collections.reverseOrder());
        }
        long multi = largest.get(0) * largest.get(1) * largest.get(2);
        String result = String.format("Result is: %d.%n", multi);
        output.accept(result);
    }
}
