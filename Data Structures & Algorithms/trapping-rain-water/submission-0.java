class Solution {
    public int trap(int[] height) {
        // height
        // water saved at i = min(maxL, maxR) - h[i]
        int totalWater = 0;
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        int waterAtI = 0;

        Arrays.fill(maxL, 0);
        Arrays.fill(maxR, 0);
        //System.out.println(" maxL ");
        for (int i=1;i<height.length;i++) {
            maxL[i] = Math.max(maxL[i-1], height[i-1]);
            //System.out.print(maxL[i]+" ");
        }


        //System.out.println(" maxR ");
        for (int i=height.length-2; i>=0;i--) {
            maxR[i] = Math.max(maxR[i+1], height[i+1]);
            //System.out.print(maxR[i]+" ");
        }

        for(int i=0;i<height.length;i++) {

            //System.out.println("maxL["+i+"] = "+maxL[i]+" maxR["+i+"] = "+maxR[i]);
            waterAtI= (Math.min(maxL[i], maxR[i]) - height[i])>0?
                        (Math.min(maxL[i], maxR[i]) - height[i]):0;
            totalWater+= waterAtI;
        }
        return totalWater;
    }
}
