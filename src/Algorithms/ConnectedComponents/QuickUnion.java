package Algorithms.ConnectedComponents;

/**
 * Created by hamed on 9/5/16.
 */
public class QuickUnion implements IUnionFind
{

    int nodeIds[];


    public QuickUnion(int nodeCount)
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
        nodeIds[Root(node2Id)] = Root(node1Id);
    }


    private int Root(int nodeId)
    {
        if (nodeId >= nodeIds.length || nodeId < 0)
        {
            throw new IndexOutOfBoundsException("Requested node Id is beyond boundaries of this class");
        }

        while(nodeIds[nodeId] != nodeId)
        {
            nodeId = nodeIds[nodeId];
        }

        return nodeId;
    }


    @Override
    public boolean IsConnected(int node1Id, int node2Id)
    {
        if (node1Id >= nodeIds.length || node2Id >= nodeIds.length || node1Id < 0 || node2Id < 0)
        {
            throw new IndexOutOfBoundsException("Requested node Ids are beyond boundaries of this class");
        }

        return Root(node1Id) == Root(node2Id);
    }


    public int NodeCount()
    {
        return nodeIds.length;
    }
}
