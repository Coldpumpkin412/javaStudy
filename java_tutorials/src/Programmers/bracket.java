package Programmers;
import java.util.*;

//���α׷��ӽ� �ùٸ� ��ȣ ����
public class bracket {
	boolean solution(String s) {
		/*
		 * 1.���� Ȱ��.
		 * '('�� ������ ���ÿ� �߰�, ')'�� ������ ���ÿ��� ����
		 * ���ڿ������� ������ ������ ��������� true �ƴϸ� false
		 * 
		 * 2.���ڿ��� ')'�� ���۵Ǹ� false
		 */
		Stack<Character> stack = new Stack<>();
		
		if(s.charAt(0)==')') return false;
		
		for(int i=0 ; i<s.length() ; i++) {
			if(s.charAt(i) == '(') stack.push('(');
			else {
				if(!stack.isEmpty()) stack.pop();
			}
		}
		
		if(stack.size() == 0) return true;
		else return false;
		
	}
	public static void main(String[] args) {
		String s = "()))((()";
		bracket sol = new bracket();
		
		System.out.print(sol.solution(s));
	}

}
