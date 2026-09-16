/**
 * This class contains the code for one Point object, and methods for 
 * initializing the row/column instance variables and checking if two Points
 * are equal.
 */
import java.util.Objects;

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

    // need this method because Point is a custom class & we are using it as a key in a HashMap/ in a HashSet
    @Override
    public int hashCode(){
        return Objects.hash(row, col);
    }
}
