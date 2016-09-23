/**
 * Created by hamed on 9/3/16.
 */

package Algorithms.ConnectedComponents;


public class QuickFind implements IUnionFind
{

    private int nodeIds[];


    public QuickFind(int nodeCount)
    {
        nodeIds = new int[nodeCount];
        for(int i = 0; i < nodeIds.length; i++)
        {
            nodeIds[i] = i;
        }
    }


    @Override
    public void Union(int node1Id, int node2Id)
    {
        if (IsConnected(node1Id, node2Id)) return;

        int oldGroupId = nodeIds[node1Id];
        int newGroupId = nodeIds[node2Id];
        for(int i = 0; i < nodeIds.length; i++)
        {
            if (nodeIds[i] == oldGroupId) nodeIds[i] = newGroupId;
        }
    }


    @Override
    public boolean IsConnected(int node1Id, int node2Id)
    {
        if (node1Id >= nodeIds.length || node2Id >= nodeIds.length || node1Id < 0 || node2Id < 0)
        {
            throw new IndexOutOfBoundsException("Requested node Ids are beyond boundaries of this class");
        }

        return nodeIds[node1Id] == nodeIds[node2Id];
    }


    public int NodeCount()
    {
        return nodeIds.length;
    }
}
