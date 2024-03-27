package org.opentutorials.javatutorials.overloading.example1;

public class OverloadingDemo {
	
	void A() { System.out.println("void A()"); }
	
	void A(int arg1) { System.out.println("void A(int arg1)"); }
	
	//void A(int param1) { System.out.println("void A(int param)"); }
	//매개변수의 이름은 오버로딩의 조건이 되지못한다
	
	void A(String arg1) { System.out.println("void A(String arg1)"); }
	
	//int A() { System.out.println("void A()"); }
    //리턴타입이 다르기 때문에 에러 발생
	public static void main(String[] args) {
		
		OverloadingDemo od = new OverloadingDemo();
		
		od.A();
		od.A(1);
		od.A("coding everybody");
	}

}
