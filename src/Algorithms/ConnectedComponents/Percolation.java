package Algorithms.ConnectedComponents;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{

    private int gridSize;
    private boolean[][] isSiteOpen;
    private WeightedQuickUnionUF uf;


    public Percolation(int n)               // create n-by-n grid, with all sites blocked
    {
        if (n <= 0) throw new java.lang.IllegalArgumentException("n must be an integer greater than zero.");
        Double siteCount = (double) n * (double) n + 2d;
        if (siteCount > Integer.MAX_VALUE ) throw new java.lang.IllegalArgumentException("n must be an integer less square root of int.Max_value.");

        gridSize = n;

        // Create an instance of the UF algorithm
        uf = new WeightedQuickUnionUF(siteCount.intValue()); // + for top and bottom nodes

        // Store site open/close state
        isSiteOpen = new boolean[n][n];
        for(int i = 0; i < n; i++)
        {
            isSiteOpen[i] = new boolean[n];
        }

        // Connect top and bottom virtual nodes
        for (int j = 1; j <= n; j++)
        {
            uf.union(0, ToUfIndex(1,j));
            uf.union(n*n+1, ToUfIndex(n,j));
        }
    }


    public void open(int i, int j)          // open site (row i, column j) if it is not open already
    {
        EnsureIndexInRange(i - 1);
        EnsureIndexInRange(j - 1);
        isSiteOpen[i - 1][j - 1] = true;

        // if top, left, right, or bottom are also open, union them
        if (i > 1 && isOpen(i-1, j)) uf.union(ToUfIndex(i-1, j), ToUfIndex(i, j));
        if (i < gridSize && isOpen(i+1, j)) uf.union(ToUfIndex(i+1, j), ToUfIndex(i, j));

        if (j > 1 && isOpen(i, j-1)) uf.union(ToUfIndex(i, j-1), ToUfIndex(i, j));
        if (j < gridSize && isOpen(i, j + 1)) uf.union(ToUfIndex(i, j+1), ToUfIndex(i, j));
    }


    public boolean isOpen(int i, int j)     // is site (row i, column j) open?
    {
        EnsureIndexInRange(i - 1);
        EnsureIndexInRange(j - 1);
        return isSiteOpen[i - 1][j - 1];
    }


    public boolean isFull(int i, int j)     // is site (row i, column j) full?
    {
        EnsureIndexInRange(i - 1);
        EnsureIndexInRange(j - 1);
        return isOpen(i, j) && uf.connected( ToUfIndex(i, j) , 0);
    }


    public boolean percolates()             // does the system percolate?
    {
        return uf.connected( gridSize * gridSize + 1, 0);
    }



    private void EnsureIndexInRange(int index)
    {
        if (index < 0 || index >= gridSize) throw new java.lang.IndexOutOfBoundsException();
    }


    private int ToUfIndex(int rowIndex, int colIndex) {
        return (rowIndex - 1) * gridSize + colIndex;
    }


    //public static void main(String[] args)  // test client (optional)
    //{}
}
