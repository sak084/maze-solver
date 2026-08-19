import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class BFS {
    private boolean found = false;
    private HashSet<Point>visited = new HashSet<>();
    // use hashset to track visited because it has fastest lookup runtime O(1)
    private Deque<Point>toVisit = new ArrayDeque<>();
    private Deque<Point>shortestPath = new ArrayDeque<>();

    public Deque<Point> solveBFS (Maze grid) {

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
    
        // check visited
        while (found == false && !toVisit.isEmpty()) {

            int startRowUp = startRow-1;
            int startRowDown = startRow+1;
            int startColLeft = startCol-1;
            int startColRight = startCol+1;

            // search order: up, down, left, right
            Point upNeighbor = new Point(startRowUp, startCol);
            if (0<=startRowUp && startRowUp<grid.getRowCount() && maze[startRowUp][startCol]!= 'X' 
                && !visited.contains(upNeighbor)) {
                if (maze[startRowUp][startCol] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(upNeighbor);
                visited.add(upNeighbor);
            }
            Point downNeighbor = new Point(startRowDown, startCol);
            if (0<=startRowDown && startRowDown<grid.getRowCount() && maze[startRowDown][startCol]!= 'X' 
                && !visited.contains(downNeighbor)) {
                if (maze[startRowDown][startCol] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(downNeighbor);
                visited.add(downNeighbor);
            }
            Point leftNeighbor = new Point(startRow, startColLeft);
            if (0<=startColLeft && startColLeft<grid.getColCount() && maze[startRow][startColLeft]!= 'X' 
                && !visited.contains(leftNeighbor)) {
                if (maze[startRow][startColLeft] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(leftNeighbor);
                visited.add(leftNeighbor);
            }
            Point rightNeighbor = new Point(startRow, startColRight);
            if (0<=startColRight && startColRight<grid.getColCount() && maze[startRow][startColRight]!= 'X' 
                && !visited.contains(rightNeighbor)) {
                if (maze[startRow][startColRight] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return shortestPath;
                }
                toVisit.offer(rightNeighbor);
                visited.add(rightNeighbor);
            }

            startPoint = toVisit.poll();
            visited.add(startPoint);
            startRow = startPoint.getRow();
            startCol = startPoint.getCol();
        }
        
        //to do
        return shortestPath;

    }
}
