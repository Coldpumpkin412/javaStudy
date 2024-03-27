package DFS_BFS;
import java.util.*;
public class Adjacency_Matrix {
	//final로 선언하여 변경할 수 없는 상수값 INF 선언
	public static final int INF = 999999999;
	
	//2차원 리스트를 활용하여 인정행렬 표현
	public static int[][] graph ={
			{0, 7, 5},
			{7, 0, INF},
			{5, INF, 0}	
	};
	
	public static void main(String[] args) {
		//'인접행렬' : 2차원 배열을 이용하여 연결관계를 표현
		//그래프 출력
		for(int i=0 ; i<3 ; i++) {
			for(int j=0 ; j<3 ; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
		
	}
	


}
