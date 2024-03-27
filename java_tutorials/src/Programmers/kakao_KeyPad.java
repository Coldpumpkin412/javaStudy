package Programmers;
import java.util.*;

//���α׷��ӽ� Ű�е� ������ ����
public class kakao_KeyPad {
	//�������
	Position left;
	Position right;
	Position numPos; 	//���� ��ġ ���� ����
	
	public String solution(int[] numbers, String hand) {
		String answer = "";
		/*Ű�е�� �迭�� ����
		 * 	 	0		1		2
		 *  0	1		2		3
		 *  1	4		5		6
		 *  2	7		8		9
		 *  3	L(*)	0		R(#)
		 */
		
		//1. �޼� ������ ��ġ �ʱ�ȭ
		left = new Position(3,0);
		right = new Position(3,2);
		
		//numbers�迭���� �ϳ��� ��������
		for(int num : numbers) {
			//2. ���ڸ� ���� �հ��� ���ϱ�
			numPos = new Position((num-1)/3, (num-1)%3); //������ ��ġ �迭�� Ȯ��
			if(num == 0) numPos = new Position(3,1); //0�϶��� ��ġ ����
			
			String finger = numPos.getFinger(hand);
			
			//3. ������ �հ����� answer�� ��� �հ��� ��ġ �̵�
			answer += finger;
			if(finger.equals("L")) left = numPos; //�޼����� �������� �ش� ������ ��ġ�� �޼��� ��ġ
			else right = numPos;
		}
		
		
		return answer;
	}
	
	class Position{
		int row;
		int col;
		
		//������
		Position(int row, int col){
			//�ʱ�ȭ
			this.row = row;
			this.col = col;
		}
		public String getFinger(String hand) {
			//�ʱⰪ���� �� ���� �ֱ�, ���������̸� R, �ƴϸ� L
			String finger = hand.equals("right") ? "R" : "L";
			
			//col�� 0�̸� ������ �޼�, �ƴϸ� ������
			if(this.col == 0) finger = "L";
			else if(this.col == 2) finger = "R";
			else { //1�� ���̸� �Ÿ� ��� �� ���ؾ���
				int leftD = left.getDistance(this); //�ش� ���ں��� �޼ձ����� �Ÿ�
				int rightD = right.getDistance(this); //�ش� ���ں��� �����ձ����� �Ÿ�
				
				if(leftD<rightD) finger = "L";
				else if(rightD<leftD) finger = "R";
			}
			return finger; //������ leftD�� rightD�� ���ٸ� ������ �ּհ����� ����
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
