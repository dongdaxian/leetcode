package below100.problem88;

public class Test {

	public static void main(String[] args) {
		int[] num1 = new int[]{0};
		int[] num2 = new int[]{1};
		new Test().merge2(num1, 0, num2, 1);
		for(int i = 0; i < 1; i++)
			System.out.println(num1[i]);  //不能直接输出数组
		
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int k = 0;
        int i = 0, j = 0;
        for(i = 0, j = 0; i < m && j < n;)
        {
        	if(nums1[i] <= nums2[j])
        		result[k++] = nums1[i++];
        	else
        		result[k++] = nums2[j++];
        }
        if(i == m){
        	for(; j < n; j++)
        		result[k++] = nums2[j];
        }else if(j == n){
        	for(; i < m; i++)
        		result[k++] = nums1[i];
        }
        for(i = 0, j = 0; j < m + n; j++){
        	nums1[i++] = result[j];
        }
    }
	
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		for(int i = m - 1, j = n - 1, k = m + n - 1; i > -1 || j > -1; k--) {
			if(i > -1 && j > -1) {
				if(nums1[i] > nums2[j]) 
					nums1[k] = nums1[i--];
				else 
					nums1[k] = nums2[j--];
			} else if(i > -1) {
				nums1[k] = nums1[i--];
			} else {
				nums1[k] = nums2[j--];
			}
				
		}
	}

}
