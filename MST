import java.util.LinkedList;
import java.util.PriorityQueue;

public class MST_Prims {
    int V;
    LinkedList<Integer> adj[];
    int weight[][];

    MST_Prims(int n) {
        V = n;
        this.adj = new LinkedList[V];
        this.weight = new int[V][V];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList();
        }
    }

    void add_edge(int u, int v, int w) {
        adj[u].add(v);
        adj[v].add(u);
        weight[u][v] = w;
        weight[v][u] = w;
    }

    void mst(int s) {
        int visited[] = new int[V];
        int dist[] = new int[V];
        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = 0;
            parent[i] = -1;
        }
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            visited[u.v] = 1;
            for (Integer i : adj[u.v]) {
                if (visited[i] == 0 && weight[u.v][i] < dist[i]) {
                    dist[i] = weight[u.v][i];
                    parent[i] = u.v;
                    pq.add(new Node(i, dist[i]));
                }
            }
        }
        int sum = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + weight[parent[i]][i]);
            sum = sum + weight[parent[i]][i];
        }
        System.out.println("MST Sum :   "+sum);
    }

    public static void main(String[] args) {
        MST_Prims g = new MST_Prims(7);
        g.add_edge(0, 1, 8);
        g.add_edge(0, 2, 5);
        g.add_edge(1, 2, 10);
        g.add_edge(1, 3, 2);
        g.add_edge(1, 4, 20);
        g.add_edge(2, 3, 3);
        g.add_edge(2, 5, 15);
        g.add_edge(3, 4, 12);
        g.add_edge(3, 6, 18);
        g.add_edge(3, 5, 35);
        g.add_edge(4, 6, 4);
        g.add_edge(5, 6, 30);
        g.mst(0);
    }
}

class Node implements Comparable<Node> {
    int v, weight;

    Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}
