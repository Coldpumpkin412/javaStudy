package Programmers;
import java.util.*;


//���α׷��ӽ� �ܹ��� ����� ����
public class hamburger {
	public int solution(int[] ingredient) {
		int answer=0;
		StringBuilder sb = new StringBuilder();
		
		for(int i : ingredient) {
			sb.append(i); //��� �߰�
			//���̰� 4�̻��̰� �տ������� 4���� �߶����� 1231�̸�
			if(sb.length()>3 && sb.substring(sb.length()-4, sb.length()).equals("1231")){
				answer++;
				sb.delete(sb.length()-4, sb.length()); //������ ��� ����
			}
		}

		
		return answer;
	}

	public static void main(String[] args) {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		hamburger sol = new hamburger();
		
		System.out.print(sol.solution(ingredient));
	}

}
