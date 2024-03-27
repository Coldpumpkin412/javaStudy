package Algorithm_ShortestPath;
import java.util.*;

/*
 * 플로이드 워셜 알고리즘
 * 모든지점에서 다른 모든지점까지의 최단경로를 구해야하는 경우 사용(2차원 리스트 활용)
 * 시간복잡도 : O(N^3)이기 때문에 노드의 개수가 적을 때 사용해야 활용적이다.
 * 각 단계에서 해당노드를 거쳐가는 경우에 대해 생각하여 알고리즘 구성
 * 점화식으로 표현한다면
 * Dab = min(Dab, Dak+Dkb) //Dab:a부터b까지 가는 거리
 * 
 * 즉, a부터b까지 직접 가는 거리보다 k를 통해 가는것이 더 거리가 짧다면 갱신
 */

public class Floyd_Warshall {
	public static final int INF = (int)1e9; //무한을 의미하는 값 10억
	
	//노드의 개수 n(최대 500), 간선의 개수 m
	public static int n,m;
	
	//2차원 배열(그래프 표현)
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		//최단거리 테이블 모두 "무한"으로 초기화(다익스트라와 차이점)
		for(int i=0 ; i<501 ; i++) Arrays.fill(graph[i], INF);
		
		//자기자신에서 자기자신으로 가는 비용(거리) : 0으로 초기화
		for(int a=1 ; a<=n ; a++) {
			for(int b=1 ; b<=n ; b++) {
				if(a == b) graph[a][b] = 0;
			}
		}
		
		//각 간선에 대한 정보 입력 받은 후 그 값으로 갱신
		for(int i=0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			//a에서 b로가는 비용 : c
			graph[a][b] = c;
		}
		
		//점화식에 따라 플로이드 워셜 알고리즘 수행
		for(int k=1 ; k<=n ; k++) {
			for(int a=1 ; a<=n ; a++) {
				for(int b=1 ; b<=n ; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
				}
			}
		}
		
		//결과 출력
		for(int a=1 ; a<=n ; a++) {
			for(int b=1 ; b<=n ; b++) {
				//도달할 수 없는 경우 "INFINITY" 출력
				if(graph[a][b] == INF) System.out.println("INFINITY");
				else System.out.println(graph[a][b] + " "); //도달할 수 있다면 거리 출력
			}
			System.out.println();
		}
	}

}
