package below950.problem925;

public class Test {
	public static void main(String[] args) {
		
	}
	
	public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while(i < name.length() || j < typed.length()){
            if(i < name.length() && j < typed.length()){
                if(name.charAt(i) == typed.charAt(j)){
                    ++i;
                    ++j;
                }else if(j > 0 && typed.charAt(j) == typed.charAt(j - 1)){
                    j++;
                }else{
                    return false;
                }
            }
            else if(j < typed.length()){
                if(j > 0 && typed.charAt(j) == typed.charAt(j - 1)){
                    j++;
                }else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        
        return true;
    }
	
	
	public boolean isLongPressedName2(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

	
}
