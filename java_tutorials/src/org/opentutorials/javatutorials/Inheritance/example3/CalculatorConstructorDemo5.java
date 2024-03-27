package org.opentutorials.javatutorials.Inheritance.example3;

class Calculator{
	int left, right;
	
	public Calculator() {}; //기본생성자 명시, 없으면 에러 발생
	
	public Calculator(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left+this.right) / 2);
	}
	
}

class SubtractionableCalculator extends Calculator{
	
	public SubtractionableCalculator(int left, int right) {
		super(left,right);
		//초기화 코드가 있다면 입력가능
	}
	
	public void subtract() {
		System.out.println(this.left - this.right);
	}
}
public class CalculatorConstructorDemo5 {

	public static void main(String[] args) {
		SubtractionableCalculator c1 = new SubtractionableCalculator(10, 20);
		c1.sum();
		c1.avg();
		c1.subtract();
	}

}
