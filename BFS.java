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
        toVisit.offer(new Point(startRow, startCol));
    
        // todo: check visited
        while (found == false && !toVisit.isEmpty()) {
            int startRowUp = startRow-1;
            int startRowDown = startRow+1;
            int startColLeft = startCol-1;
            int startColRight = startCol+1;

            // search order: up, down, left, right
            if (0<=startRowUp && startRowUp<grid.getRowCount() && maze[startRowUp][startCol]!= 'X') {
                if (maze[startRowUp][startCol] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(new Point(startRowUp, startCol));
            }
            if (0<=startRowDown && startRowDown<grid.getRowCount() && maze[startRowDown][startCol]!= 'X') {
                if (maze[startRowDown][startCol] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(new Point(startRowDown, startCol));
            }
            if (0<=startColLeft && startColLeft<grid.getColCount() && maze[startRow][startColLeft]!= 'X') {
                if (maze[startRow][startColLeft] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(new Point (startRow, startColLeft));
            }
            if (0<=startColRight && startColRight<grid.getColCount() && maze[startRow][startColRight]!= 'X') {
                if (maze[startRow][startColRight] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(new Point (startRow, startColRight));
            }

            startPoint = toVisit.poll();
            visited.offer(startPoint);
            startRow = startPoint.getRow();
            startCol = startPoint.getCol();
        }
        
        //to do
        return shortestPath;

    }
}
