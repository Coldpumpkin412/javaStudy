package org.opentutorials.javatutorials.abstractclass.example1;

abstract class A{//����� �ϳ��� abstract��� Ŭ���� ���� abstract
	public abstract int b();
	
	//public abstract int c() {System.out.println("Hello");}
	//��ü�� �ִ� �޼ҵ�� abstract Ű���带 ���� �� ����.
	
	public void d() { 
		//�߻� Ŭ���� ������ �߻� �޼ҵ尡 �ƴ� �޼ҵ尡 ������ �� �ִ�
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
