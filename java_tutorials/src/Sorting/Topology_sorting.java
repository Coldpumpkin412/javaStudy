package Sorting;
import java.util.*;

/*
 * 위상정렬 : "사이클이 없는 방향그래프"(DAG)의 모든 노드들을 방향성에 거스르지 않도록 순서대로 나열하는 것
 * 순서가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 사용하는 알고리즘 (ex.선수과목을 고려한 학습순서 설정)
 * -진입차수 : 특정노드로 "들어오는" 간선의 개수
 * 노드와 간선을 모두 확인하는 측면에서 시간복잡도 : O(V+E)
 * 
 * 구현방법
 * 1. 진입차수가 0인 노드를 큐에 넣는다.
 * 2. 큐가 빌 때 까지 다음의 과정을 반복한다.
 *    1) 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거
 *    2) 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.
 * -모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재한다.
 * 위 과정을 수행하면서 각 노드가 '큐'에 들어온 순서 즉, 큐에서 빠져나간 노드의 순서대로 출력하면
 * 이것이 바로 위상정렬을 수행한 결과가 된다. (위상정렬의 답안은 여러가지가 될 수 있다) 
 * 
 * 스택을 활용한 DFS를 이용해 위상정렬을 수행할 수도 있다
 * 
 */
public class Topology_sorting {
	//노드의 개수(V)와 간선(Union 연산)의 개수(E)
    //노드의 개수는 최대 100,000개라고 가정
	//모든 노드에 대한 진입차수는 0으로 초기화
    public static int v, e;
    public static int[] indegree = new int[100001];
    //각 노드에 연결된 간선정보를 담는 연결리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
    //위상정렬 함수
    public static void topologySort() {
    	ArrayList<Integer> result = new ArrayList<>(); //알고리즘 수행결과 담는 리스트
    	Queue<Integer> q = new LinkedList<>(); //큐 사용
    	
    	//처음 시작시 진입차수가 0인 노드를 큐에 삽입
    	for(int i=1 ; i<=v ; i++) {
    		if(indegree[i] == 0) q.offer(i);
    	}
    	
    	//큐가 빌 때까지 반복
    	while(!q.isEmpty()) {
    		//큐에서 원소 꺼내기
    		int now = q.poll();
    		result.add(now);
    		
    		//해당 원소와 연결된 노드들의 진입차수에서 1 빼기
    		for(int i=0 ; i<graph.get(now).size() ; i++) {
    			indegree[graph.get(now).get(i)] -= 1;
    			
    			//새롭게 진입차수가 0이 되는 노드를 큐에 삽입
    			if(indegree[graph.get(now).get(i)] == 0) q.offer(graph.get(now).get(i));
    		}
    	}
    	
    	//위상정렬 수행결과 출력
    	for(int i=0 ; i<result.size() ; i++) {
    		System.out.print(result.get(i) + " ");
    	}
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		//그래프 초기화
		for(int i=0 ; i<=v ; i++) graph.add(new ArrayList<Integer>());
		
		//방향 그래프의 모든 간선 정보 입력
		for(int i=0 ; i<e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b); //정점 A에서 B로 이동 가능
			
			//진입차수 1증가
			indegree[b]++;
		}
	}

}
