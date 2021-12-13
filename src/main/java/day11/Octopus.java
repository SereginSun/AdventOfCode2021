package day11;

import java.util.Objects;

public class Octopus {
    private final int row;
    private final int col;

    public Octopus(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Octopus octopus = (Octopus) o;
        return row == octopus.row && col == octopus.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
