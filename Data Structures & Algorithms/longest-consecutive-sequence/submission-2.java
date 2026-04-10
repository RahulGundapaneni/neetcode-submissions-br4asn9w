class Solution {
    public int longestConsecutive(int[] nums) {
        // Brute Force, Sort the nums array and use 2 pointer approach
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums) {
            set.add(i);
        }
        int result = 0;
        for(int i: nums) {
            if(set.contains(i-1)) continue;
            int count = 1;
            int j  = i;
            while(set.contains(j+1)) {
                count = count + 1;
                set.remove(j);
                j = j + 1;
            }

            set.remove(j);
            if(result < count) {
                result = count;
            }
        }
        return result;
    }
}
