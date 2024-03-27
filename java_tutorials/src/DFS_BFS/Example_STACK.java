package DFS_BFS;
import java.util.*;

public class Example_STACK {

	public static void main(String[] args) {
		//자바를 활용하여 STACK 예제 구현
		Stack<Integer> s = new Stack<>();
		
		//삽입(5)-삽입(2)-삽입(3)-삽입(7)-삭제()-삽입(1)-삽입(4)-삭제()
		
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(7);
		s.pop();
		s.push(1);
		s.push(4);
		s.pop();
		
		while(!s.empty()) {
			//peek()을 이용하여 TOP에 있는 데이터를 꺼내온다.
			System.out.println(s.peek()); 
			s.pop();
		}
		//TOP부터 출력 되기때문에 스택은 아래서부터 읽어간다고 할 수 있음.

	}

}
