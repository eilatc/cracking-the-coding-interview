package recursivedp;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits"
 * such that the robot cannot step on them. Design an algorithm to find a path for the robot
 * from the top left to the bottom right.
 */
class _08_02_RobotInAGrid {
    List<Point> findPath(boolean[][] grid) {
      List<Point> path = new ArrayList<>();
      if (grid == null) return path;
        HashSet<Point> failedPoints = new HashSet<>();

        System.out.println("Without Dynamic");
        findPathHelper(grid.length - 1 , grid[0].length - 1, grid, path);
        System.out.println();
        System.out.println("With Dynamic");
        path.clear();
      if (findPathHelperDynamic(grid.length - 1 , grid[0].length - 1, grid, path, failedPoints)){
          return path;
      }
      path.clear();
    return path;
    }

    boolean findPathHelperDynamic(int x, int y, boolean[][] grid, List<Point> path, HashSet<Point> failedPoints) {

        if (x < 0 || y < 0 || !grid[x][y]) return false;

        boolean isStartPoint = (x==0) && (y==0);

        Point p = new Point(x,y);

        if (failedPoints.contains(p)) {
            return false;
        }
        // Print this to compare with simple recursive
         System.out.println("X: " + x + " Y: " + y);
        if (isStartPoint
                || findPathHelperDynamic(x - 1, y, grid, path, failedPoints)
                || findPathHelperDynamic(x, y - 1, grid, path, failedPoints)
            ) {

            if (grid[x][y]) {
                path.add(p);
                return true;
            }
        }
        // Print all the points with dead end from both ways.
        failedPoints.add(p);
        return false;
    }

    boolean findPathHelper(int x, int y, boolean[][] grid, List<Point> path) {
        if (x < 0 || y < 0 || !grid[x][y]) return false;

        boolean isStartPoint = (x==0) && (y==0);

        Point p = new Point(x,y);

        // Print this to compare with simple recursive
         System.out.println("X: " + x + " Y: " + y);
        if (isStartPoint
                || findPathHelper(x - 1, y, grid, path)
                || findPathHelper(x, y - 1, grid, path)
        ) {

            if (grid[x][y]) {
                path.add(p);
                return true;
            }
        }
        return false;
    }

}
