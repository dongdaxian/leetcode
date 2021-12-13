package below150.problem134;

public class Test {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] left = new int[gas.length];
        int sum = 0;
        int ptr = -1;
        for(int i = 0; i < gas.length; i++) {
            left[i] = gas[i] - cost[i];
            if(sum == 0){
                if(left[i] >= 0){
                    sum += left[i];
                    ptr = i;
                }
            } else {
                sum += left[i];
                if(sum < 0){
                    ptr = -1;
                    sum = 0;
                }
            }
        }
        if(ptr == -1) return -1;
        sum = 0;
        for(int i = 0; i < gas.length; i++){
            int j = (i + ptr) % gas.length;
            sum += left[j];
            if(sum < 0)
                return -1;
        }
        return ptr;

    }
}
