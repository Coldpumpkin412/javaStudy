package Programmers;
import java.util.*;

//프로그래머스 카카오 크레인 인형뽑기문제
public class kakao_crane {
	public int solution(int[][]board, int[]moves) {
		int answer=0; //같은 인형이 만나 터진 횟수
		
		//옮겨진 인형을 옮겨닮을 list 구현
		List<Integer> doll = new ArrayList<>();
		
		//옮겨졌을 때 앞의 숫자와 같다면 삭제 후 answer++
		for(int i : moves) {
			boolean check = true;
			for(int j=0 ; j<board.length ; j++) {
				if(board[j][i-1] != 0 && check) {
					check = false;
					doll.add(board[j][i-1]);
					board[j][i-1] = 0; //인형이 옮겨지면 해당위치는 0이됨
				}
			}
			//인형을 리스트로 옮긴 뒤 두개가 연속되는지 확인
			if(doll.size()>=2) {
				if(doll.get(doll.size()-1) == doll.get(doll.size()-2)) {
					//같은 인형이 연속된다면 위에서부터 하나씩 제거 후 횟수++
					doll.remove(doll.size()-1); 
					doll.remove(doll.size()-1);
					
					answer++;
				}
			}
		}
		//다 옮긴 후 result*2 (한번 터질때마다 두개 씩 터지므로)
		return answer*2;
	}

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},
						 {0,0,1,0,3},
						 {0,2,5,0,1},
						 {4,2,4,4,2},
						 {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		kakao_crane sol = new kakao_crane();
		
		System.out.print(sol.solution(board, moves));
	}

}
