package Algorithm_ShortestPath;
import java.util.*;

/*
 * 다익스트라 알고리즘(개선된 구현방법)
 * 우선순위 큐를 활용하여 구현 : 우선순위가 가장 높은 데이터를 가장 먼저 삭제
 * 내부적으로 최소힙, 최대힙을 이용한다. 최단경로 알고리즘에서는 값이 낮은 데이터가 먼저 삭제되는 최소힙 사용
 * 시간복잡도 또한 굉장히 줄어든다. (최악의 경우 O(ElogV))
 * (순차탐색)
 */

//distance가 낮은값이 더 높은 우선순위를 가질 수 있도록 Comparable 인터페이스를 정의
//아래 오버라이드 참고
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
	
	//거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Node_q other) {
		if(this.distance < other.distance) {
			return -1;
		}
		
		return 1;
	}	
}
public class Dijkstra_PriorityQueue {
	public static final int INF = (int)1e9; //무한의 의미 10억
	//노드의 개수 n(최대 100,000), 간선의 개수 m, 시작 노드번호 start
	public static int n, m, start;
	
	//각 노드에 연결돼있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	//각 노드별 최단거리 테이블
	public static int[] d = new int[100001];
	
	public static void Dijkstra(int start) {
		PriorityQueue<Node_q> pq = new PriorityQueue<>();
		
		//시작노드로 가는 최단경로: 0, 큐에 삽입
		pq.offer(new Node_q(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) { //큐에 값이 존재한다면
			//최단거리가 가장 짧은 노드의 정보 꺼내기
			Node_q node = pq.poll();
			int dist = node.getDistance(); //현재 노드까지의 비용(거리)
			int now = node.getIndex(); //현재 노드
			
			//현재 노드가 처리된 적이 있다면 무시(따로 visited배열 사용X)
			if(d[now] < dist) continue;
			//현재 노드와 연결된 인접노드들 확인
			for(int i=0 ; i<graph.get(now).size() ; i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				//현재 노드를 통해 다른 노드로 이동하는 거리가 더 짧다면
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
		
		//그래프 초기화
		for(int i=0 ; i<=n ; i++) graph.add(new ArrayList<Node>());
		
		//간선 정보 입력
		for(int i=0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			//a번 노드에서 b번 노드로 가는 비용 : c
			
			graph.get(a).add(new Node(b,c));
		}
		
		//최단거리 테이블 무한으로 초기화
		Arrays.fill(d, INF);
		
		//다익스트라 알고리즘 수행
		Dijkstra(start);
		
		//모든 노드로 가는 최단 거리 출력 (도달할 수 없는 경우 "INFINITY" 출력)
		for(int i=1 ; i<=n ; i++) {
			if(d[i] == INF) System.out.println("INFINITY");
			else System.out.println(d[i]);
		}
	}

}
