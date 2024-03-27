package Programmers;
import java.util.*;

//���α׷��ӽ� īī�� ũ���� �����̱⹮��
public class kakao_crane {
	public int solution(int[][]board, int[]moves) {
		int answer=0; //���� ������ ���� ���� Ƚ��
		
		//�Ű��� ������ �Űܴ��� list ����
		List<Integer> doll = new ArrayList<>();
		
		//�Ű����� �� ���� ���ڿ� ���ٸ� ���� �� answer++
		for(int i : moves) {
			boolean check = true;
			for(int j=0 ; j<board.length ; j++) {
				if(board[j][i-1] != 0 && check) {
					check = false;
					doll.add(board[j][i-1]);
					board[j][i-1] = 0; //������ �Ű����� �ش���ġ�� 0�̵�
				}
			}
			//������ ����Ʈ�� �ű� �� �ΰ��� ���ӵǴ��� Ȯ��
			if(doll.size()>=2) {
				if(doll.get(doll.size()-1) == doll.get(doll.size()-2)) {
					//���� ������ ���ӵȴٸ� ���������� �ϳ��� ���� �� Ƚ��++
					doll.remove(doll.size()-1); 
					doll.remove(doll.size()-1);
					
					answer++;
				}
			}
		}
		//�� �ű� �� result*2 (�ѹ� ���������� �ΰ� �� �����Ƿ�)
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
