class Solution {
    public List<List<Integer>> fourSum(int[] arr, int K) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                int low=j+1,high=n-1;
                while(low<high){
                    long sum=arr[i];
                    sum+=arr[j];
                    sum+=arr[low];
                    sum+=arr[high];
                    if(sum==K){
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[low++]);
                        list.add(arr[high--]);
                        ans.add(list);
                        while(low<high && arr[low]==arr[low-1]) low++;
                        while(low<high && arr[high]==arr[high+1]) high--;
                    }
                    else if(sum<K) low++;
                    else high--;
                }
            }
        }
        return ans;
    }
}