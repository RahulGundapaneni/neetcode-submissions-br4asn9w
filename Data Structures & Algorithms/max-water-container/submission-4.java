class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int result = 0;
        while(left < right) {
            int min = Math.min(heights[left], heights[right]);
            int currStorage = min * (right - left);
            if(heights[left] > heights[right]) {
                right--;
            }
            else{
                left++;
            }
            result = Math.max(result, currStorage);
        }
        return result;
    }
}
