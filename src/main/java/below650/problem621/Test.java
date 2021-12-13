package below650.problem621;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
	
	
	public static void main(String[] args) {
		System.out.println(new Test().leastInterval(new char[] {'A','B','A'}, 2));
	}
	
	//���ڶѵ�̰��
	public int leastInterval(char[] tasks, int n) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((Integer a, Integer b) -> {return b - a;});
		Map<Character, Integer> map = new HashMap<>();
		for(char ch: tasks) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		queue.addAll(map.values());
		int res = 0;
		while(!queue.isEmpty()) {
			int[] record = new int[n + 1];
			int count = 0;
			for(int i = 0; i < n + 1; i++) {
				if(!queue.isEmpty()) {
					record[i] = queue.poll() - 1;
					count++;
				}
			}
			for(int i = 0; i < n + 1; i++) {
				if(record[i] != 0) {
					queue.offer(record[i]);
				}
			}
			if(queue.isEmpty())
				res += count;
			else
				res += n + 1;
		}
		
		return res;
    }
	
	//ģ��
	public int leastInterval2(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for(char ch: tasks) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		List<Integer> rest = new ArrayList<>(map.values());
		List<Integer> nextValid = new ArrayList<>();
		for(int i = 0; i < rest.size(); i++)
			nextValid.add(1);
		
		int time = 0;
		while(!rest.isEmpty()) {
			time++;
			int best = -1;
			for(int i = 0; i < rest.size(); i++) {
				//��Ϊ���ڴ��������ܿչ�������취������nextValidȡ��С����time�Ƚϣ��ϴ��߸���time������Ϊÿ�ζ�Ҫ����nextValid��ʱ�临�ӶȲ�һ����С
				if(nextValid.get(i) <= time) {
					if(best == -1 || rest.get(best) < rest.get(i))
						best = i;
				}
			}
			if(best != -1) {
				int val = rest.get(best) - 1;
				if(val > 0) {
					//��ͳһ��������ǰ����Ҫ�ж�nextValid.get(i)�Ƿ����0����!rest.isEmpty()������Ϊѭ���Ƿ����������
					rest.set(best,  val);
					nextValid.set(best, nextValid.get(best) + n + 1);
				} else {
					rest.remove(best);
					nextValid.remove(best);
				}
			}
		}
		return time;
	}
	
	
	public int leastInterval3(char[] tasks, int n) {
		int maxExec = 0;
		int maxCount = 0;
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for(char ch: tasks) {
			int exec = freq.getOrDefault(ch, 0) + 1;
			freq.put(ch, exec);
			maxExec = Integer.max(maxExec, exec);
		}
		for(int temp: freq.values()) {
			if(temp == maxExec)
				maxCount++;
		}
		//ֻҪû�дﵽmaxExec����ôһ�����Բ���maxExec��Ӧ��key�γɵĿ�϶�䣬����ֻ��maxExec��Ӧ��key���п��ܲ��������ո�
		return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
	}
}
