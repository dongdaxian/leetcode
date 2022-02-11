package below50.problem4;

public class Test {

	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 2};
		int[] nums2 = new int[]{-1, 3};
		System.out.println(new Test().findMedianSortedArrays(nums1, nums2));

	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = (nums1.length + nums2.length + 1)/2;
		int n = (nums1.length + nums2.length + 2)/2;
		if(m == n) 
			return findKth(nums1, 0, nums2, 0, m);											//nums1和nums2长度之和为奇，返回中间数字  
		else
			return (findKth(nums1, 0, nums2, 0, m) + findKth(nums1, 0, nums2, 0, n)) / 2.0; //nums1和nums2长度之和为偶，返回中间两个数字平均数  
    }
	
	
/* 二分法是每次取中间数，如果传入参数小于中间数，则其在中间数左边，换句话说中间数右边部分可以抛弃，这里部分运用了这种思想。
 * 要找两个数组中第K个数字，比较两个数组的第k/2个数（记为a、b且假设a<b），a以及a左边的数字可以抛弃，第k个数一定在a的右边或
 * 第二个数组中，此时问题变成了找第二个数组和从k/2开始的第一个数组排序后的第(k-k/2)个数 */
	public int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		if(start1 > nums1.length - 1) 
			return nums2[start2 + k - 1];
		if(start2 > nums2.length - 1) 
			return nums1[start1 + k - 1];
		if(k == 1) 
			return Math.min(nums1[start1], nums2[start2]);
		
		int sym1 = Integer.MAX_VALUE, sym2 = Integer.MAX_VALUE;
		if(start1 + k/2 - 1 < nums1.length)      //	那能不能找数组的第k/2+1个数呢？因为(k/2+1)*2=k+2或k+1，所以a及其左边
			sym1 = nums1[start1 + k/2 - 1];      //	的一个数字都有可能是正规排序后的第k个数，所以a及其左边的数字不能抛弃 
		if(start2 + k/2 - 1 < nums2.length)
			sym2 = nums2[start2 + k/2 - 1];
		
		if(sym1 < sym2)
			return findKth(nums1, start1 + k/2, nums2, start2, k - k/2);
		return findKth(nums1, start1, nums2, start2 + k/2, k - k/2);
	}
	
}
