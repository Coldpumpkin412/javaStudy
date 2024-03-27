package Disjoint;
import java.util.*;

/*
 * 신장트리 : 
 * 원본 그래프에 존재하는 간선을 모두 활용하지않고, 일부만 활용하여 모든 노드가 포함되는 그래프
 * 이 때, 사이클이 존재해서는 안된다.
 * 
 * 크루스칼 알고리즘 : 최소신장트리 알고리즘 중 하나로 그리디 알고리즘으로 분류
 * 가능한 한 최소한의 비용으로 신장트리를 찾는 알고리즘.
 * -최소신장트리는 일종의 트리자료구조이므로, 최소신장트리에 포함되는 간선의 개수는 '노드의 개수-1' 이다.
 * -간선의 개수가 E개일 때 시간복잡도 : O(ElogE) **N개의 데이터를 정렬할 때 시간복잡도가 O(NlogN)이기 떄문
 * 
 * 구현방법
 * 1.간선 데이터를 비용에 따라 오름차순 정렬
 * 2.간선을 하나씩 확인하여 사이클 발생여부 확인
 *   이 때, 사이클이 발생하지 않는다면 최소신장트리에 포함
 *         사이클이 발생한다면 최소신장트리에 포함X
 * 3.모든 간선에 대해 반복
 */

class Edge implements Comparable<Edge>{
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB; 
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	//거리(비용)가 짧은게 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Edge other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class Algorithm_Kruskal {
    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기
    
    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]); //경로압축을 통해 효율성 높이기
    }
    
    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
        }
        
        //간선을 비용순으로 정렬
        Collections.sort(edges);
        
        //간선을 하나씩 확인
        for(int i=0 ; i<edges.size() ; i++) {
        	int cost = edges.get(i).getDistance();
        	int a = edges.get(i).getNodeA();
        	int b = edges.get(i).getNodeB();
        	
        	//사이클이 발생하지 않는 경우에 집합에 포함
        	if(findParent(a) != findParent(b)) {
        		unionParent(a,b);
        		result += cost; //총 비용 구하기
        	}
        }
        
        System.out.print(result);
	}

}
