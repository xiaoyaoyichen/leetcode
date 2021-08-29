package 困难.寻找两个有序数组的中位数;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    //todo;待研究更优秀的解法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = (nums1 == null ? 0 : nums1.length);
        int n = (nums2 == null ? 0 : nums2.length);
        int i = 0, j = 0, t = 0;
        int l = m + n;
        int[] nums = new int[l];
        while ( i < m || j < n){
            if (i < m && j < n && nums1[i] < nums2[j]){
                nums[t] = nums1[i];
                i++;
            } else if (i < m && j < n && nums1[i] >= nums2[j]){
                nums[t] = nums2[j];
                j++;
            } else if (i >= m && j < n){
                nums[t] = nums2[j];
                j++;
            } else if (i < m && j >= n){
                nums[t] = nums1[i];
                i++;
            }
            t++;
        }

        double result = 0;
        if (l % 2 == 0){
            result = (nums[l/2 - 1] + nums[l/2]) * 1.0 /2;
        } else{
            result = nums[l/2];
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
