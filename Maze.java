import java.util.ArrayList;
import java.util.Random;

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
        maze[0][0] = 'S';
        maze[rowCount - 1][colCount - 1] = 'E';
    }

    // constructor that randomizes the map given dimensions and number of obstacles
    public Maze (int rowCount, int colCount, int numObstacles){
        if (rowCount<=0 || colCount<=0) {
            throw new IllegalArgumentException ("Maze dimensions be a positive integer");
        }
        if (numObstacles >= rowCount * colCount - 2){
            throw new IllegalArgumentException("Number of obstacles cannot be greater than the grid");
        }
        this.rowCount = rowCount;
        this.colCount = colCount;
        start = new Point(0,0);
        end = new Point(rowCount-1, colCount-1);
        maze = new char[rowCount][colCount];
        maze[0][0] = 'S';
        maze[rowCount - 1][colCount - 1] = 'E';

        Random random = new Random();
        int currentObstacles = 0;
        while (currentObstacles < numObstacles){
            int randomRow = random.nextInt(rowCount);
            int randomCol = random.nextInt(colCount);
            if (!isObstacle(randomRow, randomCol) && !isStart(randomRow, randomCol) 
                && !isEnd(randomRow, randomCol)){
                setObstacles(randomRow, randomCol);
                currentObstacles++;
            } 
        } 

    }

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

    public boolean isStart(int row, int column){
        return maze[row][column] == 'S';
    }

    public boolean isEnd(int row, int column){
        return maze[row][column] == 'E';
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

