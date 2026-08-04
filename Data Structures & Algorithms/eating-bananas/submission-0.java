class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int n=piles.length;
        Arrays.sort(piles);
        int r=piles[n-1];

        int mid;
        int res=-1;
        System.out.println("bin search between l "+l+" r "+r);
        while(l<=r){
            mid=(l+r)/2;
            System.out.println("testing rate "+mid);
            if(satisfiesH(piles,h,mid)){
                System.out.println("rate "+res+" satisfies condition, testing lower rate");
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
        System.out.println("testing if rate satisfies "+rate);
        for(int i=0; i<piles.length; i++) {
            hoursUsed+=Math.ceil((double)piles[i]/(double)rate);
            System.out.println("hoursUsed "+hoursUsed);
        }
        System.out.println("hours used for rate "+rate+" hours "+hoursUsed);
        return hoursUsed<=h;
    }
}
