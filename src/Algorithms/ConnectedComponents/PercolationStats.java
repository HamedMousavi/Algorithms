package Algorithms.ConnectedComponents;

import java.util.Random;

/**
 * Created by hamed on 9/13/16.
 */
public class PercolationStats
{

    Percolation p;
    double[] sampleThreshold;
    double sampleMeanThreshold, sampleMeanDeviation, confidence;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n <= 0 || trials <= 0) throw new java.lang.IllegalArgumentException("");

        Random rand = new Random();

        sampleThreshold = new double[trials];

        int openCount;
        sampleMeanThreshold = 0;
        for (int i = 0; i < trials; i++) {
            openCount = 0;
            p = new Percolation(n);

            do {
                int row = rand.nextInt(n) + 1;
                int col = rand.nextInt(n) + 1;
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                    openCount++;
                }
            } while (!p.percolates());

            sampleThreshold[i] = Double.valueOf(openCount) / Double.valueOf(n * n);
            sampleMeanThreshold += sampleThreshold[i];
        }

        sampleMeanThreshold /= Double.valueOf(trials);

        for (int i = 0; i < trials; i++) {
            sampleMeanDeviation += Math.pow(sampleThreshold[i] - sampleMeanThreshold, 2);
        }

        sampleMeanDeviation /= Double.valueOf(trials - 1);
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


    //public static void main(String[] args)    // test client (described below)
    //{

    //}
}
