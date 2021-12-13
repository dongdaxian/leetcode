package below350.problem331;

public class Test {
    public boolean isValidSerialization(String preorder) {
        String[] val = preorder.split(",");
        int stack = 0;
        if(!val[0].equals("#"))
            stack = 2;
        else if(val.length > 1)
            return false;
        else
            return true;
        for(int i = 1; i < val.length; i++) {
            String tmp = val[i];
            if(!tmp.equals("#")) {
                if(stack == 0)
                    return false;
                stack++;
            } else {
                stack--;
            }
        }
        return stack == 0;
    }
}
