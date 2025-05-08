import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    int v;
    LinkedList<Integer> adj[];

    BFS(int n) {
        v = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void bfs_algo(int s) {
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList <> ();
        visited[s] = true;
        q.add(s);
        while(!q.isEmpty()) {
            s = q.remove();
            System.out.print(s + " ");
            for(int n : adj[s]) {
                if(!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFS g = new BFS(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(5, 6);

        System.out.println("BFS is : ");
        g.bfs_algo(0);
    }
}
