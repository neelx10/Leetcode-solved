class Solution {
public:
    int total;
    
    int findTargetSumWays(vector<int>& nums, int S) {
        total = accumulate(nums.begin(), nums.end(), 0);
        
        vector<vector<int>> memo(nums.size(), vector<int>(2 * total + 1, INT_MIN));
        
        return calculate(nums, 0, 0, S, memo);
    }
    
    int calculate(vector<int>& nums, int i, int sum, int S, vector<vector<int>>& memo) {
        if (i == nums.size()) {
            if (sum == S) return 1;
            else return 0;
        }
        
        if (memo[i][sum + total] != INT_MIN) return memo[i][sum + total];
        
        int add = calculate(nums, i + 1, sum + nums[i], S, memo);
        int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
        return memo[i][sum + total] = add + subtract;   
    }
};
