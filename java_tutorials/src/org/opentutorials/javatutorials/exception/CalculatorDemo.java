package org.opentutorials.javatutorials.exception;

/*
class Calculator{
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
		}
	public void divide() {
		if(right == 0) {
			throw new ArithmeticException("0���� ���� �� �����ϴ�.");
		}
		try {
			System.out.print("������� ");
			System.out.print(this.left/this.right);
			System.out.print(" �Դϴ�. ");
		} catch(Exception e) {
			System.out.println("\n\ne.getMessage()\n " +e.getMessage());
			System.out.println("\n\ne.toString()\n" +e.toString());
			System.out.println("\n\ne.printStackTrace()");
			e.printStackTrace();
		}
	}
}
public class CalculatorDemo {

	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setOprands(10,0);
		try {
			c1.divide();
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}

}
*/

//�������� Exception���� ���ڵ�(DivideException)

class DivideException extends Exception{
	public int left, right;
	
	DivideException(){
		super();
	}
	DivideException(String message){
		super(message);
	}
	DivideException(String message, int left, int right){
		super(message);
		this.left = left;
		this.right = right;
	}
}
class Calculator{
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
		}
	public void divide() throws DivideException {
		
		if(right == 0) {
			throw new DivideException("0���� ���� �� �����ϴ�.", this.left, this.right);
		}
			System.out.print(this.left/this.right);
	} 
}

public class CalculatorDemo {

	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setOprands(10,0);
		try {
			c1.divide();
		} catch(DivideException e) {
			System.out.println(e.getMessage());
			System.out.println(e.left);
			System.out.println(e.right);
		}
	}

}
