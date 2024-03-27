package Programmers;

public class binary_change {
	public int[] solution(String s) {
		int[] answer = new int[2];
		int zero_count = 0; //제거한 0의 개수
		int change_count = 0; //이진변환횟수
		
		while(!s.equals("1")) {
			zero_count += s.length() - s.replace("0", "").length();//0의 개수 더하기
			s = s.replaceAll("0", ""); //문자열의 0 제거
			
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
