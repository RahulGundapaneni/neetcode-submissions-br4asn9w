class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // i, j , k are distinct
        // Sort: -4, -1, -1, 0, 1, 2
        // Start with -4 > 0 break;

        // if -4 then goto -1, 2( -3) move lft pointer
        // next -1, and -1., 2 we cant continue if they are same
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = l - 1;
            while(left < right) {
                int count = nums[i] + nums[left] + nums[right];
                if(count == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } 
                else if(count < 0) {
                    left++;
                }
                else { right--; }
            }
        }
        return result;
    }
}
