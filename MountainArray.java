package arrays.KK;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

public class MountainArray {
    static int findMountain(int[] arr){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[mid-1]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0};
//        int[] arr = {0,2,1,0};
        int ans = findMountain(arr);
        System.out.println(ans);
    }


}
