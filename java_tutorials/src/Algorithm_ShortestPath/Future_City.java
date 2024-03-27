package Algorithm_ShortestPath;
import java.util.*;

/*
 * �̷����� ����
 * ��� A�� 1��ȸ�翡�� ����� K��ȸ�縦 �湮 �� X�� ȸ��� ���°��� ��ǥ
 * ���ð� �̵��� ������̸� �� ���(�Ÿ�)�� 1�̶�� ������ ��
 * �ּ� �ð��� ����Ͻÿ�.
 * ���� X�� ȸ�翡 ������ �� ���ٸ� -1�� ����Ѵ�
 * 
 * ȸ���� ����N, ����� ����M, (1 <= N,M <= 100)
 */

public class Future_City {
	/*
	 * �������� �ִܰŸ� �����̹Ƿ� �ִܰŸ� �˰��� �̿�
	 * �� ��, N�� ũ�Ⱑ �ִ� 100�̹Ƿ� �÷��̵���� �˰����� �̿��ϸ� ȿ�������� �ذᰡ��
	 * �÷��̵� ���� �˰��� ���� �� 1�����~K����� �ִܰŸ� + K�����~X����� �ִܰŸ�
	 */
	
	public static final int INF = (int)1e9; //������ �ǹ��ϴ� �� 10��
	
	//����� ���� n, ������ ���� m, ���İ� ��� k, ���� ������ ��� x
	public static int n,m,k,x;
	
	//2���� �迭
	public static int[][] graph = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		//�ִܰŸ� ���̺� �������� �ʱ�ȭ
		for(int i=0 ; i<101 ; i++) Arrays.fill(graph[i], INF);
		
		//�ڱ��ڽſ��� ���� ��� 0���� �ʱ�ȭ
		for(int a=1 ; a<= n ; a++) {
			for(int b=1 ; b<=n ; b++) {
				if(a==b) graph[a][b] = 0;
			}
		}
		
		//�� ������ ���� ���� �Է¹��� �� �� ������ �ʱ�ȭ
		for(int i=0 ; i<m ; i++) {
			//A��B ���ø� ���� ����� 1
			int a = sc.nextInt();
			int b = sc.nextInt();
			//���ô� ����� �̵� ����
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		k = sc.nextInt();
		x = sc.nextInt();
		
		//��ȭ�Ŀ� ���� �÷��̵� ���� �˰��� ����
		for(int k=1 ; k<=n ; k++) {
			for(int a=1 ; a<=n ; a++) {
				for(int b=1 ; b<=n ; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
				}
			}
		}
		
		//����� ��� ���
		int distance = graph[1][k] + graph[k][x];
		
		if(distance>=INF) System.out.println(-1);
		else System.out.println(distance);
		
	}
}
