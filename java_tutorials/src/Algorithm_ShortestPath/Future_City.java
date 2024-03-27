package Algorithm_ShortestPath;
import java.util.*;

/*
 * 미래도시 문제
 * 사람 A는 1번회사에서 출발해 K번회사를 방문 후 X번 회사로 가는것이 목표
 * 도시간 이동은 양방향이면 각 비용(거리)는 1이라고 가정할 때
 * 최소 시간을 계산하시오.
 * 만약 X번 회사에 도달할 수 없다면 -1을 출력한다
 * 
 * 회사의 개수N, 경로의 개수M, (1 <= N,M <= 100)
 */

public class Future_City {
	/*
	 * 전형적인 최단거리 문제이므로 최단거리 알고리즘 이용
	 * 이 때, N의 크기가 최대 100이므로 플로이드워셜 알고리즘을 이용하면 효율적으로 해결가능
	 * 플로이드 워셜 알고리즘 수행 후 1번노드~K번노드 최단거리 + K번노드~X번노드 최단거리
	 */
	
	public static final int INF = (int)1e9; //무한을 의미하는 값 10억
	
	//노드의 개수 n, 간선의 개수 m, 거쳐갈 노드 k, 최종 목적지 노드 x
	public static int n,m,k,x;
	
	//2차원 배열
	public static int[][] graph = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		//최단거리 테이블 무한으로 초기화
		for(int i=0 ; i<101 ; i++) Arrays.fill(graph[i], INF);
		
		//자기자신에게 가는 비용 0으로 초기화
		for(int a=1 ; a<= n ; a++) {
			for(int b=1 ; b<=n ; b++) {
				if(a==b) graph[a][b] = 0;
			}
		}
		
		//각 간선에 대한 정보 입력받은 후 그 값으로 초기화
		for(int i=0 ; i<m ; i++) {
			//A와B 도시를 가는 비용은 1
			int a = sc.nextInt();
			int b = sc.nextInt();
			//도시는 양방향 이동 가능
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		k = sc.nextInt();
		x = sc.nextInt();
		
		//점화식에 따라 플로이드 워셜 알고리즘 수행
		for(int k=1 ; k<=n ; k++) {
			for(int a=1 ; a<=n ; a++) {
				for(int b=1 ; b<=n ; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
				}
			}
		}
		
		//수행된 결과 출력
		int distance = graph[1][k] + graph[k][x];
		
		if(distance>=INF) System.out.println(-1);
		else System.out.println(distance);
		
	}
}
