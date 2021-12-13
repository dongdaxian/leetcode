package below850.problem844;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		class MyClass<E>
		{
			public <T> MyClass(T t)
			{
				System.out.println("hello");
			}
		}
	}
	
	public boolean backspaceCompare(String S, String T) {
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '#') {
				if(st.size() > 0)
					st.pop();
			} else {
				st.push(S.charAt(i));
			}
		}
		Stack<Character> stt = new Stack<>();
		for(int i = 0; i < T.length(); i++) {
			if(T.charAt(i) == '#') {
				if(stt.size() > 0)
					stt.pop();
			} else {
				stt.push(T.charAt(i));
			}
		}
		if(st.size() != stt.size()) return false;
		while(st.size() > 0) {
			if(st.pop() != stt.pop())
				return false;
		}
		return true;
    }
}
