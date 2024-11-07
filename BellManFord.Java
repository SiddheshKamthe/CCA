import java.util.*;

class Edge {
    int s, d, w;
    
    public Edge(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }
}

public class BellManFord {

    public static void bellmanFord(List<Edge> edges, int v, int e, int src) {
        int[] dist = new int[v];
        int[] prev = new int[v];
        
        Arrays.fill(dist, Integer.MAX_VALUE); 
        Arrays.fill(prev, -1);
        dist[src] = 0;
    
        for (int i = 1; i < v; i++) {
            for (Edge edge : edges) {
                int u = edge.s;
                int v_ = edge.d;
                int w = edge.w;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v_]) {
                    dist[v_] = dist[u] + w;
                    prev[v_] = u;
                }
            }
        }

        for (Edge edge : edges) {
            int u = edge.s;
            int v_ = edge.d;
            int w = edge.w;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v_]) {
                System.out.println("Error: negative cycle exists");
                return;
            }
        }

        System.out.println("Vertex distances from source (" + src + "):");
        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + "\t: Infinity");
            } else {
                System.out.println(i + "\t: " + dist[i] + " (previous: " + prev[i] + ")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(s, d, w));
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();
        
        bellmanFord(edges, v, e, src);
        
        sc.close();
    }
}