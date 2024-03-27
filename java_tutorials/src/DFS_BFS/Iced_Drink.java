package DFS_BFS;
import java.util.*;

public class Iced_Drink {
	public static int n, m; //ù° �ٿ� �Էµ� ����Ʋ�� ���α��̿� ���α���
	public static int[][] graph = new int[1000][1000];
	
	public static void main(String[] args) {
		//DFS Ȱ���Ͽ� �������Ա� ���� �ذ�
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //����Ʋ�� ������
		m = sc.nextInt(); //����Ʋ�� ������ ����
		sc.nextLine(); //���������
		
		//����Ʋ�� ���¸� 2���� ����Ʈ�� �� ������ �Է�
		for(int i=0 ; i<n ; i++) {
			String str = sc.nextLine();
			for(int j=0 ; j<m ; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		//��� ��忡 ���� ���� ä���
		int result = 0;
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(DFS(i,j)) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
	
	//DFS�� Ȱ���Ͽ� Ư�� ��带 �湮�ϰ� ����� ��� ������ �湮
	public static boolean DFS(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=m) {
			return false; //�־��� ������ ��� ��� ��� ����
		}
		
		//���� ��带 ���� �湮���� �ʾҴٸ�
		if(graph[x][y] == 0) {
			graph[x][y] = 1; //�湮ó��
			
			//���� ��� ���� ��,��,��,���� ��ġ�� ��� ��������� ȣ��
			//DFS�� ����Լ� Ȱ����
			DFS(x-1,y);
			DFS(x+1,y);
			DFS(x,y-1);
			DFS(x,y+1);
			return true;
		}
		
		return false;
	}
}
