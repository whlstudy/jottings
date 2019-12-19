package wang.study.leetcode;

public class MedianTwoSortedArrays {

    // space O(1) time O(m+n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0)
            return len2 % 2 == 0 ? (double) (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2 : nums2[len2 / 2 - 1];
        if (len2 == 0)
            return len1 % 2 == 0 ? (double) (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2 : nums1[len1 / 2 - 1];
        int mid = (len1 + len2) / 2;
        int i = 0, j = 0;
        int pre = 0, cur = 0;
        while (i + j - 1 != mid) {
            if (i == len1 ){
                pre = cur;
                cur = nums2[j];
                j++;
            } else if(j == len2){
                pre = cur;
                cur = nums1[i];
                i++;
            } else if(nums1[i] <= nums2[j]) {
                pre = cur;
                cur = nums1[i];
                i++;
            } else {
                pre = cur;
                cur = nums2[j];
                j++;
            }
        }

        return (len1 + len2) % 2 == 0 ? (double) (pre + cur) / 2 : pre;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3};
        int[] arr2 = new int[]{1};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

}
