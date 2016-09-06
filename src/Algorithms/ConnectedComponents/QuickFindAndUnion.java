package Algorithms.ConnectedComponents;

/**
 * Created by hamed on 9/6/16.
 */
public class QuickFindAndUnion implements IUnionFind
{

    int nodeIds[];
    int childCount[];


    public QuickFindAndUnion(int nodeCount)
    {
        nodeIds = new int[nodeCount];
        childCount = new int[nodeCount];

        for(int i = 0; i < nodeIds.length; i++)
        {
            nodeIds[i] = i;
            childCount[i] = 1;
        }
    }


    @Override
    public void Union(int node1Id, int node2Id)
    {
        int i = Root(node2Id);
        int j = Root(node1Id);
        if (i ==  j) return;

        if (childCount[i] >= childCount[j])
        {
            // swap i with j
            int temp = i; i = j; j = temp;
        }

        // update offset from root
        childCount[j] += childCount[i];

        // update node's root
        nodeIds[i] = j;
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
