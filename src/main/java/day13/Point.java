package day13;

import java.util.Objects;

public class Point {
    private int col;
    private int row;

    public Point(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return col == point.col && row == point.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
}
