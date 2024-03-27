package org.opentutorials.javatutorials.classinstance;

class Calculator3{
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}//메소드 앞에 static을 입력하여 클래스 메소드를 만듦
	//클래스에 직접적으로 접근하여 실행할 수 있음
	
	public static void avg(int left, int right) {
		System.out.println((left+right) / 2);
	}
}
public class CalculatorDemo3 {

	public static void main(String[] args) {
		Calculator3.sum(10,20); //클래스에 직접 접근하여 메소드 호출
		Calculator3.avg(10,20);
		
		Calculator3.sum(20,40);
		Calculator3.avg(20,40);
		
	}

}
