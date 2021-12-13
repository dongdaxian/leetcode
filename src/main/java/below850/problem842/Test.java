package below850.problem842;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		for(int temp: new Test().splitIntoFibonacci("13205813213"))
			System.out.println(temp);
	}
	
	
	public List<Integer> res = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String S) {
        findFibonacci(new ArrayList<>(), 0, S);
        return res;
    }
    public boolean findFibonacci(List<Integer> ls, int ptr, String S){
        if(ptr == S.length()){
            if(ls.size() > 2){
                res = ls;
                return true;
            }else{
                return false;
            }   
        }
        int target = -1;
        if(ls.size() > 1)
            target = ls.get(ls.size() - 1) + ls.get(ls.size() - 2);
        
        if(S.charAt(ptr) == '0'){
            if(target == -1 || target == 0){
                ls.add(0);
                if(findFibonacci(ls, ptr + 1, S))
                	return true;
                ls.remove(ls.size() - 1);
            }
            return false;
        } else {
            long num = 0;
            for(int i = ptr; i < S.length(); i++){
                num = num * 10 + S.charAt(i) - '0';
                if(num > Integer.MAX_VALUE)
                    return false;
                
                if(num < target)
                    continue;
                else if(target == -1 || num == target) {
                    ls.add((int)num);
                    if(findFibonacci(ls, i + 1, S))
                        return true;
                    ls.remove(ls.size() - 1);
                }
                else {
                    break;
                }
            }
        }
        return false;
    }
    
    //简洁版本，省去了为成员变量赋值的过程，传递的ls就包含最终结果；主体部分也使得return尽量少，只留下必要的return true用于剪枝
    public List<Integer> splitIntoFibonacci2(String S) {
    	List<Integer> res = new ArrayList<>();
    	findFibonacci2(res, 0, S);
        return res;
    }
    public boolean findFibonacci2(List<Integer> ls, int ptr, String S){
        if(ptr == S.length()){
            return ls.size() > 2; 
        }
        int target = 0;
        if(ls.size() > 1)
            target = ls.get(ls.size() - 1) + ls.get(ls.size() - 2);
        
        if(S.charAt(ptr) == '0'){
            if(ls.size() < 2 || target == 0){
                ls.add(0);
                if(findFibonacci(ls, ptr + 1, S))
                	return true;
                ls.remove(ls.size() - 1);
            }
        } else {
            long num = 0;
            for(int i = ptr; i < S.length(); i++){
                num = num * 10 + S.charAt(i) - '0';
                if(num > Integer.MAX_VALUE)
                    break;
                if(ls.size() > 1) {
                	if(num < target)
                        continue;
                	else if(num > target)
                		break;
                }
                ls.add((int)num);
                if(findFibonacci(ls, i + 1, S))
                    return true;
                ls.remove(ls.size() - 1);
            }
        }
        return false;
    }
}
