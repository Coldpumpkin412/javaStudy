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
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		try {
			System.out.print("계산결과는 ");
			System.out.print(this.left/this.right);
			System.out.print(" 입니다. ");
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

//직접만든 Exception으로 새코딩(DivideException)

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
			throw new DivideException("0으로 나눌 수 없습니다.", this.left, this.right);
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
