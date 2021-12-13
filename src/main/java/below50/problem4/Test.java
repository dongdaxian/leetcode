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
			return findKth(nums1, 0, nums2, 0, m);											//nums1��nums2����֮��Ϊ�棬�����м�����  
		else
			return (findKth(nums1, 0, nums2, 0, m) + findKth(nums1, 0, nums2, 0, n)) / 2.0; //nums1��nums2����֮��Ϊż�������м���������ƽ����  
    }
	
	
/* ���ַ���ÿ��ȡ�м���������������С���м������������м�����ߣ����仰˵�м����ұ߲��ֿ������������ﲿ������������˼�롣
 * Ҫ�����������е�K�����֣��Ƚ���������ĵ�k/2��������Ϊa��b�Ҽ���a<b����a�Լ�a��ߵ����ֿ�����������k����һ����a���ұ߻�
 * �ڶ��������У���ʱ���������ҵڶ�������ʹ�k/2��ʼ�ĵ�һ�����������ĵ�(k-k/2)���� */
	public int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		if(start1 > nums1.length - 1) 
			return nums2[start2 + k - 1];
		if(start2 > nums2.length - 1) 
			return nums1[start1 + k - 1];
		if(k == 1) 
			return Math.min(nums1[start1], nums2[start2]);
		
		int sym1 = Integer.MAX_VALUE, sym2 = Integer.MAX_VALUE;
		if(start1 + k/2 - 1 < nums1.length)      //	���ܲ���������ĵ�k/2+1�����أ���Ϊ(k/2+1)*2=k+2��k+1������a�������
			sym1 = nums1[start1 + k/2 - 1];      //	��һ�����ֶ��п��������������ĵ�k����������a������ߵ����ֲ������� 
		if(start2 + k/2 - 1 < nums2.length)
			sym2 = nums2[start2 + k/2 - 1];
		
		if(sym1 < sym2)
			return findKth(nums1, start1 + k/2, nums2, start2, k - k/2);
		return findKth(nums1, start1, nums2, start2 + k/2, k - k/2);
	}
	
}
