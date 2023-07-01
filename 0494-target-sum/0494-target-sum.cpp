class Solution {
public:
    int f(int ind, int target, vector<int>& nums, unordered_map<string, int>& memo) {
        string key = to_string(ind) + "," + to_string(target);
        
        if (ind < 0) {
            if (target == 0) return 1;
            else return 0;
        }
        
        if (memo.count(key)) return memo[key];
        
        int pos = f(ind - 1, target - nums[ind], nums, memo);
        int neg = f(ind - 1, target + nums[ind], nums, memo);
        
        memo[key] = pos + neg;
        return memo[key];
    }
    
    int findTargetSumWays(vector<int>& nums, int target) {
        unordered_map<string, int> memo;
        return f(nums.size() - 1, target, nums, memo);
    }
};
