package below200.problem191;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().hammingWeight(-3));
//        System.out.println(new Test().hammingWeight(01510));
    }

    public int hammingWeight(int n) {
        int num = 1;
        int res = 0;
        int i = 0;
        while (i++ < 32) {
            if ((num & n) != 0)
                res++;
            num = num << 1;
        }
        return res;
    }


    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

}
