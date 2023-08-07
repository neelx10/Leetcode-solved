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
        int totalElms = n * n;
        int[][] map = new int[totalElms][2];
        int[][] vis=new int[n][n];
        for(int i = 0; i < n; i++) { 
            for(int j = 0; j < n; j++) {
                map[grid[i][j]] = new int[]{i,j};
            }
        }
        DisjointSet ds = new DisjointSet(totalElms);
        int delRow[] = {0, 0, 1, -1};
        int delCol[] = {1, -1, 0, 0};
        int lastElm = totalElms - 1;
        for(int time = 0; time < totalElms;time++) {
            int x=map[time][0],y=map[time][1];
            vis[x][y]=1;
            for (int k = 0; k < 4; k++){
                int nrow = x + delRow[k];
                int ncol = y + delCol[k];
                if (nrow>=0 && nrow<n && ncol>=0 && ncol<n && vis[nrow][ncol] == 1) ds.unionBySize(x*n+y,nrow*n+ncol);
            }
            if (ds.findUPar(0) == ds.findUPar(lastElm)) return time;
        }
        return lastElm;
    }
}









