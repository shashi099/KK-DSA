package arrays.KK;
// Rotated bSearch Question
//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1412189291/
//leetcode 33
public class RBS {
    //Approach to solve
    // 1:- find the pivot / peak index
    // 2:- Apply bSearch to 0 -> peak index
    // 3:- if not found the apply bSearch peak+1 index to arr.length-1
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 4));
    }

    public static int search(int[] arr, int target) {
        int peak = findPeak(arr);
        // Here we are getting the peak index
        // we can find the target in two part either before peak index or greater than peak index


        if(peak == -1){    // means the normal aray not sorted
            return bSearch(arr, target, 0, arr.length-1);
        }

        //  case1
        if(arr[peak] == target) return peak;
        //case2
        if(target < arr[0]){
            return bSearch(arr, target, peak+1, arr.length-1);
        }
        //case3
        return bSearch(arr, target, 0, peak);

    }

    static int bSearch(int[] arr, int target, int st, int end){
        while (st <= end){
            int mid = (st+end)/2;
            if(arr[mid] > target){
                end = mid-1;
            }else if(arr[mid] < target){
                st = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    static int findPeak(int[] arr){
        int st = 0, end = arr.length-1;

        while (st <= end){
            int mid = (st+end)/2;
            // there are 4 cases to find peak index

            //case1
            if(arr[mid] > arr[mid+1]){
                return mid;
            }
            //case2
            if(arr[mid] < arr[mid-1]){
                return mid-1;
            }
            //case3 when mid lies in right part where all are smaller than the start
            if(arr[mid] <= arr[st]){
                end = mid-1; // avoid the second half
            }
            // case4 when mid > st avoid first half
            if(arr[mid] > arr[st]){
                st = mid+1;
            }
        }
        return -1;
    }

}
