class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int temp = 0;
        for(int i:derived) temp^=i;
        return temp == 0;
    }
}