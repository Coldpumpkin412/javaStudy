package org.opentutorials.javatutorials.condition;

public class SwitchDemo {

	public static void main(String[] args) {
		System.out.println("switch(1)");
		switch(1) {
		case 1: 
			System.out.println("one");
			break; //break�� ���ٸ� case2,3�� �� ���
		case 2:
			System.out.println("two");
		case 3:
			System.out.println("three");
		default:
			System.out.println("default");
		//switch���� �����Ǵ� case�� ���ٸ� default�� ����
	 
		}
	}

}
