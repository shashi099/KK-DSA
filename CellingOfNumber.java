package arrays.KK;

public class CellingOfNumber {

    static int celling(int[] nums, int tar){
        int st = 0, end = nums.length -1;
        while (st < end){
            int mid = (st + end)/2;
            if(nums[mid] < tar){
                st = mid +1;
            }else{
                end = mid;
            }
        }
        return st;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,5,9,14,16,18};
        int ans = celling(nums, 21);
        System.out.println(ans);
    }
}
