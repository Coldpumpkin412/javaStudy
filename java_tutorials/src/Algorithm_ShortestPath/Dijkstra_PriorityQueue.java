package Algorithm_ShortestPath;
import java.util.*;

/*
 * ���ͽ�Ʈ�� �˰���(������ �������)
 * �켱���� ť�� Ȱ���Ͽ� ���� : �켱������ ���� ���� �����͸� ���� ���� ����
 * ���������� �ּ���, �ִ����� �̿��Ѵ�. �ִܰ�� �˰��򿡼��� ���� ���� �����Ͱ� ���� �����Ǵ� �ּ��� ���
 * �ð����⵵ ���� ������ �پ���. (�־��� ��� O(ElogV))
 * (����Ž��)
 */

//distance�� �������� �� ���� �켱������ ���� �� �ֵ��� Comparable �������̽��� ����
//�Ʒ� �������̵� ����
class Node_q implements Comparable<Node_q>{
	private int index;
	private int distance;
	
	public Node_q(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	public int getIndex() {
		return this.index;
	}
	public int getDistance() {
		return this.distance;
	}
	
	//�Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
	@Override
	public int compareTo(Node_q other) {
		if(this.distance < other.distance) {
			return -1;
		}
		
		return 1;
	}	
}
public class Dijkstra_PriorityQueue {
	public static final int INF = (int)1e9; //������ �ǹ� 10��
	//����� ���� n(�ִ� 100,000), ������ ���� m, ���� ����ȣ start
	public static int n, m, start;
	
	//�� ��忡 ������ִ� ��忡 ���� ������ ��� �迭
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	//�� ��庰 �ִܰŸ� ���̺�
	public static int[] d = new int[100001];
	
	public static void Dijkstra(int start) {
		PriorityQueue<Node_q> pq = new PriorityQueue<>();
		
		//���۳��� ���� �ִܰ��: 0, ť�� ����
		pq.offer(new Node_q(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) { //ť�� ���� �����Ѵٸ�
			//�ִܰŸ��� ���� ª�� ����� ���� ������
			Node_q node = pq.poll();
			int dist = node.getDistance(); //���� �������� ���(�Ÿ�)
			int now = node.getIndex(); //���� ���
			
			//���� ��尡 ó���� ���� �ִٸ� ����(���� visited�迭 ���X)
			if(d[now] < dist) continue;
			//���� ���� ����� �������� Ȯ��
			for(int i=0 ; i<graph.get(now).size() ; i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				//���� ��带 ���� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�ٸ�
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node_q(graph.get(now).get(i).getIndex(), cost));
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
