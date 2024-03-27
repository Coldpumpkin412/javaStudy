package Algorithm_ShortestPath;
import java.util.*;

/*
 * �÷��̵� ���� �˰���
 * ����������� �ٸ� ������������� �ִܰ�θ� ���ؾ��ϴ� ��� ���(2���� ����Ʈ Ȱ��)
 * �ð����⵵ : O(N^3)�̱� ������ ����� ������ ���� �� ����ؾ� Ȱ�����̴�.
 * �� �ܰ迡�� �ش��带 ���İ��� ��쿡 ���� �����Ͽ� �˰��� ����
 * ��ȭ������ ǥ���Ѵٸ�
 * Dab = min(Dab, Dak+Dkb) //Dab:a����b���� ���� �Ÿ�
 * 
 * ��, a����b���� ���� ���� �Ÿ����� k�� ���� ���°��� �� �Ÿ��� ª�ٸ� ����
 */

public class Floyd_Warshall {
	public static final int INF = (int)1e9; //������ �ǹ��ϴ� �� 10��
	
	//����� ���� n(�ִ� 500), ������ ���� m
	public static int n,m;
	
	//2���� �迭(�׷��� ǥ��)
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		//�ִܰŸ� ���̺� ��� "����"���� �ʱ�ȭ(���ͽ�Ʈ��� ������)
		for(int i=0 ; i<501 ; i++) Arrays.fill(graph[i], INF);
		
		//�ڱ��ڽſ��� �ڱ��ڽ����� ���� ���(�Ÿ�) : 0���� �ʱ�ȭ
		for(int a=1 ; a<=n ; a++) {
			for(int b=1 ; b<=n ; b++) {
				if(a == b) graph[a][b] = 0;
			}
		}
		
		//�� ������ ���� ���� �Է� ���� �� �� ������ ����
		for(int i=0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			//a���� b�ΰ��� ��� : c
			graph[a][b] = c;
		}
		
		//��ȭ�Ŀ� ���� �÷��̵� ���� �˰��� ����
		for(int k=1 ; k<=n ; k++) {
			for(int a=1 ; a<=n ; a++) {
				for(int b=1 ; b<=n ; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
				}
			}
		}
		
		//��� ���
		for(int a=1 ; a<=n ; a++) {
			for(int b=1 ; b<=n ; b++) {
				//������ �� ���� ��� "INFINITY" ���
				if(graph[a][b] == INF) System.out.println("INFINITY");
				else System.out.println(graph[a][b] + " "); //������ �� �ִٸ� �Ÿ� ���
			}
			System.out.println();
		}
	}

}
