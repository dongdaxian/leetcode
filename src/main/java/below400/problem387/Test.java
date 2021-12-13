package below400.problem387;

public class Test {
	public int firstUniqChar(String s) {
        int[] nums = new int[26];
        for(char temp: s.toCharArray())
            nums[temp - 'a']++;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(nums[temp - 'a'] == 1)
                return i;
        }
        return -1;

    }
}
