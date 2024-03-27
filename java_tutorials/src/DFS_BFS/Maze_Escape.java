package DFS_BFS;
import java.util.*;

class ABC {
	private int x;
	private int y;
	
	public ABC(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}

public class Maze_Escape {
	
	public static int n, m; //n x m ũ���� �̷�
	public static int[][] graph = new int[200][200]; //�̷� ǥ�� �׷���
	
	//�̵����� 4���� ����
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		// BFS Ȱ���Ͽ� �̷� Ż�� ���� �ذ�
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine(); //���������
		
		//2���� ����Ʈ �� ���� �Է¹ޱ�
		for(int i=0 ; i<n ; i++) {
			String str = sc.nextLine();
			for(int j=0 ; j<m ; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		//BFS������ ���
		System.out.println(BFS(0,0));
	}
	
	public static int BFS(int x, int y) {
		//ť ������ ���� ť ���̺귯�� ���
		//BFS�� ť �ڷᱸ�� Ȱ��
		Queue<ABC> q = new LinkedList<>();
		q.offer(new ABC(x,y));
		
		//ť�� �������� �ݺ�
		while(!q.isEmpty()){
			ABC node = q.poll();
			x = node.getX();
			y = node.getY();
			
			//���� ��ġ���� 4���� �������� ��ġ Ȯ��
			for(int i=0 ; i<4 ; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				//���� ��� ��� ����
				if(nx<0 || nx>=n || ny<0 || ny>= m) continue;
				//������ �ִ°��(0�ΰ��) ����
				if(graph[nx][ny]==0) continue;
				//�ش� ��� ó�� �湮�ÿ��� �ִܰŸ� ���
				if(graph[nx][ny]==1) {
					graph[nx][ny] = graph[x][y]+1;
					q.offer(new ABC(nx, ny));
				}
			}
		}
		//���� ���� ������ �Ʒ�����(��������)���� �ִܰŸ� ��ȯ
		return graph[n-1][m-1]; 
	}

}
