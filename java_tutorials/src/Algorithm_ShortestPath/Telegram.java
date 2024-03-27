package Algorithm_ShortestPath;
import java.util.*;

/*
 * 전보문제
 * 도시의 개수 N(1~30000), 통로의 개수 M(1~200000), 메시지 보내는 도시C
 * 특정 도로 X에서 Y까지 메시지가 전달되는 시간 Z
 * C에서 보낸 메시지를 받는 도시의 총 개수와 총 걸리는 시간은?
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
	
	//거리가 짧은것이 우선순위를 가지도록 설정
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
	 * 한 도시에서 다른 도시까지의 최단거리 문제로 치환 가능
	 * N과 M의 범위가 크기 때문에 "우선순위 큐"를 활용한 다익스트라 알고리즘 활용
	 */
	public static final int INF = (int)1e9; //무한의 의미로 10억 설정
	
	//노드 개수 n, 간선 개수 m, 시작 노드 번호 start
	public static int n,m,start;
	
	//각 노드에 연결돼있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node_p>> graph = new ArrayList<ArrayList<Node_p>>();
	
	//최단거리 테이블
	public static int[] d = new int[30001];
	
	public static void Dijkstra(int start) {
		PriorityQueue<Node_p> pq = new PriorityQueue<>();
		
		//시작 노드로 가기 위한 최단경로 : 0, 우선순위 큐에 삽입
		pq.offer(new Node_p(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) { //큐가 비어있지않다면
			//가장 최단거리가 짧은 노드에 대한 정보 꺼내기
			Node_p node = pq.poll();
			int dist = node.getDistance(); //현재 노드까지의 비용
			int now = node.getIndex(); //현재 노드
			
			//현재 노드가 처리된적이 있다면 무시(방문처리 배열 필요없음)
			if(d[now] < dist) continue;
			
			//현재 노드와 연결된 노드들 확인
			for(int i=0 ; i<graph.get(now).size() ; i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				//현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은경우
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost; //갱신
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
		
		//그래프 초기화
		for(int i=0 ; i<=n ; i++) graph.add(new ArrayList<Node_p>());
		
		//간선정보 입력
		for(int i=0 ; i<m ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			//x번 도시에서 y번 노드로 가는 비용z
			graph.get(x).add(new Node_p(y,z));
		}
		
		//최단거리 테이블 무한으로 초기화
		Arrays.fill(d, INF);
		
		//우선순위 큐를 활용한 다익스트라 알고리즘 수행
		Dijkstra(start);
		
		int count = 0; //도달할 수 있는 노드의 수
		int maxDistance = 0; //도달할 수 있는 노드 중 가장 멀리있는 노드와의 최단거리
		
		for(int i=1 ; i<=n ; i++) {
			//도달 가능한 노드인 경우
			if(d[i] != INF) {
				count++;
				maxDistance = Math.max(maxDistance, d[i]);
			}
		}
		
		//시작노드를 제외해야 메시지를 받는 노드의 수가 나오므로 count-1
		System.out.println((count-1) + " " + maxDistance);
	}

}
