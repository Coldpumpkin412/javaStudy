package Programmers;
import java.util.*;

//프로그래머스 JadenCase 문자열
public class JadenCase {
	public String solution(String s) {
		/*
		 * 주어지는 s는 알파벳, 숫자, 공백문자로 이루어짐
		 * 숫자는 단어의 첫 문자로만 나옴
		 * 공백이 연속해서 나올 수 있음
		 */
		String answer = "";
		int index=0; //index가 0일때 대문자로 치환, 공백을 만나면 다시 0으로 초기화
		
		for(int i=0 ; i<s.length() ; i++) {
			char ch;
			//인덱스가 0이고 소문자면 대문자로 치환 후 인덱스 값 증가
			if('a'<=s.charAt(i) && s.charAt(i) <='z' && index==0) {
				ch = Character.toUpperCase(s.charAt(i));
				answer += ch;
				index++;
			}else if(s.charAt(i)==' ') {
				//공백을 만나면 인덱스를 다시 0으로 초기화
				answer += s.charAt(i);
				index = 0;
			}else if(index!=0){ 
				//인덱스가 0이 아닌경우 모두 소문자
				ch = Character.toLowerCase(s.charAt(i));
				answer += ch;
				index++;
			}else { //이외의 경우(숫자)
				answer += s.charAt(i);
				index++;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String s = "3people   unFollowed me";
		JadenCase sol = new JadenCase();
		
		System.out.print(sol.solution(s));
	}

}
