package Algorithms.Sort;


import java.util.ArrayList;

public class BruteCollinearPoints
{

    private ArrayList<LineSegment> pairs;

    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null || arrayHasNull(points)) throw new java.lang.NullPointerException();
        if (hasDuplicate(points)) throw new java.lang.IllegalArgumentException();

        pairs = new ArrayList<>();

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].compareTo(points[j]) == points[j].compareTo(points[k]) &&
                                points[i].compareTo(points[j]) == points[j].compareTo(points[l]))
                        {
                            pairs.add(0, new LineSegment(points[i], points[l]));
                        }

                    }

                }
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
