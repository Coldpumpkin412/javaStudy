package DFS_BFS;
import java.util.*;

public class DFS {
	public static boolean[] visited = new boolean[9]; //�湮ó��
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		//DFS(���� �켱 Ž��) ��� ǥ��
		
		//�׷��� �ʱ�ȭ
		for(int i=0 ; i<9 ; i++) {
			graph.add(new ArrayList<Integer>());
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
        
        //���� ��尡 '1'�϶� ��� Ž�� ����
        DFS(1); //1 2 7 6 8 3 4 5 ����� ���
	}
	
	//DFS�Լ�
	public static void DFS(int x) {
		//������ �湮ó��
		visited[x] = true;
		System.out.print(x + " ");
		
		//���� ���� ����� �ٸ� ��� ����� �湮
		for(int i=0 ; i<graph.get(x).size() ; i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) DFS(y);
		}
	}
}
