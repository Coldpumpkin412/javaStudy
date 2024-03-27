package org.opentutoirals.javatutorials.method;

public class MethodDemo6 {
	public static String numbering(int init, int limit) {
		int i = init;
		//만들어지는 숫자를 output이라는 변수에 담기 위해 변수에 빈 값 부여
		String output = "";
		while(i<limit) {
			//숫자를 화면에 출력하는 대신 변수 output에 담기
			output += i;
			i++;
		}
		// 중요! output에 담긴 문자열을 메소드 외부로 반환하려면 
		//아래처럼 return을 배치
		return output; //자바는 return을 만나면 메소드 반드시 종료
	}

	public static void main(String[] args) {
		String result = numbering(1,5);
		System.out.println(result); //결과 : 1234
	}

}
