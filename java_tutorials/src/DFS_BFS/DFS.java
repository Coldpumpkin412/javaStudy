package DFS_BFS;
import java.util.*;

public class DFS {
	public static boolean[] visited = new boolean[9]; //방문처리
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		//DFS(깊이 우선 탐색) 방식 표현
		
		//그래프 초기화
		for(int i=0 ; i<9 ; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);
        
        //시작 노드가 '1'일때 노드 탐색 순서
        DFS(1); //1 2 7 6 8 3 4 5 결과값 출력
	}
	
	//DFS함수
	public static void DFS(int x) {
		//현재노드 방문처리
		visited[x] = true;
		System.out.print(x + " ");
		
		//현재 노드와 연결된 다른 노드 재귀적 방문
		for(int i=0 ; i<graph.get(x).size() ; i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) DFS(y);
		}
	}
}
