package Programmers;
import java.util.*;

//���α׷��ӽ� ��ȣ ȸ���ϱ� ����
/*
 * �־��� ���ڿ� s�� �������� xĭ ��ŭ ȸ���������� s�� �ùٸ� ��ȣ�� �ǰ��ϴ� x�� ����
 */
public class rotate_bracket {
	//�ùٸ� ��ȣ���� Ȯ��
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
		if(stack.peek() == bracket) stack.pop(); //������ �� ����
	}
	
	//�������� �� ĭ�� ȸ���ϴ� �Լ�
	private static String rotation(String s) {
		return s.substring(1)+s.charAt(0);
	}
	
	public int solution(String s) {
		int answer = 0;
		
		if(check(s)) answer++;
		
		for(int i=1 ; i<s.length() ; i++) {
			s = rotation(s); //��ȣ ȸ�� ��
			if(check(s)) answer++; //�ùٸ��� +1
		}
		return answer;
				
	}
	public static void main(String[] args) {
		String s = "[](){}";
		rotate_bracket sol = new rotate_bracket();
		
		System.out.println(sol.solution(s));
	}

}
