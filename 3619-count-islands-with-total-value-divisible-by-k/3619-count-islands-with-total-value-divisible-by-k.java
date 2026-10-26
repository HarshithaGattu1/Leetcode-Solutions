class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] > 0 && visited[i][j] == 0) {
                    long sum = bfs(i,j,grid,visited,0);
                    System.out.println(sum);
                    if(sum % k == 0) {
                        count++;
                    }
                }  
            }
        }
        return count;
    }

    public static long bfs(int i,int j,int[][] grid,int[][] visited,long sum) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dir = {1,-1,0,0};
        int[] dic = {0,0,1,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = 1;
        sum += grid[i][j];
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int k=0;k<4;k++) {
                int newRow = row+dir[k];
                int newCol = col+dic[k];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0 && grid[newRow][newCol] > 0) {
                    sum += (long)grid[newRow][newCol];
                    q.add(new int[]{newRow,newCol});
                    visited[newRow][newCol] = 1;
                }
            }
        }
        return sum;
    }
}