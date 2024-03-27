package org.opentutorials.javatutorials.condition;

public class SwitchDemo {

	public static void main(String[] args) {
		System.out.println("switch(1)");
		switch(1) {
		case 1: 
			System.out.println("one");
			break; //break가 없다면 case2,3도 다 출력
		case 2:
			System.out.println("two");
		case 3:
			System.out.println("three");
		default:
			System.out.println("default");
		//switch값이 충족되는 case가 없다면 default문 실행
	 
		}
	}

}
