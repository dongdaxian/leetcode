package below450.problem406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		new Test().reconstructQueue(new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
		
	}
	//从小到大排
	public int[][] reconstructQueue(int[][] people) {        
        int[][] res = new int[people.length][2];
//      int[][] res = new int[people.length][2];	如果这样初始化，那么res[0] == null,可以省去初始化为-1的步骤
        for(int[] temp: res)
            Arrays.fill(temp, -1);
        Arrays.sort(people, (int[] o1, int[] o2) -> {if(o1[0] != o2[0]) return o1[0] - o2[0]; else return o1[1] - o2[1];});
        for(int[] temp: people){
            int count = 0;
            int j = 0;
            for(; j < res.length; j++){
                int[] arr = res[j];
                if(arr[0] == -1 && count == temp[1]) {
                	res[j] = temp;
                	break;
                }
                if(arr[0] == -1 || arr[0] >= temp[0])
                    count++;
            }
            
        }
        return res;
    }
	
	//从大到小排
	public int[][] reconstructQueue2(int[][] people) {
		Arrays.sort(people, (int[] o1, int[] o2) -> {if(o1[0] != o2[0]) return o2[0] - o1[0]; else return o1[1] - o2[1];});
		List<int[]> res = new ArrayList<>();
		for(int[] temp: people) {
			res.add(temp[1], temp);
		}
		return res.toArray(new int[res.size()][]);
	}
}
