package maze;

import java.util.Objects;

public class Vertex {
    private int row = 0;
    private int col = 0;

    public Vertex() {
    }

    public Vertex(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return row == vertex.row &&
                col == vertex.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
