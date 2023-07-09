class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==536870912) return true;
        double result = Math.log(n) / Math.log(2);
        return result==Math.round(result);
    }
}