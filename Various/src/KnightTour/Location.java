package KnightTour;

public class Location {
    private int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String toString() {
        return "(" + row + "," + col + ")";
    }

    public boolean equals(Location one, Location two) {
        return (one.getRow() == two.getRow() && one.getCol() == two.getCol()); //direct access? default equals??
    }
}