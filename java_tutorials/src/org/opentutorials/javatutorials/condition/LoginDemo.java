package org.opentutorials.javatutorials.condition;

public class LoginDemo {

	public static void main(String[] args) {
		String id = args[0]; //입력값이라고 생각하면 됨
		if(id.equals("egoing")) {
			System.out.println("right");
		} else {
			System.out.println("wrong");
		}
	}

} //명령프롬프트활용하여 실행할 수 있음
  /*런 버튼 옆에 Run Configuration 버튼 활용하여 실행(37강 확인)*/
