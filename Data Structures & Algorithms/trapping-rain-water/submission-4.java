class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lw = height[0], l = 0;
        int rw = 0, r = n-1;
        int result = 0;
        while ( l < r ) {
            if(height[l] <= height[r]) {
                if(lw <= height[l]) {
                    lw = height[l];
                }
                else {
                    System.out.println("left "+ l);
                    result += lw - height[l]; 
                }
                l++;
            }
            else if(height[r] < height[l]) {
                if(rw <= height[r]) {
                    rw = height[r];
                }
                else {

                    System.out.println("right "+ r);
                    result += rw - height[r];
                }
                r--;
            }
        }
        return result;
    }
}
