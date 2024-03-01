class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int N = arr.length;
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            if (arr[left] == '1') left++;
            if (arr[right] == '0') right--;
            if (left <= right && arr[left] == '0' && arr[right] == '1') {
                arr[left] = '1';
                arr[right] = '0';
            }
        }
        arr[left - 1] = '0';
        arr[N - 1] = '1';
        return new String(arr);
    }
}