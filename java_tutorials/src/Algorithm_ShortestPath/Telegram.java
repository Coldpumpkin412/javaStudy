package Algorithm_ShortestPath;
import java.util.*;

/*
 * ��������
 * ������ ���� N(1~30000), ����� ���� M(1~200000), �޽��� ������ ����C
 * Ư�� ���� X���� Y���� �޽����� ���޵Ǵ� �ð� Z
 * C���� ���� �޽����� �޴� ������ �� ������ �� �ɸ��� �ð���?
 */

class Node_p implements Comparable<Node_p>{
	private int index;
	private int distance;
	
	public Node_p(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	public int getIndex() {
		return this.index;
	}
	public int getDistance() {
		return this.distance;
	}
	
	//�Ÿ��� ª������ �켱������ �������� ����
	@Override
	public int compareTo(Node_p other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}
public class Telegram {
	/*
	 * �� ���ÿ��� �ٸ� ���ñ����� �ִܰŸ� ������ ġȯ ����
	 * N�� M�� ������ ũ�� ������ "�켱���� ť"�� Ȱ���� ���ͽ�Ʈ�� �˰��� Ȱ��
	 */
	public static final int INF = (int)1e9; //������ �ǹ̷� 10�� ����
	
	//��� ���� n, ���� ���� m, ���� ��� ��ȣ start
	public static int n,m,start;
	
	//�� ��忡 ������ִ� ��忡 ���� ������ ��� �迭
	public static ArrayList<ArrayList<Node_p>> graph = new ArrayList<ArrayList<Node_p>>();
	
	//�ִܰŸ� ���̺�
	public static int[] d = new int[30001];
	
	public static void Dijkstra(int start) {
		PriorityQueue<Node_p> pq = new PriorityQueue<>();
		
		//���� ���� ���� ���� �ִܰ�� : 0, �켱���� ť�� ����
		pq.offer(new Node_p(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) { //ť�� ��������ʴٸ�
			//���� �ִܰŸ��� ª�� ��忡 ���� ���� ������
			Node_p node = pq.poll();
			int dist = node.getDistance(); //���� �������� ���
			int now = node.getIndex(); //���� ���
			
			//���� ��尡 ó�������� �ִٸ� ����(�湮ó�� �迭 �ʿ����)
			if(d[now] < dist) continue;
			
			//���� ���� ����� ���� Ȯ��
			for(int i=0 ; i<graph.get(now).size() ; i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				//���� ��带 ���� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�����
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost; //����
					pq.offer(new Node_p(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		//�׷��� �ʱ�ȭ
		for(int i=0 ; i<=n ; i++) graph.add(new ArrayList<Node_p>());
		
		//�������� �Է�
		for(int i=0 ; i<m ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			//x�� ���ÿ��� y�� ���� ���� ���z
			graph.get(x).add(new Node_p(y,z));
		}
		
		//�ִܰŸ� ���̺� �������� �ʱ�ȭ
		Arrays.fill(d, INF);
		
		//�켱���� ť�� Ȱ���� ���ͽ�Ʈ�� �˰��� ����
		Dijkstra(start);
		
		int count = 0; //������ �� �ִ� ����� ��
		int maxDistance = 0; //������ �� �ִ� ��� �� ���� �ָ��ִ� ������ �ִܰŸ�
		
		for(int i=1 ; i<=n ; i++) {
			//���� ������ ����� ���
			if(d[i] != INF) {
				count++;
				maxDistance = Math.max(maxDistance, d[i]);
			}
		}
		
		//���۳�带 �����ؾ� �޽����� �޴� ����� ���� �����Ƿ� count-1
		System.out.println((count-1) + " " + maxDistance);
	}

}
