package org.opentutorials.javatutorials.exception;

class A{
	private int[] arr = new int[3];
	A() {
		arr[0] = 0;
		arr[1] = 10;
		arr[2] = 20;
	}
	public void z(int first, int second) {
		try {
			System.out.println(arr[first] / arr[second]);
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException e");
		} catch(ArrayIndexOutOfBoundsException e) {
			//ctrl + spacebar : 추천키워드 검색 가능
			System.out.println("ArrayIndexOutOfBoundsException e");
		} catch(Exception e) {
			System.out.println("다른 경우의 예외발생");
		} finally {
			System.out.println("finally");
		}
	}
}
public class ExceptionDemo1 {

	public static void main(String[] args) {
		A a = new A();
		a.z(10,0);
		a.z(1,0);
		a.z(2,1);
	}

}
