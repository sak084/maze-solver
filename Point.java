public class Point {
    private int row;
    private int col;
    
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //getter methods
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Point) {
            Point p = (Point)o;
            return this.row == p.row && this.col == p.col;
        }
        else {
            return false;
        }
    }
}
