package day13;

import java.util.ArrayList;
import java.util.List;

public class Paper {
    private char[][] map;
    private final List<Point> dots = new ArrayList<>();

    public void init(List<String> input) {
        for (String line : input) {
            String[] coordinates = line.split(",");
            Point point = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
            dots.add(point);
        }
    }

    public void buildMap() {
        int maxCol = -1;
        int maxRow = -1;

        for (Point p : dots) {
            if (p.getCol() > maxRow)
                maxRow = p.getCol();
            if (p.getRow() > maxCol)
                maxCol = p.getRow();
        }
        map = new char[++maxCol][++maxRow];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = '.';
            }
        }

        for (Point point : dots) {
            map[point.getRow()][point.getCol()] = '#';
        }
    }

    public void printMap() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public void fold(String foldData) {
        String[] elements = foldData.split("=");
        int foldCoordinate = Integer.parseInt(elements[1]);
        for (int i = dots.size() - 1; i >= 0; i--) {
            Point point = dots.get(i);
            if (elements[0].equals("x")) {
                if (point.getCol() > foldCoordinate) {
                    int newX = foldCoordinate - (point.getCol() - foldCoordinate);
                    if (dots.contains(new Point(newX, point.getRow()))) {
                        dots.remove(i);
                    } else {
                        point.setCol(newX);
                    }
                }
            } else {
                if (point.getRow() > foldCoordinate) {
                    int newY = foldCoordinate - (point.getRow() - foldCoordinate);
                    if (dots.contains(new Point(point.getCol(), newY))) {
                        dots.remove(i);
                    } else {
                        point.setRow(newY);
                    }
                }
            }
        }
    }

    public int getDotsNumber() {
        return dots.size();
    }
}
