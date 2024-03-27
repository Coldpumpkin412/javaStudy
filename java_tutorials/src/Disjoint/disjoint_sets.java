package Disjoint;
import java.util.*;

/*
 * 서로소집합 자료구조
 * 합집합 연산과 찾기 연산으로 이루어져있다.
 * 1.합집합 연산(Union) : 2개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산
 * 2.찾기 연산(Find) : 특정 원소가 속한 집합이 어떤 집합인지 알려주는 연산
 * 
 * 트리 자료구조를 이용하여 집합을 표현
 * 1.합집합 연산을 확인하여 서로 연결된 두 노드A,B를 확인한다.
 *   이 때, A와B의 루트 노드 A',B'를 각각 찾는다.
 *   이 후 A'을 B'의 부모노드로 설정한다(B'가 A'을 가리키도록 한다)
 *   *A'이 B'보다 더 작은 번호를 갖는다
 * 2.모든 합집합 연산을 처리할 때 까지 1번 과정을 반복한다.
 * 
 * 일렬로 나열되는 상황일 때 맨 끝 노드에서 부모노드로 갈때 까지 최대 O(V)의 시간이 소요될 수 있음
 * 결과적으로 노드의 개수가 V개이고 find혹은 union 연산이 M개일 때 전체 시간복잡도 : O(VM)
 * 비효율적이 될 수 있다. → 경로압축(Path Compression)기법을 통해 개선 가능
 */
public class disjoint_sets {
	//노드의 개수 v, 간선(Union 연산)의 개수 e
	//노드 개수는 최대 100,000개로 가정
	public static int v,e;
	public static int[] parent = new int[100001]; //부모테이블 초기화
	
	//특정 원소가 속한 집합 찾기
	public static int findParent(int x) {
		//루트노드가 아니라면 루트노드를 찾을 때까지 재귀적 호출
		if(x == parent[x]) return x;
		return findParent(parent[x]);
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
		
		//Union 연산 각각 수행
		for(int i=0 ; i<e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			unionParent(a,b);
		}
		
		//각 원소가 속한 집합 출력
		System.out.print("각 원소가 속한 집합: ");
		for(int i=1 ; i<=v ; i++) System.out.print(findParent(i) + " ");
		System.out.println();
		
		//부모 테이블 내용 출력
		System.out.print("부모 테이블: ");
		for(int i=1 ; i<=v ; i++) System.out.print(parent[i] + " ");
		System.out.println();
	}

}
