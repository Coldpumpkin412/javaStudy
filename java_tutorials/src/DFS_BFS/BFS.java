package DFS_BFS;
import java.util.*;

public class BFS {
	public static boolean[] visited = new boolean[9]; //�湮ó���� �迭
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		// BFS(�ʺ� �켱 Ž��) ��� ǥ��
		
		for(int i=0 ; i<9 ; i++) {
			graph.add(new ArrayList<Integer>()); //�׷��� �ʱ�ȭ
		}
		
        // ��� 1�� ����� ��� ���� ���� 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // ��� 2�� ����� ��� ���� ���� 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // ��� 3�� ����� ��� ���� ���� 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // ��� 4�� ����� ��� ���� ���� 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // ��� 5�� ����� ��� ���� ���� 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // ��� 6�� ����� ��� ���� ���� 
        graph.get(6).add(7);
        
        // ��� 7�� ����� ��� ���� ���� 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // ��� 8�� ����� ��� ���� ���� 
        graph.get(8).add(1);
        graph.get(8).add(7);
        
        BFS(1);
	}
	
	//BFS�Լ� ����
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		//���� ��� �湮ó��
		visited[start] = true;
		
		while(!q.isEmpty()) { //ť�� �� ������ �ݺ�
			int x = q.poll();
			System.out.print(x + " ");
			
			//�ش� ���ҿ� ����������� ���� �湮���� ���� ���ҵ� ť�� ����
			for(int i=0 ; i<graph.get(x).size() ; i++) {
				int y= graph.get(x).get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
				}
			}
		}
	}

}
