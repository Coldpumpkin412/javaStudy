package DFS_BFS;
import java.util.*;

public class Example_QUEUE {

	public static void main(String[] args) {
		//자바를 이용하요 QUEUE 예제 구현
		Queue<Integer> q = new LinkedList<>();

		//삽입(5)-삽입(2)-삽입(3)-삽입(7)-삭제()-삽입(1)-삽입(4)-삭제()
		q.offer(5);
		q.offer(2);
		q.offer(3);
		q.offer(7);
		q.poll();
		q.offer(1);
		q.offer(4);
		q.poll();
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
