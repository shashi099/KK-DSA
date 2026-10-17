package arrays.KK.rough_and_tough;

public class SplitArray {
    // leetcode 410

    public static void main(String[] args) {
//        int[] arr = {7,2,5,8,10};
        int[] arr = {1,2,3,4,5};
        System.out.println(splitArray(arr, 2));
    }
    public static int splitArray(int[] nums, int k) {
        int st = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            st = Math.max(st, nums[i]);
            end += nums[i];
        }

        while (st < end){
            int mid = (st + end)/2;

            // detect the sum to count how many pieces we need to do
            int sum = 0;
            int pieces = 1;

            for (int num: nums) {
                if(sum + num > mid){
                    // need to create a new piece
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }

            // check to pieces or the given k times split condition
            // if pieces > k  means need to exceed the sum
            if(pieces > k){
                st = mid +1;
            }else {
                end = mid;
            }
        }
        return st; // or can return end also
    }
}
