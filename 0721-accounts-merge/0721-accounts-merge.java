class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) return node; 
        parent.set(node, findUPar(parent.get(node))); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) parent.set(ulp_u, ulp_v); 
        else if(rank.get(ulp_v) < rank.get(ulp_u)) parent.set(ulp_v, ulp_u); 
        else {
            parent.set(ulp_v, ulp_u); 
            rank.set(ulp_u, rank.get(ulp_u) + 1); 
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)) map.put(mail,i);
                else ds.unionByRank(i,map.get(mail));
            }
        }
        
        List<List<String>> merged=new ArrayList<>();
        for(int i=0;i<n;i++) merged.add(new ArrayList<String>());
        for(String mail:map.keySet()) merged.get(ds.findUPar(map.get(mail))).add(mail);

        
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merged.get(i).size()!=0){
                Collections.sort(merged.get(i));
                merged.get(i).add(0,accounts.get(i).get(0));
                ans.add(merged.get(i));
            }
        }
        return ans;
    }
}