class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost= new int[n][n];
        int m=edges.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j) cost[i][j]=(int)1e9;
            }
        }
        
        for(int i=0;i<m;i++){
            cost[edges[i][0]][edges[i][1]]=edges[i][2];
            cost[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        
        //Floyd Warshall Algorithm
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    cost[i][j]=Math.min(cost[i][j],cost[i][via]+cost[via][j]);
                }
            }
        }
        
        // calcuating city with the smallest number of neighbors at a val<=distanceThreshold
        int cntNode=(int)1e9; 
        int cityNum=(int)1e9; 
        // doing in reverse coz they want max value, there're multiple ways of doing this
        for(int i=n-1;i>=0;i--){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(cost[i][j]<=distanceThreshold) cnt++;
            }
            if(cntNode>cnt){ 
                cntNode=cnt;
                cityNum=i;
            }
        }
        return cityNum;
    }
}