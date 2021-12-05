package day5;

import app.Reader;
import app.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.lang.Math.*;

public class PartOne implements Solution {
    private final Reader input;
    private final Consumer<String> output;

    public PartOne(Reader input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }




    @Override
    public void solution() {
        List<String> store = new ArrayList<>(input.getList());

        for (String s : store) {
            output.accept(s);
        }

        output.accept("\n");

        Map<Point, Point> inputLines = new HashMap<>();
        for (String line : store) {
            String[] linePoints = line.split(" -> ");
            String[] pointFirst = linePoints[0].split(",");
            Point first = new Point(Integer.parseInt(pointFirst[0]), Integer.parseInt(pointFirst[1]));
            String[] pointSecond = linePoints[1].split(",");
            Point second = new Point(Integer.parseInt(pointSecond[0]), Integer.parseInt(pointSecond[1]));
            output.accept(String.valueOf(first));
            output.accept(String.valueOf(second));
//            inputLines.put(first, second);
            inputLines.put(new Point(pointFirst), new Point(pointSecond));
        }

        Map<Point, Integer> points = new HashMap<>();
        for (Map.Entry<Point, Point> line : inputLines.entrySet()) {
            Point pFirst = line.getKey();
            Point pSecond = line.getValue();
            if (pFirst.getY() == pSecond.getY()) {
                for (int i = min(pFirst.getX(), pSecond.getX()); i <= max(pFirst.getX(), pSecond.getX()); i++) {
                    points.merge(new Point(i, pFirst.getY()), 1, Integer::sum);
                }
            } else if (pFirst.getX() == pSecond.getX()) {
                for (int i = min(pFirst.getY(), pSecond.getY()); i <= max(pFirst.getY(), pSecond.getY()); i++) {
                    points.merge(new Point(pFirst.getX(), i), 1, Integer::sum);
                }
            }
        }
        int count = 0;
        for (int visits : points.values()) {
            if (visits > 1) {
                count++;
            }
        }
        output.accept("\n");
        String result = String.format("number of overlap points: %d", count);
        output.accept(result);
    }
}
