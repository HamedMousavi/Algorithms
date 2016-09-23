// package Algorithms.Sort;

import java.util.ArrayList;
import java.util.Arrays;


public class FastCollinearPoints {

    private ArrayList<LineSegment> pairs;

    public FastCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null || arrayHasNull(points)) throw new java.lang.NullPointerException();
        if (hasDuplicate(points)) throw new java.lang.IllegalArgumentException();

        pairs = new ArrayList<>();
        int segments = 1;
        int minSegments = 3, j = 0;
        Point[] duplicate = Arrays.copyOf(points, points.length);

        for (int i = 0; i < points.length; i++) {
            Arrays.sort(duplicate, points[i].slopeOrder());

            segments = 1;
            for (j = 0; j < points.length - 1; j++) {
                if (points[i].compareTo(duplicate[j]) == 0 || points[i].compareTo(duplicate[j+1]) == 0) {
                } else {
                    if (points[i].slopeTo(duplicate[j]) == points[i].slopeTo(duplicate[j + 1])) segments++;
                    else if (segments >= minSegments)
                    {
                        pairs.add(new LineSegment(points[i], duplicate[j - 1]));
                        segments = 1;
                    }
                    else if (segments <= 1) segments = 1;
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
        for (int i = 0; i < points.length; i++)
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
        return pairs.isEmpty() ? new LineSegment[0] : pairs.toArray(new LineSegment[pairs.size()]);
    }
}