class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) maxValue = Math.max(maxValue, nums[i]);
        int[] data = new int[maxValue + 1];
        for (int i = 0; i < nums.length; i++) data[nums[i]] += nums[i];
        return helper(data, maxValue, new HashMap<>());
    }

    public int helper(int[] data, int x, Map<Integer, Integer> memo) {
        if (x == 0) return data[0];
        if (x == 1) return Math.max(data[0], data[1]);
        if (memo.containsKey(x)) return memo.get(x);
        memo.put(x, Math.max( helper(data, x - 1, memo), helper(data, x - 2, memo) + data[x]) );
        return memo.get(x);
    }
}