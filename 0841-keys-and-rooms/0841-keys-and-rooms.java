class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int neighbour : rooms.get(curr)) {
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
        
    }
}