package org.opentutorials.javatutorials.classinstance;

class C1{
	static int static_variable = 1; // 클래스 변수
	int instance_variable = 2; //인스턴스 변수
	
	static void static_static() { // 클래스 메소드-클래스 변수 관계
		System.out.println(static_variable);
	}
	static void static_instance() { // 클래스 메소드 - 인스턴스 변수 관계
		//System.out.println(instance_variable);
		//클래스 메소드에서는 인스턴스 변수(멤버)에 접근할 수 없다
	}
	void instance_static() { // 인스턴스 메소드 - 클래스 변수 관계
		System.out.println(static_variable);
		//인스턴스 메소드에는 클래스 변수(멤버)에 접근할 수 있다
	}
	void instance_instance() { // 인스턴스 메소드 - 인스턴스 변수 관계
		System.out.println(instance_variable);
	}
}
public class CalculatorDemo4 {

	public static void main(String[] args) {
		C1 c = new C1();
		
		c.static_static();
		//인스턴스 이용하여 클래스 메소드 접근 O
		//인스턴스 메소드가 클래스 변수 접근 O
		
		c.static_instance();
		//인스턴스 이용하여 클래스 메소드 접근 O
		//클래스 메소드가 인스턴스 변수에 접근 X
		
		c.instance_static();
		//인스턴스 이용하여 인스턴스 메소드 접근 O
		//인스턴스 메소드가 클래스 변수에 접근 O
		
		c.instance_instance();
		//인스턴스 이용하여 인스턴스 메소드 접근 O
		//인스턴스 메소드가 인스턴스 변수에 접근 O
		
		C1.static_static();
		//클래스를 이용하여 클래스 메소드 접근 O
		//클래스 메소드가 클래스 변수에 접근 O
		
		C1.static_instance();
		//클래스를 이용하여 인스턴스 메소드 접근 O
		//클래스 메소드가 인스턴스 변수에 접근X
		
		//C1.instance_static();
		//클래스를 이용하여 인스턴스 메소드 접근 X
		
		//C1.instance_instance();
		//클래스를 이용하여 인스턴스 메소드 접근 X
	}

}
