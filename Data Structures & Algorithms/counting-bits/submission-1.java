class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i = 0; i <=n; i++) {
            int x = i;
            if(x == 0) result[i] = 0;
            int currSum = 0;
            while(x!=0) {
                currSum = currSum + x % 2;
                x = x >> 1;
            }
            result[i] = currSum;
        }
        return result;
    }
}
