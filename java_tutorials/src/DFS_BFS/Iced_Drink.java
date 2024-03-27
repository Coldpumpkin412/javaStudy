package DFS_BFS;
import java.util.*;

public class Iced_Drink {
	public static int n, m; //첫째 줄에 입력될 얼음틀의 세로길이와 가로길이
	public static int[][] graph = new int[1000][1000];
	
	public static void main(String[] args) {
		//DFS 활용하여 음료얼려먹기 문제 해결
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //얼음틀의 세로줄
		m = sc.nextInt(); //얼음틀의 가로줄 길이
		sc.nextLine(); //버퍼지우기
		
		//얼음틀의 형태를 2차원 리스트의 맵 정보로 입력
		for(int i=0 ; i<n ; i++) {
			String str = sc.nextLine();
			for(int j=0 ; j<m ; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		//모든 노드에 대해 음료 채우기
		int result = 0;
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(DFS(i,j)) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
	
	//DFS를 활용하여 특정 노드를 방문하고 연결된 모든 노드들을 방문
	public static boolean DFS(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=m) {
			return false; //주어진 범위를 벗어난 경우 즉시 종료
		}
		
		//현재 노드를 아직 방문하지 않았다면
		if(graph[x][y] == 0) {
			graph[x][y] = 1; //방문처리
			
			//현재 노드 기준 상,하,좌,우의 위치를 모두 재귀적으로 호출
			//DFS는 재귀함수 활용함
			DFS(x-1,y);
			DFS(x+1,y);
			DFS(x,y-1);
			DFS(x,y+1);
			return true;
		}
		
		return false;
	}
}
