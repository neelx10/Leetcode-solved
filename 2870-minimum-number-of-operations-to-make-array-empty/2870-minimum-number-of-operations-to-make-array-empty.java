class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (int c: map.values()) {
            if (c == 1) return -1;
            ans += Math.ceil((double) c / 3);
        }
        return ans;
    }
}