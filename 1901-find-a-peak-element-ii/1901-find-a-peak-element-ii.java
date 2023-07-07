class Solution {
    private int maxi(int[] arr, int end) {
	    int max = 0;
	    for ( int i = 0; i <= end; i++){
	        if (arr[i] > arr[max]) max = i;
	    }
	    return max;
	}
    
    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
	    int end = mat.length-1;
	    while(start<=end) {
	        int mid = start + (end - start)/2;
	        int col = maxi(mat[mid], mat[mid].length-1);
            
	        if (mid == 0 && mat[mid][col] > mat[mid + 1][col]) return new int[]{mid, col};
            
	        if (mid == mat.length - 1 && mat[mid][col] > mat[mid - 1][col]) return new int[]{mid, col};
            
	        if (mat[mid][col] > mat[mid + 1][col] && mat[mid][col] > mat[mid - 1][col]) return new int[]{mid, col};
            
	        if (mat[mid][col] < mat[mid + 1][col]) start = mid+1;
	        else end = mid -1;         
	    }
	    return new int[]{-1, -1};
    }
}