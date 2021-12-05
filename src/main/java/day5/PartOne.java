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
        List<Line> lines = new ArrayList<>();
        for (String stringLine : store) {
            String[] linePoints = stringLine.split(" -> ");
            String[] pointFirst = linePoints[0].split(",");
            Point first = new Point(Integer.parseInt(pointFirst[0]), Integer.parseInt(pointFirst[1]));
            String[] pointSecond = linePoints[1].split(",");
            Point second = new Point(Integer.parseInt(pointSecond[0]), Integer.parseInt(pointSecond[1]));
            Line line = new Line(first, second);
            lines.add(line);
        }

        Map<Point, Integer> points = new HashMap<>();
        for (Line line : lines) {
            Point pFirst = line.getStart();
            Point pSecond = line.getEnd();
            if (pFirst.getX() == pSecond.getX()) {
                for (int i = min(pFirst.getY(), pSecond.getY()); i <= max(pFirst.getY(), pSecond.getY()) ; i++) {
                    points.merge(new Point(pFirst.getX(), i), 1,Integer::sum);
                }
            }
            if (pFirst.getY() == pSecond.getY()) {
                for (int i = min(pFirst.getX(), pSecond.getX()); i <= max(pFirst.getX(), pSecond.getX()) ; i++) {
                    points.merge(new Point(i, pFirst.getY()), 1,Integer::sum);
                }
            }
        }
        int count = 0;
        for (int visits : points.values()) {
            if (visits > 1) {
                count++;
            }
        }
        String result = String.format("number of overlap points: %d", count);
        output.accept(result);
    }
}
