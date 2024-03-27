package Programmers;
import java.util.*;
import java.math.*;

class Node{
	int row;
	int col;
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class practice {	
	//카피맵
	static int[][] copy;
	
	//방향변수
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	//방문처리 배열
	static boolean[][] visited;
	
	static int N, M;
	
	static int oil;
	
	public void BFS(int row, int col) {
		
		//BFS에 활용할 큐 선언
		Queue<Node> queue = new LinkedList<>();
		
		//방문처리 및 초기값 넣어주기
		visited[row][col] = true;
		queue.offer(new Node(row, col));
		
		//큐가 빌 때까지
		while(!queue.isEmpty()) {
			//새로운 칸이 들어올 때마다 석유량 증가
			oil++;
			
			//현재노드
			Node now = queue.poll();
			
			//4가지 방향에 대해
			for(int i=0 ; i<4 ; i++) {
				int next_row = now.row + dx[i];
				int next_col = now.col + dy[i];
				
				//맵을 벗어나거나 방문한적이 있거나 0이면
				if(next_row<0 || next_row>=N || next_col<0 || next_col>=M 
				   || visited[next_row][next_col] || copy[next_row][next_col]==0) {
					continue;
				}
				
				//맵을 벗어나지 않고 방문한적 없다면 큐에 넣어주고 석유량 증가
				queue.offer(new Node(next_row, next_col));	
				
				//방문처리
				visited[next_row][next_col] = true;
			}
		}
		
	}
	
	public int solution(int[][] land) {
		int answer = 0;
		
		//땅의 세로길이 N, 가로길이 M 선언
		N = land.length;
		M = land[0].length;
		
		//카피맵 선언 및 복사
		copy = new int[N][M];
		copy = land;
		
		//땅의 0번째 열부터 끝 열까지
		for(int i=0 ; i<M ; i++) {
			//시추관 위치가 바뀔때마다 석유량 0으로 초기화
			oil = 0;
			
			//방문처리배열 선언
			visited = new boolean[land.length][land[0].length];
			
			
			//행을 하나씩 내려가며
			for(int j=0 ; j<N ; j++) {
				//1을 만나고 방문한적이 없는 경우
				if(land[j][i]==1 && !visited[j][i]) {
					//BFS
					BFS(j, i);
				}
				
				//최댓값으로 정답 갱신
				answer = Math.max(answer, oil);
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, 
		                {0, 0, 0, 0, 1, 1, 0, 0}, 
		                {1, 1, 0, 0, 0, 1, 1, 0}, 
		                {1, 1, 1, 0, 0, 0, 0, 0}, 
		                {1, 1, 1, 0, 0, 0, 1, 1}};
		
		practice sol = new practice();
		System.out.println(sol.solution(land));
	}
}
