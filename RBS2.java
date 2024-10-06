package arrays.KK;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
// leetcode81
public class RBS2 {
    // Rotated Binary Search 2

    public static void main(String[] args) {
        int[] nums = {3, 5, 1};
        System.out.println(search(nums, 3));
    }

    public static boolean search(int[] nums, int target) {
        int pivot = findPeak(nums);
        System.out.println(pivot);

        if (nums[pivot] == -1) {
            return bSearch(nums, target, 0, nums.length - 1);
        }
        // cases
        if (nums[pivot] == target) {
            return true;
        }
        //
        if (target >= nums[0]) {
            return bSearch(nums, target, 0, pivot);
        }
        return bSearch(nums, target, pivot + 1, nums.length - 1);
    }

    static boolean bSearch(int[] arr, int target, int st, int end) {
        while (st <= end) {
            int mid = (st + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                st = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    static int findPeak(int[] arr) {
        int st = 0, end = arr.length - 1;
        while (st <= end) {
            // cases:
            int mid = (st + end) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > st && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // remove duplicates case like 2,3,2,2,2
            if (arr[st] == arr[mid] && arr[mid] == arr[end]) {
                // case check weather it's pivot or not
                if (st < end && arr[st] > arr[st + 1]) {
                    return st;
                }
                st++;  // ignore one index
                if (end > st && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--; // ignore last index
            } else if (arr[st] < arr[mid] || (arr[st] == arr[mid] && arr[mid] > arr[end])) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


}
