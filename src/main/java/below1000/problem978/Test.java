package below1000.problem978;

public class Test {
    public int maxTurbulenceSize(int[] arr) {
        boolean flag = false;
        int maxLen = 0;
        int tmpLen = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if((arr[i] < arr[i + 1] && !flag) || (arr[i] > arr[i + 1] && flag)) {
                tmpLen++;
                flag = !flag;
            } else if(arr[i] != arr[i + 1]){
                maxLen = Math.max(maxLen, tmpLen);
                tmpLen = 2;
            } else {
                maxLen = Math.max(maxLen, tmpLen);
                tmpLen = 1;
            }
        }
        maxLen = Math.max(maxLen, tmpLen);
        return maxLen;
    }

//    优化了空间消耗的dp
    public int maxTurbulenceSize2(int[] arr) {
        if(arr.length == 0)
            return 0;
        int ret = 1;
        int dp0 = 1, dp1 = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if(arr[i] < arr[i + 1]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            ret = Integer.max(ret, dp0);
            ret = Integer.max(ret, dp1);
        }
        return ret;
    }
}
