package below50.problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		int[] nums = {3, 3};
		int target = 6;
		int[] result = new Test().Two_Sum2(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}
	
	public int[] Two_Sum1(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i){
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
        }
        
		return result;
	}
	public int[] Two_Sum2(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i = 0; i < nums.length; i++){
			Integer index = map.get(target - nums[i]);
			if(index == null) map.put(nums[i], i);
			else{
				result[0] = index;
				result[1] = i;
				break;
			}
		}
		return result;
	}
	
	public int[] Two_Sum3(int[] nums, int target) 
	{
		//��numsÿ��Ԫ�ض�Ӧ��ֵ�� (Ԫ��ֵ, index)����TreeMap����key����Ȼ����β����һ��ָ�룬���м�ɨ��
		//�в�ͨ����ΪԪ��ֵ�����ظ�
		//ʹ�ö�ά����
		return null;
	}

}
