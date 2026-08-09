import java.util.ArrayList;

public class Maze {
    char[][] maze;
    Point start; //default start = first box
    Point end; //default end = last box given the size of 2d array
    ArrayList <Point> obstacles = new ArrayList<>();
    int rowCount;
    int colCount;

    public Maze (int rowCount, int colCount) {
        if (rowCount<=0 || colCount<=0) {
            throw new IllegalArgumentException ("Maze dimensions be a positive integer");
        }
        this.rowCount = rowCount;
        this.colCount = colCount;
        start = new Point(0,0);
        end = new Point(rowCount-1, colCount-1);
        maze = new char[rowCount][colCount];
    }

    // add another constructor to randomize the map 

    //getter methods
    public char[][] getMaze() {
        return maze;
    }

    public Point getStart(){
        return start;
    }

    public Point getEnd(){
        return end;
    }

    public boolean isObstacle(int row, int column){
        return maze[row][column] == 'X';
    }

    public int getRowCount(){
        return rowCount;
    }
    
    public int getColCount(){
        return colCount;
    }
    //setter methods 
    public void setObstacles(int row, int column) { 
        if (row<0 || column<0 || row>rowCount-1 || column>colCount-1) {
            throw new IllegalArgumentException ("Obstacle indices must be within bounds");
        }
        maze[row][column] = 'X';
        obstacles.add(new Point(row, column));
    }

    public void setStart(int row, int column) {
        if (row<0 || column<0 || row>rowCount-1 || column>colCount-1) {
            throw new IllegalArgumentException ("Start indices must be within bounds");
        }
        maze[row][column] = 'S';
        start = new Point(row, column);
    }

    public void setEnd(int row, int column) {
        if (row<0 || column<0 || row>rowCount-1 || column>colCount-1) {
            throw new IllegalArgumentException ("End indices must be within bounds");
        }
        maze[row][column] = 'E';
        end = new Point(row, column);
    }
}
