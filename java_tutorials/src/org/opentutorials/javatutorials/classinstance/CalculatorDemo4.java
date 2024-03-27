package org.opentutorials.javatutorials.classinstance;

class C1{
	static int static_variable = 1; // Ŭ���� ����
	int instance_variable = 2; //�ν��Ͻ� ����
	
	static void static_static() { // Ŭ���� �޼ҵ�-Ŭ���� ���� ����
		System.out.println(static_variable);
	}
	static void static_instance() { // Ŭ���� �޼ҵ� - �ν��Ͻ� ���� ����
		//System.out.println(instance_variable);
		//Ŭ���� �޼ҵ忡���� �ν��Ͻ� ����(���)�� ������ �� ����
	}
	void instance_static() { // �ν��Ͻ� �޼ҵ� - Ŭ���� ���� ����
		System.out.println(static_variable);
		//�ν��Ͻ� �޼ҵ忡�� Ŭ���� ����(���)�� ������ �� �ִ�
	}
	void instance_instance() { // �ν��Ͻ� �޼ҵ� - �ν��Ͻ� ���� ����
		System.out.println(instance_variable);
	}
}
public class CalculatorDemo4 {

	public static void main(String[] args) {
		C1 c = new C1();
		
		c.static_static();
		//�ν��Ͻ� �̿��Ͽ� Ŭ���� �޼ҵ� ���� O
		//�ν��Ͻ� �޼ҵ尡 Ŭ���� ���� ���� O
		
		c.static_instance();
		//�ν��Ͻ� �̿��Ͽ� Ŭ���� �޼ҵ� ���� O
		//Ŭ���� �޼ҵ尡 �ν��Ͻ� ������ ���� X
		
		c.instance_static();
		//�ν��Ͻ� �̿��Ͽ� �ν��Ͻ� �޼ҵ� ���� O
		//�ν��Ͻ� �޼ҵ尡 Ŭ���� ������ ���� O
		
		c.instance_instance();
		//�ν��Ͻ� �̿��Ͽ� �ν��Ͻ� �޼ҵ� ���� O
		//�ν��Ͻ� �޼ҵ尡 �ν��Ͻ� ������ ���� O
		
		C1.static_static();
		//Ŭ������ �̿��Ͽ� Ŭ���� �޼ҵ� ���� O
		//Ŭ���� �޼ҵ尡 Ŭ���� ������ ���� O
		
		C1.static_instance();
		//Ŭ������ �̿��Ͽ� �ν��Ͻ� �޼ҵ� ���� O
		//Ŭ���� �޼ҵ尡 �ν��Ͻ� ������ ����X
		
		//C1.instance_static();
		//Ŭ������ �̿��Ͽ� �ν��Ͻ� �޼ҵ� ���� X
		
		//C1.instance_instance();
		//Ŭ������ �̿��Ͽ� �ν��Ͻ� �޼ҵ� ���� X
	}

}
