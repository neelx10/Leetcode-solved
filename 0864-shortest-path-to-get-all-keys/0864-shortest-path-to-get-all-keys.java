class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m=grid.length;
        int n=grid[0].length();
        Queue<int[]> q=new LinkedList<>();
        
        int countKeys=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j)=='@') q.offer(new int[]{i,j,0,0});
                else if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f') countKeys++;
            }
        }
        
        int final_key_status_decimal=(int)(Math.pow(2,countKeys) - 1);
        
        int[][][] visited=new int[m][n][final_key_status_decimal+1];
        
        int[] drow={1,-1,0,0};
        int[] dcol={0,0,1,-1};
        
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int i=temp[0],j=temp[1],steps=temp[2],current_key_status_decimal=temp[3];
            if(current_key_status_decimal==final_key_status_decimal) return steps;
            
            for(int k=0;k<4;k++){
                int nrow=i+drow[k];
                int ncol=j+dcol[k];
                
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow].charAt(ncol)!='#'){
                    char ch=grid[nrow].charAt(ncol);
                    if(ch>='A' && ch<='F'){    //lock
                        if(visited[nrow][ncol][current_key_status_decimal]==0 && ((current_key_status_decimal >> (ch-'A'))&1)==1){    //have the key to this lock
                            visited[nrow][ncol][current_key_status_decimal]=1;
                            q.offer(new int[]{nrow,ncol,steps+1,current_key_status_decimal});
                        }
                    }
                    else if(ch>='a' && ch<='f'){       //key
                        if(visited[nrow][ncol][current_key_status_decimal]==0){
                            int new_key_status_decimal = current_key_status_decimal | (1 << (ch-'a'));
                            if(visited[nrow][ncol][new_key_status_decimal]==0){    
                                visited[nrow][ncol][new_key_status_decimal]=1;
                                q.offer(new int[]{nrow,ncol,steps+1,new_key_status_decimal});
                            }
                        }
                    }
                    else{   //dot
                        if(visited[nrow][ncol][current_key_status_decimal]==0){
                            visited[nrow][ncol][current_key_status_decimal]=1;
                            q.offer(new int[]{nrow,ncol,steps+1,current_key_status_decimal});
                        }
                    }
                }
            }
        }
        return -1;
    }
}