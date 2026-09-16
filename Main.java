/**
 * This class contains unit tests that are updated to match the current state 
 * of my project.
 */
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main (String args[]){
        Maze grid = new Maze(3,3);
        grid.setObstacles(0,1);
        grid.setObstacles(1,1);

        BFS bfs = new BFS();
        Deque<Point> path = bfs.solveBFS(grid);

        System.out.print("path = ");
        //for each loop
        for (Point p:path) {
            System.out.print("(" + p.getRow() + "," + p.getCol() + "), ");       
        }
    }
}
