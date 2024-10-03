package arrays.KK;

public class Leetcode34 {

    static int bSearch(int[] arr, int st, int end, int target, boolean firstIndex){
        int ansRandom = -1;

        while (st <= end){
            int mid = (st+end)/2;

            if(arr[mid] == target) {
                ansRandom = mid;
            }
            if(arr[mid] < target){
                st = mid+1;
            }else if(arr[mid] > target){
                end = mid-1;
            }else{
                if(firstIndex){
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }

        }
//        if(st > arr.length-1) return -1;
        return ansRandom;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 10;
//        System.out.println(" =. ");
        int ans = bSearch(arr, 0, arr.length-1, target, true);
        int ans2 = bSearch(arr, 0, arr.length-1, target, false);
        System.out.println(ans +" "+ans2);
    }
}
