package Programmers;
import java.util.*;

//프로그래머스 문자열 나누기 문제
public class sentence {
	public int solution(String s) {
		int answer = 0;
		char ch = s.charAt(0); //초기값은 미리 변수에 담아두기
		int maincount = 1; //기준이 될 알파벳이 나온 횟수(초기값이 이미 나왔으므로 1부터 시작)
		int subcount = 0; //maincount와 비교할 변수
		
		for(int i=1 ; i<s.length() ; i++) {
			if(ch == ' ') {
				ch = s.charAt(i); 
				continue;// 이전에 잘려나가 빈칸인경우 다시 초기값 선정
			}
			if(ch == s.charAt(i)) {
				maincount++;
			} else {
				subcount++;
			}
			
			if(maincount == subcount) { //횟수가 같아지면 다시 초기화
				answer++;
				ch = ' ';
				maincount = 1;
				subcount = 1;
			}
		}
		
		if(ch != ' ') {
			answer++;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String s = "banana";
		sentence sol = new sentence();
		
		System.out.print(sol.solution(s));
		
	}

}
