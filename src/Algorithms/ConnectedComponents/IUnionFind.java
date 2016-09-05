package Algorithms.ConnectedComponents;

/**
 * Created by hamed on 9/5/16.
 */
public interface IUnionFind
{
    void Union(int node1Id, int node2Id);
    boolean IsConnected(int node1Id, int node2Id);
}
