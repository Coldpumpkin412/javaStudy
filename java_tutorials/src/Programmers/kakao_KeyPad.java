package Programmers;
import java.util.*;

//프로그래머스 키패드 누르기 문제
public class kakao_KeyPad {
	//멤버변수
	Position left;
	Position right;
	Position numPos; 	//숫자 위치 담을 변수
	
	public String solution(int[] numbers, String hand) {
		String answer = "";
		/*키패드는 배열로 관리
		 * 	 	0		1		2
		 *  0	1		2		3
		 *  1	4		5		6
		 *  2	7		8		9
		 *  3	L(*)	0		R(#)
		 */
		
		//1. 왼손 오른손 위치 초기화
		left = new Position(3,0);
		right = new Position(3,2);
		
		//numbers배열에서 하나씩 꺼내오기
		for(int num : numbers) {
			//2. 숫자를 누를 손가락 정하기
			numPos = new Position((num-1)/3, (num-1)%3); //숫자의 위치 배열로 확인
			if(num == 0) numPos = new Position(3,1); //0일때만 위치 예외
			
			String finger = numPos.getFinger(hand);
			
			//3. 정해진 손가락을 answer에 담고 손가락 위치 이동
			answer += finger;
			if(finger.equals("L")) left = numPos; //왼손으로 눌렀으면 해당 숫자의 위치가 왼손의 위치
			else right = numPos;
		}
		
		
		return answer;
	}
	
	class Position{
		int row;
		int col;
		
		//생성자
		Position(int row, int col){
			//초기화
			this.row = row;
			this.col = col;
		}
		public String getFinger(String hand) {
			//초기값으로 주 손을 넣기, 오른손잡이면 R, 아니면 L
			String finger = hand.equals("right") ? "R" : "L";
			
			//col이 0이면 무조건 왼손, 아니면 오른손
			if(this.col == 0) finger = "L";
			else if(this.col == 2) finger = "R";
			else { //1번 열이면 거리 계산 후 정해야함
				int leftD = left.getDistance(this); //해당 숫자부터 왼손까지의 거리
				int rightD = right.getDistance(this); //해당 숫자부터 오른손까지의 거리
				
				if(leftD<rightD) finger = "L";
				else if(rightD<leftD) finger = "R";
			}
			return finger; //위에서 leftD와 rightD가 같다면 본인의 주손가락을 리턴
		}
		
		public int getDistance(Position p) {
			return Math.abs(this.row-p.row) + Math.abs(this.col-p.col);
		}
	}
	
	public static void main(String[] args) {
		kakao_KeyPad sol = new kakao_KeyPad();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(sol.solution(numbers, hand));

	}

}
