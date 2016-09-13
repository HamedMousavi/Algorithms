package Algorithms.ConnectedComponents;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats
{

    private double sampleMeanThreshold, sampleMeanDeviation, confidence;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n <= 0 || trials <= 0) throw new java.lang.IllegalArgumentException("");

        double[] sampleThreshold = new double[trials];

        int openCount;
        sampleMeanThreshold = 0;
        for (int i = 0; i < trials; i++) {
            openCount = 0;
            Percolation p = new Percolation(n);

            do {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                    openCount++;
                }
            } while (!p.percolates());

            sampleThreshold[i] = (double) openCount / (double) (n * n);
            sampleMeanThreshold += sampleThreshold[i];
        }

        sampleMeanThreshold /= (double) trials;

        for (int i = 0; i < trials; i++) {
            sampleMeanDeviation += Math.pow(sampleThreshold[i] - sampleMeanThreshold, 2);
        }

        sampleMeanDeviation /= (double) (trials - 1);
        sampleMeanDeviation = Math.sqrt(sampleMeanDeviation);

        confidence = (1.96d * sampleMeanDeviation) / Math.sqrt(trials);
    }


    public double mean()                          // sample mean of percolation threshold
    {
        return sampleMeanThreshold;
    }


    public double stddev()                        // sample standard deviation of percolation threshold
    {
        return sampleMeanDeviation;
    }


    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return sampleMeanDeviation - confidence;
    }


    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return sampleMeanDeviation + confidence;
    }


    public static void main(String[] args)    // test client (described below)
    {
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        StdOut.printf("mean = %f", ps.mean());
        StdOut.println();

        StdOut.printf("stddev = %f", ps.stddev());
        StdOut.println();

        StdOut.printf("95%% confidence interval = %f, %f", ps.confidenceLo(), ps.confidenceHi());
        StdOut.println();
    }
}
