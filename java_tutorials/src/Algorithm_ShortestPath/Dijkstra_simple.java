package Algorithm_ShortestPath;
import java.util.*;

/*
 * ���ͽ�Ʈ�� �˰���(������ �������)
 * �ܰ踶�� �湮���� ���� ��� �߿��� �ִ� �Ÿ��� ���� ª�� ��带 �����ϱ� ����
 * �� �ܰ踶�� 1���� ���̺��� ��� ���Ҹ� Ȯ���Ѵ�.
 * (����Ž��)
 */

/*
 * �� O(V)���� ���� �ִܰŸ��� ���� ª�� ��带 �Ź� ����Ž�� (��ü�ð����⵵�� O(V^2)�� �ȴ�) 
 * ����� ������ Ư�� ���� �̻� �Ѿ�ٸ� �ð��� ������ ���� �ҿ�ȴ�.
 */

/*
 * �ڹٿ����� Ʃ��, ���� ���� ���̺귯�� ����X
 * Ư����� ��ȣ������ �Ÿ��� ������ ����� �� �ִ� Ŭ������ ����
 */
class Node{
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	public int getIndex() {
		return this.index;
	}
	public int getDistance() {
		return this.distance;
	}
}
public class Dijkstra_simple {
	
	public static final int INF = (int)1e9; //������ �ǹ��ϴ� ������ 10�� ����
	
	//����� ���� n(�ִ� 100,000), ������ ���� m, ���� ����ȣ start
	public static int n, m, start;
	
	//�� ��忡 ������ִ� ��忡 ���� ������ ��� �迭
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	//�湮üũ �迭
	public static boolean[] visited = new boolean[100001];
	
	//�� ��庰 �ִܰŸ� ���̺�
	public static int[] d = new int[100001];
	
	//�湮���� ���� ��� �� �ִܰŸ��� ���� ª�� ����� ��ȣ ��ȯ
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0; //����� �ε���
		
		for(int i=1 ; i<=n ; i++) {
			if(d[i]<min_value && !visited[i]) {
				min_value = d[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static void Dijkstra(int start) {
		//���� ��� �ʱ�ȭ
		d[start] = 0;
		visited[start] = true;
		for(int j=0 ; j<graph.get(start).size() ; j++) {
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		}
		
		//���� ��� ������ n-1���� ��忡 ���� �ݺ�
		for(int i=0 ; i<n ; i++) {
			//���� �ִ� �Ÿ��� ���� ª�� ��带 ���� �� �湮ó��
			int now = getSmallestNode();
			visited[now] = true;
			
			//���� ���� ����� �ٸ� ��� Ȯ��
			for(int j=0 ; j<graph.get(now).size() ; j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				//���� ��带 ���ļ� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�����
				if(cost<d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		//�׷��� �ʱ�ȭ
		for(int i=0 ; i<=n ; i++) graph.add(new ArrayList<Node>());
		
		//���� ���� �Է�
		for(int i=0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			//a�� ��忡�� b�� ���� ���� ��� : c
			
			graph.get(a).add(new Node(b,c));
		}
		
		//�ִܰŸ� ���̺� �������� �ʱ�ȭ
		Arrays.fill(d, INF);
		
		//���ͽ�Ʈ�� �˰��� ����
		Dijkstra(start);
		
		//��� ���� ���� �ִ� �Ÿ� ��� (������ �� ���� ��� "INFINITY" ���)
		for(int i=1 ; i<=n ; i++) {
			if(d[i] == INF) System.out.println("INFINITY");
			else System.out.println(d[i]);
		}
	}

}
