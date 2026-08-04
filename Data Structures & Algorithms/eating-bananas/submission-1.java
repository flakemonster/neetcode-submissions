class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int n=piles.length;
        Arrays.sort(piles);
        int r=piles[n-1];

        int mid;
        int res=-1;
        while(l<=r){
            mid=(l+r)/2;
            if(satisfiesH(piles,h,mid)){
                res=mid;
                r=mid-1;
            } else{
                l=mid+1;
            }
        }
        return res;
    }

    public boolean satisfiesH(int[] piles, int h, int rate) {
        boolean satisfies = false;
        int hoursUsed = 0;
        for(int i=0; i<piles.length; i++) {
            hoursUsed+=Math.ceil((double)piles[i]/(double)rate);
        }
        return hoursUsed<=h;
    }
}
