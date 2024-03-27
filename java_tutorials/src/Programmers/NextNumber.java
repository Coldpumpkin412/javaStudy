package Programmers;


//프로그래머스 다음 큰 숫자
public class NextNumber {
	
	public int solution(int n) {
		/*
		 * Integer.bitCount() 사용
		 * 매개변수를 2진변환 시켰을 때 1의 개수 반환
		 */
		int answer=0;
		int i= n+1;
		
		while(Integer.bitCount(n) != Integer.bitCount(i)) {
			i++;
		}
		
		return i;
	}

	public static void main(String[] args) {
		int n=78;
		
		NextNumber sol = new NextNumber();
		
		System.out.print(sol.solution(n));
	}

}
