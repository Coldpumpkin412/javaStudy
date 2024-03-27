package org.opentutorials.javatutorials.abstractclass.example1;

abstract class A{//멤버중 하나라도 abstract라면 클래스 또한 abstract
	public abstract int b();
	
	//public abstract int c() {System.out.println("Hello");}
	//본체가 있는 메소드는 abstract 키워드를 가질 수 없다.
	
	public void d() { 
		//추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재할 수 있다
		System.out.println("world");
	}
}
class B extends A{
	public int b() {
		return 1;
	}
}

public class AbstractDemo {

	public static void main(String[] args) {
		//A obj = new A();
		B obj = new B();
	}

}
