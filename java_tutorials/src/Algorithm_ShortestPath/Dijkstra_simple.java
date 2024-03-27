package Algorithm_ShortestPath;
import java.util.*;

/*
 * 다익스트라 알고리즘(간단한 구현방법)
 * 단계마다 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택하기 위해
 * 매 단계마다 1차원 테이블의 모든 원소를 확인한다.
 * (순차탐색)
 */

/*
 * 총 O(V)번에 걸쳐 최단거리가 가장 짧은 노드를 매번 선형탐색 (전체시간복잡도가 O(V^2)이 된다) 
 * 노드의 개수가 특정 개수 이상 넘어간다면 시간이 굉장히 많이 소요된다.
 */

/*
 * 자바에서는 튜플, 페어와 같은 라이브러리 제공X
 * 특정노드 번호까지의 거리가 얼마인지 기록할 수 있는 클래스를 정의
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
	
	public static final int INF = (int)1e9; //무한을 의미하는 값으로 10억 설정
	
	//노드의 개수 n(최대 100,000), 간선의 개수 m, 시작 노드번호 start
	public static int n, m, start;
	
	//각 노드에 연결돼있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	//방문체크 배열
	public static boolean[] visited = new boolean[100001];
	
	//각 노드별 최단거리 테이블
	public static int[] d = new int[100001];
	
	//방문하지 않은 노드 중 최단거리가 가장 짧은 노드의 번호 반환
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0; //노드의 인덱스
		
		for(int i=1 ; i<=n ; i++) {
			if(d[i]<min_value && !visited[i]) {
				min_value = d[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static void Dijkstra(int start) {
		//시작 노드 초기화
		d[start] = 0;
		visited[start] = true;
		for(int j=0 ; j<graph.get(start).size() ; j++) {
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		}
		
		//시작 노드 제외한 n-1개의 노드에 대해 반복
		for(int i=0 ; i<n ; i++) {
			//현재 최단 거리가 가장 짧은 노드를 꺼낸 후 방문처리
			int now = getSmallestNode();
			visited[now] = true;
			
			//현재 노드와 연결된 다른 노드 확인
			for(int j=0 ; j<graph.get(now).size() ; j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				//현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은경우
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
