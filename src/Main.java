import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
	    UnionFind uf = new UnionFind(Integer.parseInt(scanner.nextLine()));

        for (int i = 0; i <uf.NodeCount(); i++)
        {
            int node1 = Integer.parseInt(scanner.nextLine());
            int node2 = Integer.parseInt(scanner.nextLine());

            uf.Union(node1, node2);
        }
    }
}
