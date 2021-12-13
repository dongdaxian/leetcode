package below650.problem649;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(new Test().predictPartyVictory("RD"));
	}
	
	public String predictPartyVictory(String senate) {
		int ban = 0;
		int numR = 0;
		int numD = 0;
		Queue<Boolean> queue = new LinkedList<>();
		for(char temp: senate.toCharArray()) {
			if(temp == 'R') {
				queue.add(true);
				numR++;
			}
			else {
				queue.add(false);
				numD++;
			}
		}
		while(numR > 0 && numD > 0) {
			int size = queue.size();
			numR = 0;
			numD = 0;
			for(int i = 0; i < size; i++) {
				boolean temp = queue.poll();
				if(temp == true) {
					ban--;
					if(ban < 0) {
						numR++;
						queue.add(true);
					}
				} else {
					ban++;
					if(ban > 0) {
						numD++;
						queue.add(false);
					}
				}
			}
		}
//		if(numR > 0)
//			return "Radiant";
//		return "Dire";
		return numR > 0 ? "Radiant" : "Dire"; 
    }
	
	//·½·¨¶þ
	public String predictPartyVictory2(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
	
	
}
