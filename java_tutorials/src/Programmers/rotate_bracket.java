package Programmers;
import java.util.*;

//프로그래머스 괄호 회전하기 문제
/*
 * 주어진 문자열 s를 왼쪽으로 x칸 만큼 회전시켰을때 s가 올바름 괄호가 되게하는 x의 개수
 */
public class rotate_bracket {
	//올바른 괄호인지 확인
	private static boolean check(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0 ; i<s.length() ; i++) {
			if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
				stack.push(s.charAt(i));
			}else {
				if(!stack.isEmpty()) {
					switch(s.charAt(i)) {
						case'(' : Bracket(stack,'('); break;
						case'{' : Bracket(stack,'{'); break;
						case'[' : Bracket(stack,'['); break;
					}
				}else {
					stack.push(s.charAt(i));
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	private static void Bracket(Stack<Character> stack, char bracket) {
		if(stack.peek() == bracket) stack.pop(); //맨위에 것 제거
	}
	
	//왼쪽으로 한 칸씩 회전하는 함수
	private static String rotation(String s) {
		return s.substring(1)+s.charAt(0);
	}
	
	public int solution(String s) {
		int answer = 0;
		
		if(check(s)) answer++;
		
		for(int i=1 ; i<s.length() ; i++) {
			s = rotation(s); //괄호 회전 후
			if(check(s)) answer++; //올바르면 +1
		}
		return answer;
				
	}
	public static void main(String[] args) {
		String s = "[](){}";
		rotate_bracket sol = new rotate_bracket();
		
		System.out.println(sol.solution(s));
	}

}
