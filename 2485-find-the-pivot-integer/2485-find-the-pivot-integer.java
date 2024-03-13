class Solution {
  public int pivotInteger(int n) {
        int sum = (n * (n + 1) / 2),pivot = (int) Math.sqrt(sum);
        return pivot * pivot == sum ? pivot : -1;
  }
}