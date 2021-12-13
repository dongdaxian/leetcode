package below650.problem605;

public class Test {
	public static void main(String[] args) {
		System.out.println(-1 / 2);
	}
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int bef = -2;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) {
            	// -1/2=0
                n = n - (i - bef - 2) / 2;
                bef = i;
            }
        }
        n = n - (flowerbed.length + 1 - bef - 2) / 2;
        if(n <= 0)
            return true;
        return false;
    }
	
}
