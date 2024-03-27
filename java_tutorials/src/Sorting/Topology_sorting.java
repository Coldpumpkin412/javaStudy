package Sorting;
import java.util.*;

/*
 * �������� : "����Ŭ�� ���� ����׷���"(DAG)�� ��� ������ ���⼺�� �Ž����� �ʵ��� ������� �����ϴ� ��
 * ������ ������ �ִ� �Ϸ��� �۾��� ���ʴ�� �����ؾ� �� �� ����ϴ� �˰��� (ex.���������� ����� �н����� ����)
 * -�������� : Ư������ "������" ������ ����
 * ���� ������ ��� Ȯ���ϴ� ���鿡�� �ð����⵵ : O(V+E)
 * 
 * �������
 * 1. ���������� 0�� ��带 ť�� �ִ´�.
 * 2. ť�� �� �� ���� ������ ������ �ݺ��Ѵ�.
 *    1) ť���� ���Ҹ� ���� �ش� ��忡�� ����ϴ� ������ �׷������� ����
 *    2) ���Ӱ� ���������� 0�� �� ��带 ť�� �ִ´�.
 * -��� ���Ҹ� �湮�ϱ� ���� ť�� ��ٸ� ����Ŭ�� �����Ѵ�.
 * �� ������ �����ϸ鼭 �� ��尡 'ť'�� ���� ���� ��, ť���� �������� ����� ������� ����ϸ�
 * �̰��� �ٷ� ���������� ������ ����� �ȴ�. (���������� ����� ���������� �� �� �ִ�) 
 * 
 * ������ Ȱ���� DFS�� �̿��� ���������� ������ ���� �ִ�
 * 
 */
public class Topology_sorting {
	//����� ����(V)�� ����(Union ����)�� ����(E)
    //����� ������ �ִ� 100,000����� ����
	//��� ��忡 ���� ���������� 0���� �ʱ�ȭ
    public static int v, e;
    public static int[] indegree = new int[100001];
    //�� ��忡 ����� ���������� ��� ���Ḯ��Ʈ �ʱ�ȭ
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
    //�������� �Լ�
    public static void topologySort() {
    	ArrayList<Integer> result = new ArrayList<>(); //�˰��� ������ ��� ����Ʈ
    	Queue<Integer> q = new LinkedList<>(); //ť ���
    	
    	//ó�� ���۽� ���������� 0�� ��带 ť�� ����
    	for(int i=1 ; i<=v ; i++) {
    		if(indegree[i] == 0) q.offer(i);
    	}
    	
    	//ť�� �� ������ �ݺ�
    	while(!q.isEmpty()) {
    		//ť���� ���� ������
    		int now = q.poll();
    		result.add(now);
    		
    		//�ش� ���ҿ� ����� ������ ������������ 1 ����
    		for(int i=0 ; i<graph.get(now).size() ; i++) {
    			indegree[graph.get(now).get(i)] -= 1;
    			
    			//���Ӱ� ���������� 0�� �Ǵ� ��带 ť�� ����
    			if(indegree[graph.get(now).get(i)] == 0) q.offer(graph.get(now).get(i));
    		}
    	}
    	
    	//�������� ������ ���
    	for(int i=0 ; i<result.size() ; i++) {
    		System.out.print(result.get(i) + " ");
    	}
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		//�׷��� �ʱ�ȭ
		for(int i=0 ; i<=v ; i++) graph.add(new ArrayList<Integer>());
		
		//���� �׷����� ��� ���� ���� �Է�
		for(int i=0 ; i<e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b); //���� A���� B�� �̵� ����
			
			//�������� 1����
			indegree[b]++;
		}
	}

}
