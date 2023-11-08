class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx),height = Math.abs(sy - fy);
        return (width == 0 && height == 0 && t == 1)?false:t >= Math.max(width, height);
    }
}