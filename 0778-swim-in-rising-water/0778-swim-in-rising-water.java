class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) return node;
        parent.set(node, findUPar(parent.get(node)));
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } 
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}



class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        boolean[][] vis = new boolean[n][n];
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int row=temp[0],col=temp[1],time=temp[2];
            if(row == n - 1 && col == n - 1) return time;
            vis[row][col] = true;
            for(int i = 0; i < 4; i++){
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];
                if(nrow>=0 && ncol>=0 && nrow < n && ncol < n && vis[nrow][ncol] == false){
                    pq.offer(new int[]{nrow, ncol, Math.max(time , grid[nrow][ncol])});
                }
            } 
        }
        return -1;
    }
}









