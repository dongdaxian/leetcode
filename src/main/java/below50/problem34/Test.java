package below50.problem34;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int[] res = search(nums, 0, nums.length - 1, target);
        return res != null ? res : new int[] {-1, -1};
    }
	
	//һ����˵���ݹ���ַ���ʹ��mid��������жϣ���������д���ܹ����ǲ�����׼
    public int[] search(int[] nums, int begin, int end, int target) {
        if(target > nums[end] || target < nums[begin]){
            return null;
        }
        if(begin == end && nums[begin] == target)
            return new int[]{begin, begin};
        int mid = (begin + end) / 2;
        int[] res1 = search(nums, begin, mid, target);
        int[] res2 = search(nums, mid + 1, end, target);
        if(res1 == null){
            return res2;
        } else if(res2 == null){
            return res1;
        } else{
            return new int[]{res1[0], res2[1]};
        }
    }
    
    //��׼�ݹ�
    public int[] search2(int[] nums, int begin, int end, int target) {
    	if(begin > end)
    		return null;
    	int mid = (begin + end) / 2;
    	if(nums[mid] == target) {
    		int[] res1 = search2(nums, begin, mid - 1, target);
    		int[] res2 = search2(nums, mid + 1, end, target);
    		int left, right;
    		if(res1 == null)
    			left = mid;
    		else
    			left = Math.min(mid, res1[0]);
    		
    		if(res2 == null)
    			right = mid;
    		else
    			right = Math.max(mid, res2[1]);
    		return new int[] {left, right};
    	} else if(nums[mid] < target) {
    		return search2(nums, mid + 1, end, target);
    	} else {
    		return search2(nums, begin, mid - 1, target);
    	}
    }
    
    public int[] searchRange2(int[] nums, int target) {
        int find = searchRangeHelper(nums, target);
        if(find == -1)
        	return new int[] {-1, -1};
        int left = find - 1;
        int right = find + 1;
        while(left > -1 && nums[left] == target)
        	left--;
        while(right < nums.length && nums[right] == target)
        	right++;
        return new int[] {left + 1, right - 1};
    }
    public int searchRangeHelper(int[] nums, int target) {
    	int low = 0;
    	int high = nums.length - 1;
    	//���ֲ����У��˴�������<=����������ֻ��һ��Ԫ��ʱ�����
    	while(low <= high) {
    		int mid = (low + high) / 2;
    		if(nums[mid] == target) {
    			return mid;
    		} else if(nums[mid] > target) {
    			high = mid - 1;
    		} else {
    			low = mid + 1;
    		}
    	}
    	return -1;
    }
	
    public int[] searchRange3(int[] nums, int target) {
    	int first = searchFirst(nums, target);
    	if(first < nums.length && nums[first] == target) {
    		return new int[] {first, searchFirst(nums, target + 1) - 1}; 
    	} else {
    		return new int[] {-1, -1};
    	}    	
    }
    
    //������Ķ��ֲ���,���ص�һ������target���±꣬��û��target�򷵻ص�һ������target���±꣬���Է��س������޵��±�
    public int searchFirst(int[] nums, int target) {
    	int low = 0, high = nums.length - 1;
    	while(low <= high) {
    		int mid = (low + high) / 2;
    		if(nums[mid] >= target)
    			high = mid - 1;
    		else
    			low = mid + 1;
    	}
    	return low;
    }
    
}
