class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,4,6] 
        // [48, 24, 12, 8]
        // [2*4*6, 1*4*6, 1*2*6, 1*2*4]
        // left product [1, 1, 2, 8] * right [48,24,6,1] = [48, 24, 12, 8]

        int l = nums.length;
        int left[] = new int[l];
        left[0] = 1;
        // left product
        for(int i = 1; i < l; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        int right[] = new int[l];
        right[l-1] = 1;
        for(int i = l-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        int result[] = new int[l];
        for(int i = 0; i < l; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}  
