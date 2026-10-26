class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] > 0 && visited[i][j] == 0) {
                    long sum = dfs(m,n,i,j,grid,visited);
                    if(sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static long dfs(int m,int n,int row,int col,int[][] grid,int[][] visited) {
        if(row < 0 || col < 0 || row>= m || col>= n || grid[row][col] == 0 || visited[row][col] == 1) {
            return 0;
        }


        visited[row][col] = 1;
        long sum = grid[row][col];

        sum += dfs(m,n,row+1,col,grid,visited);
        sum += dfs(m,n,row-1,col,grid,visited);
        sum += dfs(m,n,row,col+1,grid,visited);
        sum += dfs(m,n,row,col-1,grid,visited);

        return sum;



    }
}