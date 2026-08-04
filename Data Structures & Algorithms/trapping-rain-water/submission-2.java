class Solution {
    public int trap(int[] height) {
        // height
        // water saved at i = min(maxL, maxR) - h[i]
        int totalWater = 0;
        int l = 1, r = height.length-2;
        int waterAtI = 0;
        int maxL = height[0];
        int maxR = height[height.length-1];

        while(l<=r) {
            if (maxL <= maxR) {
                waterAtI = maxL - height[l];
                waterAtI = (waterAtI>0)? waterAtI: 0;
                maxL = Math.max(maxL, height[l]);
                l++;
            } else {
                waterAtI = maxR - height[r];
                waterAtI = (waterAtI>0)? waterAtI: 0;
                maxR = Math.max(maxR, height[r]);
                r--;
            }
             
            totalWater+=waterAtI;
        }
        
        return totalWater;
    }
}
