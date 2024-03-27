package org.opentutorials.javatutorials.array;

public class ForeachDemo {

	public static void main(String[] args) {
		String[] members = { "최진혁", "최유빈", "한이람" };
		for(String e : members) {//콜론뒤에 들어있는 배열의 값들을 하나씩 e에 대입
			System.out.println(e + " 이 상담을 받았습니다.");
		}
	}

}
