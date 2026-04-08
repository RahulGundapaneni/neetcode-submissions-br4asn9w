class Solution {
    public int[] twoSum(int[] nums, int target) {
        // [3,4,5,6] target = 7, o/p [0,1] because index 0 + index 1 = 7
        // HashMap, Key will be taget - index value , Value: Index
        //While traversing if element is in HashMap retrun Value of 1st Key and elememnt Index
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }
            map.put(target - nums[i], i);
        } 
        return new int[]{};
    }
}
