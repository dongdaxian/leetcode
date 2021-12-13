package nowcoder.byteDance;

public class Test {
	
	public static void main(String[] args) {
		new Test().spiralOrder(5,  4);
	}
	
	public void spiralOrder(int row, int col) {
		int tempRow = row, tempCol = col;
		int ptr = 0;
		while(tempRow > 0 && tempCol > 0) {
			
			for(int i = 0; i < tempCol; i++) {
				ptr++;
				System.out.println(ptr);
			}
			for(int i = 0; i < tempRow - 1; i++) {
				ptr += col;
				System.out.println(ptr);
			}
			if(tempRow == 1 || tempCol == 1)
				break;
			for(int i = 0; i < tempCol - 1; i++) {
				ptr--;
				System.out.println(ptr);
			}
			for(int i = 0; i < tempRow - 2; i++) {
				ptr -= col;
				System.out.println(ptr);
			}
			tempRow -= 2;
			tempCol -= 2;
		}
	}
}
