package DFS_BFS;
import java.util.*;
public class Adjacency_Matrix {
	//final�� �����Ͽ� ������ �� ���� ����� INF ����
	public static final int INF = 999999999;
	
	//2���� ����Ʈ�� Ȱ���Ͽ� ������� ǥ��
	public static int[][] graph ={
			{0, 7, 5},
			{7, 0, INF},
			{5, INF, 0}	
	};
	
	public static void main(String[] args) {
		//'�������' : 2���� �迭�� �̿��Ͽ� ������踦 ǥ��
		//�׷��� ���
		for(int i=0 ; i<3 ; i++) {
			for(int j=0 ; j<3 ; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
		
	}
	


}
