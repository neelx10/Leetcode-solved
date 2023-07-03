class Solution {
    int ans=(int)1e9;
    public void dfs(int[] cookies,int[] arr,int k,int i){
        if(i==cookies.length){
            int uf=(int)-1e9;
            for(int num:arr) uf=Math.max(uf,num);
            ans=Math.min(ans,uf);
            return;
        }
        
        for(int j=0;j<k;j++){
            arr[j]+=cookies[i];
            dfs(cookies,arr,k,i+1);
            arr[j]-=cookies[i];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int[] arr=new int[k];
        dfs(cookies,arr,k,0);
        return ans;
    }
}