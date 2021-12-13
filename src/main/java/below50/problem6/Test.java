package below50.problem6;

public class Test {
	public static void main(String[] args) {
		
	}
	
	public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int strLen = s.length();
        for(int i = 0; i < numRows; i++){
            
            int j = i;
            int temp = i;
            while(j < strLen){
                sb.append(s.charAt(j));
                if(temp != numRows - 1)
                    temp = numRows - 1 - temp;
                j += temp * 2;
            }
        }
        return sb.toString();
    }
	
}
