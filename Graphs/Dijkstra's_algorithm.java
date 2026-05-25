class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,src});
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int d = curr[0];
            int node = curr[1];
            for(int[] neigh : adj.get(node)){
                int adjNode = neigh[0];
                int wt = neigh[1];
                if(dist[node] + wt < dist[adjNode]){
                    dist[adjNode] = dist[node]+wt;
                    pq.offer(new int[]{dist[adjNode],adjNode});
                }
            }
        }
        return dist;
    }
}
