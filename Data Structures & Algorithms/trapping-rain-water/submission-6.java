class Solution {
    public int trap(int[] height) {
        // Brute Force: For each value find leftMax and rightMax and
        // if the value < leftMax, rightMax, 
        //Min (leftMax , rightMax) - height(a)+ res

        //              0 2 0 3 1 0 1 3 2 1
        // left Max     0 0 2 2 3 3 3 3 3 3
        // right Max    3 3 3 3 3 3 3 3 3 0
        // result       0 0 2 0 2 3 2 0 0 0 ( if Element < leftMax and rightMax then find(Min(leftmax, rightMax) - index val))
        
        // Max value found in a iteration : 3
        // start with 3 check leftWall 
        // if( lw > index) then lw - index val
        // elsse lw = index Value
        int lw = 0;
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < height.length; i++) {
            if(max < height[i]) {
                maxIndex = i;
                max = height[i];
            }
        } 
        int l = 0;
        int totalWater = 0;
        while(l < maxIndex) {
            if(height[l] < lw) {
                totalWater = totalWater + lw - height[l];
            }
            else {
                lw = height[l];
            }
            l++;
        }
        int r = height.length - 1;
        int rw = 0;
        while(r > maxIndex) {
            if(height[r] < rw) {
                totalWater = totalWater + rw - height[r];
            }
            else {
                rw = height[r];
            }
            r--;
        }
        return totalWater;
        

    }
}
