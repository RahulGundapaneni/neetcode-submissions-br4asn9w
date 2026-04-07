class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        se = set(nums)
        if len(se)== len(nums): 
            return False
        return True
        