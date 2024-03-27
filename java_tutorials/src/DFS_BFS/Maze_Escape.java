package DFS_BFS;
import java.util.*;

class ABC {
	private int x;
	private int y;
	
	public ABC(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}

public class Maze_Escape {
	
	public static int n, m; //n x m 크기의 미로
	public static int[][] graph = new int[200][200]; //미로 표현 그래프
	
	//이동방향 4가지 정의
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		// BFS 활용하여 미로 탈출 문제 해결
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine(); //버퍼지우기
		
		//2차원 리스트 맵 정보 입력받기
		for(int i=0 ; i<n ; i++) {
			String str = sc.nextLine();
			for(int j=0 ; j<m ; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		//BFS수행결과 출력
		System.out.println(BFS(0,0));
	}
	
	public static int BFS(int x, int y) {
		//큐 구현을 위해 큐 라이브러리 사용
		//BFS는 큐 자료구조 활용
		Queue<ABC> q = new LinkedList<>();
		q.offer(new ABC(x,y));
		
		//큐가 빌때까지 반복
		while(!q.isEmpty()){
			ABC node = q.poll();
			x = node.getX();
			y = node.getY();
			
			//현재 위치에서 4가지 방향으로 위치 확인
			for(int i=0 ; i<4 ; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				//맵을 벗어난 경우 무시
				if(nx<0 || nx>=n || ny<0 || ny>= m) continue;
				//괴물이 있는경우(0인경우) 무시
				if(graph[nx][ny]==0) continue;
				//해당 노드 처음 방문시에만 최단거리 기록
				if(graph[nx][ny]==1) {
					graph[nx][ny] = graph[x][y]+1;
					q.offer(new ABC(nx, ny));
				}
			}
		}
		//맵의 가장 오른쪽 아래지점(도착지점)까지 최단거리 반환
		return graph[n-1][m-1]; 
	}

}
