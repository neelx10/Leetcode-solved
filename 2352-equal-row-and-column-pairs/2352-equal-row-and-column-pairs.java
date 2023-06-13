class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> map=new HashMap<>();
        for(int[] r:grid){
            StringBuilder sb=new StringBuilder();
            for(int num:r){
                sb.append("->");
                sb.append(num);
            }
            String s=sb.toString();
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        int count=0;
        int n=grid.length;
        for(int c=0;c<n;c++){
            StringBuilder sb=new StringBuilder();
            for(int r=0;r<n;r++){
                sb.append("->");
                sb.append(grid[r][c]);
            }
            String s1=sb.toString();
            if(map.containsKey(s1)) count+=map.get(s1);
        }
        return count;
    }
}