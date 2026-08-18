class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> path = new ArrayList<>();
       path.add(0);
       solve(graph,res,path,0);
       return res;
    }
    public void solve(int graph[][],List<List<Integer>> res,List<Integer> path,int start){
        if(start == graph.length-1){
            res.add(new ArrayList(path));  
            return;
        }
        for(int ni:graph[start]){
            path.add(ni);
            solve(graph,res,path,ni);
            path.remove(path.size()-1);
        } 
    }
}