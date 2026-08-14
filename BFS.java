import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    private boolean found = false;
    private Queue<Point>visited = new ArrayDeque<>();
    private Queue<Point>toVisit = new ArrayDeque<>();
    private Queue<Point>shortestPath = new ArrayDeque<>();

    public Queue<Point> solveBFS (Maze grid) {

        //getting the location of start and end + respective data fields
        Point startPoint = grid.getStart();
        int startRow = startPoint.getRow();
        int startCol = startPoint.getCol();

        Point endPoint = grid.getEnd();
        int endRow = endPoint.getRow();
        int endCol = endPoint.getCol();

        char[][] maze = grid.getMaze();
        char start = maze[startRow][startCol];

        
        // search order: up, down, left, right
        return shortestPath;

    }
}
