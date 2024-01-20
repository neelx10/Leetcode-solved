class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=(int)1e9 + 7;
        long sum=0;
        int[] nsl=new int[n];
        int[] nsr=new int[n];
        Stack<Integer> st=new Stack<>();
        //next smaller to left
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
               nsl[i]=st.peek();
            }else{
                nsl[i]=-1;
            }
            st.push(i);
        }

        st.clear();         //for reuse

        //next smaller to right
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
               nsr[i]=st.peek();
            }else{
                nsr[i]=n;
            }
            st.push(i);
        }

        for(int i = 0; i < n; i++){
            int left=i-nsl[i];
            int right=nsr[i]-i;
            long total=(left*right)%mod;
            total=(total*arr[i])%mod;
            sum=(sum+total)%mod;
        }
        return (int)sum% mod;
    }
}









