package below700.problem659;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(new Test().isPossible(new int[] {1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6}));
	}
	
	
	public boolean isPossible(int[] nums) {
		Queue<Integer> queue = new LinkedList<>();
		for(int temp: nums)
			queue.add(temp);
		while(!queue.isEmpty()) {
			int size = queue.size();
			int count = 0;
			int lastNum = queue.peek() - 1;
			int len = 0;
			int i = 0;
			while(i < size) {
//				if(lastNum == queue.peek() - 1) {
//					int temp = count;
//					while(i < size && temp > 0 && lastNum == queue.peek() - 1) {
//						temp--;
//						i++;
//						queue.offer(queue.poll());
//					}
//					if(i < size && lastNum == queue.peek() - 1) {
//						i++;
//						lastNum = queue.poll();
//						len++;
//					}
//					while(i < size && lastNum == queue.peek()) {
//						i++;
//						count++;
//						queue.offer(queue.poll());
//					}
//				} else {
//					queue.offer(queue.poll());
//					i++;
//				}
				
//				�ڶ���ʵ��
				int num = queue.poll();
				int numTimes = 1;
				i++;
				while(i < size && queue.peek() == num) {
					i++;
					numTimes++;
					queue.poll();
				}
				for(int temp = 0; temp < numTimes; temp++) {
					if(temp == count && lastNum == num - 1) {
						lastNum = num;
						len++;
					} else {
						queue.offer(num);
					}
				}
				int temp = numTimes - 1 - count;
				if(temp > 0)
					count += temp;
				
			}
			if(len < 3)
				return false;
		}
		return true;
    }

//    ̰�ģ���x�ָ���x-1��β�ĳ�����̵Ķ���
//	  �˴���PriorityQueue�洢���ж��г��ȣ������Ƕ��б���key�����β
	public boolean isPossible2(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
//            if (!map.containsKey(x)) {
//                map.put(x, new PriorityQueue<Integer>());
//            }
//            if (map.containsKey(x - 1)) {
//                int prevLength = map.get(x - 1).poll();
//                if (map.get(x - 1).isEmpty()) {
//                    map.remove(x - 1);
//                }
//                map.get(x).offer(prevLength + 1);
//            } else {
//                map.get(x).offer(1);
//            }

//            �ڶ���ʵ�ַ���
            int prevLength = 1;
            if (map.containsKey(x - 1)) {
                prevLength += map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
            }
            map.computeIfAbsent(x, k -> new PriorityQueue<Integer>()).offer(prevLength);

        }
//        ֱ����map.values()�����
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

//    ̰��
//	  endMap��value�洢�������ж��и�����key�����β�����ȴ���3ͨ��ǿ����һ����������������֤������x�ָ�����һ����x-1��β�Ķ��ж�����
	public boolean isPossible3(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0) + 1;
            countMap.put(x, count);
        }
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int prevEndCount = endMap.getOrDefault(x - 1, 0);
                if (prevEndCount > 0) {
                    countMap.put(x, count - 1);
                    endMap.put(x - 1, prevEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
	
}
