package DFS_BFS;
import java.util.*;

public class Example_QUEUE {

	public static void main(String[] args) {
		//�ڹٸ� �̿��Ͽ� QUEUE ���� ����
		Queue<Integer> q = new LinkedList<>();

		//����(5)-����(2)-����(3)-����(7)-����()-����(1)-����(4)-����()
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
