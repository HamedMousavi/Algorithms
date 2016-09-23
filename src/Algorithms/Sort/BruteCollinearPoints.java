// package Algorithms.Sort;


import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints
{

    private ArrayList<LineSegment> pairs;

    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null || arrayHasNull(points)) throw new java.lang.NullPointerException();
        if (hasDuplicate(points)) throw new java.lang.IllegalArgumentException();

        pairs = new ArrayList<>();

        double slope;
        Point[] col = new Point[4];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                slope = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    if (slope == points[j].slopeTo(points[k])) {
                        // If i, j, and k are on the same line
                        // then iterate to find the forth segment
                        for (int l = k + 1; l < points.length; l++) {
                            if (slope == points[k].slopeTo(points[l])) {
                                col[0] = points[i];
                                col[1] = points[j];
                                col[2] = points[k];
                                col[3] = points[l];
                                Arrays.sort(col);

                                pairs.add(new LineSegment(col[0], col[3]));
                            }
                        }
                    }
                }
            }
        }
    }


    private boolean hasDuplicate(Point[] points) {
        for (int i = 1; i < points.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (points[i].compareTo(points[j]) == 0) return true;
            }
        }

        return false;
    }


    private boolean arrayHasNull(Point[] points)
    {
        for (Point point : points) {
            if (point == null) return true;
        }

        return false;
    }


    public int numberOfSegments()        // the number of line segments
    {
        return pairs.size();
    }

    public LineSegment[] segments()                // the line segments
    {
        return pairs.isEmpty() ? new LineSegment[0] : pairs.toArray(new LineSegment[pairs.size()]);
    }
}
