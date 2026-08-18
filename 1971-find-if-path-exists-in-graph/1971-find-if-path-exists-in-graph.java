class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        //Building graph using Adjacency list with the given edges
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == destination) {
                return true;
            }
            for(int neighbour : graph.get(curr)) {
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return false;
       
    }

    
}