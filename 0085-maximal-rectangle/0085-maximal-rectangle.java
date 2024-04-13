class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int maxArea=0;
        int[] heights=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') heights[j]++;
                else heights[j]=0;
            }
            int area=largestRectangleArea(heights);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] leftS=new int[n];
        int[] rightS=new int[n];
        
        //for left smaller
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()) leftS[i]=0;
            else leftS[i]=st.peek()+1;
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();                // so that stack can be reused

        //for right smaller
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()) rightS[i]=n-1;
            else rightS[i]=st.peek()-1;
            st.push(i);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            int area=heights[i]*(rightS[i]-leftS[i]+1);
            ans=Math.max(ans,area);
        }
        
        return ans;
    }
}