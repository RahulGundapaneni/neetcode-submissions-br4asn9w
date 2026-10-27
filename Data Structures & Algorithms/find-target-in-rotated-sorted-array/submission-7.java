class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {                       // <= so the last element is checked
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {           // left half is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;                 // target is in the sorted left half
                } else {
                    low = mid + 1;
                }
            } else {                                // right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;                  // target is in the sorted right half
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}