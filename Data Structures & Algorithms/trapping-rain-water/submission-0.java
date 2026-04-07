class Solution {
    public int trap(int[] height) {
        // find left pass max values
        int l = height.length;
        int[] leftWall = new int[l];
        int leftMax = 0;
        for(int i = 0; i < l; i++) {
            leftWall[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        // find from right side

        int[] rightWall = new int[l];
        int rightMax = 0;
        for(int i = l-1; i >= 0; i--) {
            rightWall[i] = rightMax;
            rightMax = Math.max(rightMax, height[i]);
        }

        int[] resultWall = new int[l];
        int volume = 0;
        for(int i = 0; i < l; i++) {
            int count = Math.min(rightWall[i], leftWall[i]);
            System.out.println(count);
            int cap = count - height[i];
            if(cap > 0){
                volume = volume + cap;
            }
        }
        return volume;
    }
}
