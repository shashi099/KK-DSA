package arrays.KK;

public class Koko_loves_to_eat_bananas {
    //Qs:- https://leetcode.com/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int h) {
        long st = 1, end = 0;
        for(int i=0; i<piles.length; i++){
            end = Math.max(end, piles[i]);
        }

        while(st <= end){
            long mid = st+(end-st)/2;
            // System.out.println(mid);
            long time = calTime(piles, mid);
            // System.out.println("time: "+ time);
            if(time <= h){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        // System.out.println(st +" "+ end);
        return (int)st;
    }
    long calTime(int[] piles, long mid){
        long time = 0;
        for(int i=0; i<piles.length; i++){
            if(piles[i] % mid > 0){
                time += (piles[i] / mid)+1;
            }else{
                time += piles[i] / mid;
            }
        }
        return time;
    }
}
