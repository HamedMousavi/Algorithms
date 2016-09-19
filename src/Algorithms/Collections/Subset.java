// package Algorithms.Collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset
{
    public static void main(String[] args)
    {
        if (args == null) throw new java.lang.IllegalArgumentException("Please enter how many words to choose");
        int displayCount = Integer.parseInt(args[0]);
        // StdOut.println("Please enter words separated by whitespace.");

        RandomizedQueue<String> q = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }


        // String[] words = StdIn.readLine().split("\\s+");

        // RandomizedQueue<String> q = new RandomizedQueue<String>();
        // for (String word : words)
        // {
        //     q.enqueue(word);
        // }

        for (int i = 0; i < displayCount; i++)
        {
            StdOut.println(q.dequeue());
        }
    }
}