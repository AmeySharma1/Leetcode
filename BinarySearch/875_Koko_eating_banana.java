class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int n = piles.length;
        int max = 0;
        for(int i=0;i<n;i++){
            if(piles[i]>max) max =piles[i];
        }
        int right = max;
        int ans = right;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(is_possible(piles,h,mid)){
                ans = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return ans;
    }
    public boolean is_possible(int[] piles, int h, int k){
        long hours = 0;
        for(int pile : piles){
            hours += pile/k;
            if (pile % k != 0)
            hours++;
        }
        return hours<=h;
    }
}
