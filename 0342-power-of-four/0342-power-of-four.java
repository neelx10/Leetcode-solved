class Solution {
    public boolean isPowerOfFour(int n) {
        double result = Math.log(n) / Math.log(4);
        return result==Math.round(result);
    }
}