class Solution {
    private static final int MOD = (int) 1e9 + 7;
    
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] s = new int[n];
        s[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            s[i] = s[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; ++i) {
            int j0 = lowerBound(s, s[i] * 2, i + 1, n - 1);
            int j1 = lowerBound(s, (s[i] + s[n - 1]) / 2 + 1, j0, n - 1);
            ans = (ans + j1 - j0) % MOD;
        }
        return ans;
    }

    private int lowerBound(int[] s, int x, int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (s[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}