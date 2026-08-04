class Solution {
    public int maxArea(int[] heights) {
        // find maximum at left and maximum at righth
        int maxL, maxR, l,r;
        l = 0; r = heights.length-1;
        int maxArea = 0, area;
        while (l<r) {
            area = Math.min(heights[l], heights[r])*(r-l);
            maxArea = Math.max(area, maxArea);
            if(heights[l]<heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
