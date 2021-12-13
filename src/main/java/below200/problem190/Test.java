package below200.problem190;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().reverseBits(43261596));
    }


    public int reverseBits(int n) {
        int res = 0;
        int tmp = 2;
        int num = 1 << 30;
        if ((n & 1) == 1) {
            for (int i = 1; i < 32; i++) {
                if ((tmp & n) == 0) {
//                    res += num;
                    res |= num;
                }
                tmp = tmp << 1;
                num = num >> 1;
            }
            res += 1;
            res = -res;
        } else {
            for (int i = 1; i < 32; i++) {
                if ((tmp & n) != 0) {
//                    res += num;
                    res |= num;
                }
                tmp = tmp << 1;
                num = num >> 1;
            }
        }
        return res;
    }

    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }

    public int reverseBits3(int n) {
        final int M1 = 0x55555555; // 01010101010101010101010101010101
        final int M2 = 0x33333333; // 00110011001100110011001100110011
        final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
        final int M8 = 0x00ff00ff; // 00000000111111110000000011111111
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;

        return n >>> 16 | n << 16;
    }

}

