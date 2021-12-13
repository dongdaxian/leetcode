package below50.problem41;

public class Test {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1};
		System.out.println(new Test().firstMissingPositive3(nums));
	}
	
	public int firstMissingPositive1(int[] nums) {                //���ÿռ䲻��O(1)
		boolean[] flag = new boolean[nums.length + 1];
		int i = 0;
		for(i = 0; i < nums.length; i++) {
			if(nums[i] > -1 && nums[i] < nums.length + 1)
				flag[nums[i]] = true;
		}
		for(i = 1; i < nums.length + 1 && flag[i]; i++);
		return i;
    }

	public int firstMissingPositive2(int[] nums) {             //��������i + 1��ӦindexΪi���ֿռ临�Ӷ�O(1)��ֻ����ԭ�����Ͻ��б�ǣ�����2��3���ñ�Ƿ�ʽ��΢��ͬ
		int i = 0;
		for(i = 0; i < nums.length; i++)
			if(nums[i] > 0 && nums[i] < nums.length + 1 && nums[i] != i + 1)
				if(nums[nums[i] - 1] != nums[i])   //��ֹ����Ԫ����ͬ�������ظ�����
				{
					int temp = nums[nums[i] - 1];
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
					i--;
				}
		
		for(i = 0; i < nums.length && nums[i] == i + 1; i++);
		return i + 1;
    }
	
	public int firstMissingPositive3(int[] nums) {			//���ʺ͵�һ��һ��������ʡ�˿ռ�
		int n = nums.length;
		int i = 0;
		int temp = 0;
		for(i = 0; i < n; i++)
			if(nums[i] < 1 || nums[i] > n)
				nums[i] = n + 1;
		for(i = 0; i < n; i++) {
			temp = Math.abs(nums[i]);
			if(temp > n) continue;
			
			temp--;
			if(nums[temp] > 0)                     //��ֹnums������Ԫ����ͬ������nums[temp]�ֱ������
				nums[temp] = -1 * nums[temp];
		}
		
		for(i = 0; i < n && nums[i] < 0; i++);
		return i + 1;
    }
}
