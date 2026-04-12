class Solution {
    public int maxArea(int[] heights) {
        // l = 1st index, r = lastIndex
        // l = 0(1), r = 7(6) 6 > 1 and area = result = max(max,6- 0 * 1(min(1,6)))
        // move left as 6 > 1

        int l = 0;
        int r = heights.length - 1;
        int result = 0;
        while(l < r) {
            System.out.println("left "+ l + " right + "+ r);
            int area = ((r - l) * Math.min(heights[l], heights[r]));
            result = Math.max(result, area);
            if(heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return result; 
    }
}
