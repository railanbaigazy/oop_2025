import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // [time, node]
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int u = (int) curr[1];

            if (time > dist[u]) continue;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    pq.offer(new long[]{dist[v], v});
                } else if (dist[v] == dist[u] + w) {
                    ways[v] = (ways[u] + ways[v]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}