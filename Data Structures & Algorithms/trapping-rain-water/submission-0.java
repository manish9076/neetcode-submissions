class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = n-1;
        int ans = 0;
        while(l < r){
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            if(leftMax < rightMax){

                ans = ans + leftMax - height[l];
                l++;
            } else {
                
                ans = ans + rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
