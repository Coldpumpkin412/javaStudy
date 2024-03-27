package Programmers;
import java.util.*;

public class Coupled_Delete {
	public int solution(String s) {

		char[] arr = s.toCharArray();
		
		Stack<Character> stack = new Stack<>();


		for(int i=0 ; i<arr.length ; i++) {
			if(stack.isEmpty()) stack.push(arr[i]); //스택이 비어있다면 값 삽입
			else {
				if(stack.peek()==arr[i]) stack.pop(); //넣으려는 값과 최상단이 같다면 삭제
				else stack.push(arr[i]); //같지않다면 삽입
			}
		} 
		//스택이 비어있다면 1, 비어있지않다면 0
		return (stack.isEmpty()) ? 1 : 0;
	}
	
	public static void main(String[] args) {
		String s = "accaacbb";
		Coupled_Delete sol = new Coupled_Delete();
		System.out.print(sol.solution(s));
	}

}
