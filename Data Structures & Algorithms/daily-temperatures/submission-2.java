class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int l = temperatures.length;
        int[] result = new int[l];

        // 30 38 30 36
        if(l > 1) {
            st.push(new int[]{temperatures[0], 0});
        }
        // St 30,0
        for(int i= 1; i < l; i++) {
            int curr = temperatures[i]; //38
            while( !st.isEmpty() && st.peek()[0] < curr) {  //30 < 38
                int outIndex = st.pop()[1];  // 0
                result[outIndex] = i - outIndex;  // 1
            }
            st.push(new int[]{curr, i});
        }
        return result;
    }
}
