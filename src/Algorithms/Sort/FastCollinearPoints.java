package Algorithms.Sort;

import java.util.ArrayList;
import java.util.Arrays;


public class FastCollinearPoints {

    private ArrayList<LineSegment> pairs;

    public FastCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null || arrayHasNull(points)) throw new java.lang.NullPointerException();
        if (hasDuplicate(points)) throw new java.lang.IllegalArgumentException();

        pairs = new ArrayList<>();
        int segments;

        for (int i = 0; i < points.length; i++) {
            Arrays.sort(points, points[i].slopeOrder());
            for (int j = 0; j < points.length; j++) {
                segments = 1;
                double slope = points[i].slopeTo(points[j]);
                while (i != j && j + 1 < points.length && slope == points[i].slopeTo(points[j + 1])) {
                    segments++;
                    j++;
                }

                if (segments >= 3) pairs.add(new LineSegment(points[i], points[j]));
            }
        }
    }


    private boolean hasDuplicate(Point[] points) {
        for(int i = 1; i < points.length; i++)
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
        for(int i = 0; i< points.length; i++)
        {
            if (points[i] == null) return true;
        }

        return false;
    }


    public int numberOfSegments()        // the number of line segments
    {
        return pairs.size();
    }

    public LineSegment[] segments()                // the line segments
    {
        return pairs.isEmpty() ? null : pairs.toArray(new LineSegment[pairs.size()]);
    }
}