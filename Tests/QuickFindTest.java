package Tests;


import Algorithms.ConnectedComponents.QuickFind;
import org.junit.Assert;
import org.junit.Test;


public class QuickFindTest
{

    @Test
    public void IntegrationTest()
    {
        QuickFind uf = new QuickFind(10);
        uf.Union(3, 4);
        uf.Union(3, 8);
        uf.Union(6, 5);
        uf.Union(9, 4);
        uf.Union(2, 1);
        uf.Union(8, 9);
        uf.Union(5, 0);
        uf.Union(7, 2);
        uf.Union(6, 1);

        Assert.assertEquals(uf.IsConnected(3, 9), true);
        Assert.assertEquals(uf.IsConnected(2, 6), true);
        Assert.assertEquals(uf.IsConnected(0, 6), true);
        Assert.assertEquals(uf.IsConnected(0, 9), false);
    }

}
