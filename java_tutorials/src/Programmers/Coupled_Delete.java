package Programmers;
import java.util.*;

public class Coupled_Delete {
	public int solution(String s) {

		char[] arr = s.toCharArray();
		
		Stack<Character> stack = new Stack<>();


		for(int i=0 ; i<arr.length ; i++) {
			if(stack.isEmpty()) stack.push(arr[i]); //������ ����ִٸ� �� ����
			else {
				if(stack.peek()==arr[i]) stack.pop(); //�������� ���� �ֻ���� ���ٸ� ����
				else stack.push(arr[i]); //�����ʴٸ� ����
			}
		} 
		//������ ����ִٸ� 1, ��������ʴٸ� 0
		return (stack.isEmpty()) ? 1 : 0;
	}
	
	public static void main(String[] args) {
		String s = "accaacbb";
		Coupled_Delete sol = new Coupled_Delete();
		System.out.print(sol.solution(s));
	}

}
