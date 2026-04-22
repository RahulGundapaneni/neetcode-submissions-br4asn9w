class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];          // fix 1: correct size
        for (int i = 0; i <= n - k; i++) {        // fix 3: correct bound
            int currMax = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {    // fix 2: j < i+k
                currMax = Math.max(currMax, nums[j]);
            }
            res[i] = currMax;
        }
        return res;
    }
}