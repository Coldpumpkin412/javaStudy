package Programmers;

public class binary_change {
	public int[] solution(String s) {
		int[] answer = new int[2];
		int zero_count = 0; //������ 0�� ����
		int change_count = 0; //������ȯȽ��
		
		while(!s.equals("1")) {
			zero_count += s.length() - s.replace("0", "").length();//0�� ���� ���ϱ�
			s = s.replaceAll("0", ""); //���ڿ��� 0 ����
			
			s = Integer.toBinaryString(s.length());
			change_count++;
			
		}
		
		answer[0] = change_count;
		answer[1] = zero_count;

		return answer;
	}
	
	public static void main(String[] args) {
		String s = "1111111";
		binary_change sol = new binary_change();
		
		System.out.print(sol.solution(s));
	}

}
