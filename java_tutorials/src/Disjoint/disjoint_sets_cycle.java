package Disjoint;
import java.util.*;

/*
 * 서로소 집합을 활용하여 무방향 그래프 내에서 사이클 여부 판별 가능
 * (방향 그래프에서의 사이클 여부는 DFS활용)
 * 
 * 1.각 간선을 확인하여 두 노드의 루트노드를 확인(find 연산)
 *   이 때, 두 노드의 루트노드가 다르다면 union 연산 수행
 *   두 노드의 루트노드가 같다면 사이클이 발생한 것
 * 2.그래프에 포함 돼있는 모든 간선에 대해 1번과정을 반복
 */
public class disjoint_sets_cycle {
	//노드의 개수 v, 간선(Union 연산)의 개수 e
	//노드 개수는 최대 100,000개로 가정
	public static int v,e;
	public static int[] parent = new int[100001]; //부모테이블 초기화
	
	//특정 원소가 속한 집합 찾기
	public static int findParent(int x) {
		//루트노드가 아니라면 루트노드를 찾을 때까지 재귀적 호출
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]); //개선된부분(부모테이블 갱신 후 그 부분을 반환)
	}
	
	//두 원소가 속한 집합 합치기
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		//더 작은 번호의 노드가 부모노드
		if(a<b) parent[b] = a;
		else parent[a] = b;
	} 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		//부모 테이블에서 부모를 자기자신으로 초기화
		for(int i=1 ; i<=v ; i++) parent[i] = i;
		
		boolean cycle = true; //사이클 발생여부
		
		for(int i=0 ; i<e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			//사이클이 발생한 경우(루트노드가 같다면) 종료
			if(findParent(a) == findParent(b)) {
				cycle = true;
				break;
			}
			//사이클이 발생하지 않았다면 합집합 연산(union) 수행
			else {
				unionParent(a,b);
			}
		}
		
		if(cycle) System.out.println("사이클이 발생했습니다.");
		else System.out.println("사이클이 발생하지 않았습니다.");
	}

}
