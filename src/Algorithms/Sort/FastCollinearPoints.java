package Algorithms.Sort;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


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
            sort(duplicate, points[i].slopeOrder());

            segments = 1;
            for (j = 0; j < points.length - 1; j++) {
                if (points[i].compareTo(duplicate[j]) == 0 || points[i].compareTo(duplicate[j+1]) == 0) {
                } else {
                    if (points[i].slopeTo(duplicate[j]) == points[i].slopeTo(duplicate[j + 1])) segments++;
                    else if (segments >= minSegments) break;
                    else if (segments <= 1) segments = 1;
                }
            }

            if (segments >= minSegments) pairs.add(new LineSegment(points[i], duplicate[j - 1]));
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

    // bottom-up mergesort
    public static void sort(Point[] a, Comparator<Point> comparator) {
        int N = a.length;
        Point[] aux = new Point[N];
        for (int n = 1; n < N; n = n+n) {
            for (int i = 0; i < N-n; i += n+n) {
                int lo = i;
                int m  = i+n-1;
                int hi = Math.min(i+n+n-1, N-1);
                merge(a, aux, lo, m, hi, comparator);
            }
        }
    }


    private static void merge(Point[] a, Point[] aux, int lo, int m, int hi, Comparator<Point> comparator) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge back to a[]
        int i = lo, j = m+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > m)                a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(comparator, aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }


    private static boolean less(Comparator<Point> comparator, Point v, Point w) {
        return comparator.compare(v, w) < 0;
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