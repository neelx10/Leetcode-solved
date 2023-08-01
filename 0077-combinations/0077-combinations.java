class Solution {
    private static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(1, n, k, current, result);
        return result;
    }
}