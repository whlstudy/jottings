package wang.study.leetcode;

public class MedianTwoSortedArrays {
    // this is a waste of space O(n+m)
    // thinking use none of extra space
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        int htlen = totalLen / 2;
        int[] comb = new int[totalLen];
        int tL = totalLen-1,index1=len1-1,index2=len2-1;
        double res;
        
        while (index1 >= 0 && index2 >= 0){
            if(nums1[index1] >= nums2[index2]){
                comb[tL] = nums1[index1];
                index1--;
            }else {
                comb[tL] = nums2[index2];
                index2--;
            }
            tL--;
        }
        while (index1>=0){
            comb[tL--] = nums1[index1--];
        }
        while (index2>=0){
            comb[tL--] = nums2[index2--];
        }
        if(totalLen %2 == 0){
            res = (comb[htlen] + comb[htlen-1])/2.0;
        }else {
            res = comb[htlen]/1.0;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
    
}
