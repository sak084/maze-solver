import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class BFS {
    private boolean found = false;
    private HashSet<Point>visited = new HashSet<>();
    // hashset because it has fastest lookup runtime O(1)
    private Deque<Point>toVisit = new ArrayDeque<>();
    // deque because order matters + faster runtime
    private HashMap<Point, Point>parent = new HashMap<>();
    // hashmap because we need key:value relationship between parent + child
    private Deque<Point>shortestPath = new ArrayDeque<>();
    // deque because order matters + faster runtime

    // a shortcoming is that solveBFS must always be called before
    // returnShortestPath

    Point endPoint;
    Point originalStart;

    public boolean solveBFS (Maze grid) {
        //getting the location of start and end + respective data fields
        Point startPoint = grid.getStart();
        int startRow = startPoint.getRow();
        int startCol = startPoint.getCol();

        char[][] maze = grid.getMaze();
        char start = maze[startRow][startCol];
        toVisit.offer(new Point(startRow, startCol));
        visited.add(new Point(startRow, startCol));
        shortestPath.offer(new Point(startRow, startCol));
    
        endPoint = grid.getEnd();
        int endRow = endPoint.getRow();
        int endCol = endPoint.getCol();

        // save original start for the reverse traversal to find the path
        originalStart = new Point(startRow, startCol);

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
                visited.add(upNeighbor);
                parent.put(upNeighbor, startPoint);
                if (maze[startRowUp][startCol] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return found;
                }
                toVisit.offer(upNeighbor);
            }
            Point downNeighbor = new Point(startRowDown, startCol);
            if (0<=startRowDown && startRowDown<grid.getRowCount() && maze[startRowDown][startCol]!= 'X' 
                && !visited.contains(downNeighbor)) {
                visited.add(downNeighbor);
                parent.put(downNeighbor, startPoint);
                if (maze[startRowDown][startCol] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return found;
                }
                toVisit.offer(downNeighbor);
            }
            Point leftNeighbor = new Point(startRow, startColLeft);
            if (0<=startColLeft && startColLeft<grid.getColCount() && maze[startRow][startColLeft]!= 'X' 
                && !visited.contains(leftNeighbor)) {
                visited.add(leftNeighbor);
                parent.put(leftNeighbor, startPoint);
                if (maze[startRow][startColLeft] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return found;
                }
                toVisit.offer(leftNeighbor);
            }
            Point rightNeighbor = new Point(startRow, startColRight);
            if (0<=startColRight && startColRight<grid.getColCount() && maze[startRow][startColRight]!= 'X' 
                && !visited.contains(rightNeighbor)) {
                visited.add(rightNeighbor);
                parent.put(rightNeighbor, startPoint);
                if (maze[startRow][startColRight] == 'E') {
                    System.out.println("end point found successfully");
                    found = true;
                    return found;
                }
                toVisit.offer(rightNeighbor);
            }
            startPoint = toVisit.poll();
            startRow = startPoint.getRow();
            startCol = startPoint.getCol();
        }
        return found;
    }

    public Deque<Point> returnShortestPath(HashMap<Point, Point> parent){
        if (found) {
            shortestPath.push(endPoint);
            Point shortestPathStart = endPoint;
            while (!shortestPathStart.equals(originalStart)) {
                Point parentPoint = parent.get(shortestPathStart);
                shortestPath.push(parentPoint);
                shortestPathStart = parentPoint;
            }
            return shortestPath;
        } else {
            System.out.println("Cannot Find Valid Path");
            return shortestPath;
        }
    }
}
