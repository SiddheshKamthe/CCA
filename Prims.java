import java.util.Scanner;

public class Prim {
    
    public static void prims(int v, int[][] graph) {
        int[] parent = new int[v];  
        int[] key = new int[v];    
        boolean[] mst = new boolean[v];    
        
        // Initialize key values to infinity and mst[] to false
        for (int i = 0; i < v; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }
        key[0] = 0;   
        parent[0] = -1;   
        
        // Prim's algorithm to find minimum spanning tree
        for (int count = 0; count < v - 1; count++) {
            int min = Integer.MAX_VALUE, idx = -1;
            for (int j = 0; j < v; j++) {
                if (!mst[j] && key[j] < min) {
                    min = key[j];
                    idx = j;
                }
            }
            int u = idx;
            mst[u] = true;
            
            // Update key values for adjacent vertices
            for (int V = 0; V < v; V++) {
                if (graph[u][V] != 0 && !mst[V] && graph[u][V] < key[V]) {
                    parent[V] = u;
                    key[V] = graph[u][V];
                }
            }
        }

        // Output the edges and their weights
        System.out.println("Edge \t Weight");
        int mstwt = 0;
        for (int i = 1; i < v; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            mstwt += graph[i][parent[i]];
        }
        System.out.println("MST Weight: " + mstwt);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();

        int[][] graph = new int[20][20];  // Maximum 20 vertices
        
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        
        prims(V, graph);
        
        scanner.close();
    }
}
