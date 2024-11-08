import java.util.Scanner;
import java.util.Arrays;

public class TravelingSalesman {
    private static final int MAX = 9999;
    private static int n;
    private static int[][] dist = new int[20][20];
    private static int completed;
    private static int[][] dp;
    private static int[][] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        n = scanner.nextInt();

        dist = new int[n][n];
        dp = new int[1 << n][n];
        path = new int[1 << n][n];

        System.out.println("Enter the distance matrix (0 for the same city):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = scanner.nextInt();
            }
        }

        completed = (1 << n) - 1;

        // Initialize dp array to -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("Minimum Distance Travelled -> " + tsp(1, 0));
        printPath();
    }

    private static int tsp(int mask, int pos) {
        if (mask == completed) {
            return dist[pos][0];
        }
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = MAX;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
                if (newAns < ans) {
                    ans = newAns;
                    path[mask][pos] = city;
                }
            }
        }
        return dp[mask][pos] = ans;
    }

    private static void printPath() {
        int mask = 1, pos = 0;
        System.out.print("Path: ");
        while (mask != completed) {
            System.out.print(pos + " ");
            pos = path[mask][pos];
            mask |= (1 << pos);
        }
        System.out.println(pos);
    }
}
