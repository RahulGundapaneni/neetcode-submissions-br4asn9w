class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); 
        int l = nums.length - 1;
        int idx = 0;
        while(idx < l - 1) {                // ✅ need two elements after idx
            if(idx > 0) {                             // ✅ idx > 0
                if(nums[idx] == nums[idx - 1]){
                    idx++;                            // ✅ move forward before continue
                    continue;
                }
            }
            int curr = nums[idx];
            int left = idx + 1;
            int right = l;

            while(left < right) {
                
                if(left > idx + 1 &&nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                else if(right < l && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if(nums[left] + nums[right] > -curr) {
                    right--;
                }
                else if(nums[left] + nums[right] < -curr) {
                    left++;
                }
                else if(nums[right] + nums[left] == -curr) {
                    List<Integer> currList = new ArrayList<>();
                    currList.add(nums[idx]);
                    currList.add(nums[left]);
                    currList.add(nums[right]);
                    result.add(currList);
                    left++;
                }
            }
            idx++;
        }
        return result;
    }
}
