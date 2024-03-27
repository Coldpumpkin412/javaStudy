package Disjoint;
import java.util.*;

/*
 * 서로소집합 자료구조
 * 경로압축(Path Compression)을 통한 서로소 자료구조 개선
 * 
 * find함수를 재귀적으로 호출한 뒤 부모테이블 값을 갱신한다.
 * 더욱 빠르게 루트노드에 접근할 수 있다
 */
public class disjoint_sets_PathCompression {
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
