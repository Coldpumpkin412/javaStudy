package DFS_BFS;

public class Example_RECURSIVE {

	public static void main(String[] args) {
		//재귀함수를 이용한 '팩토리얼'문제 해결
		//5! 을 재귀함수로 표현
		System.out.println(factorial(5));
	}
	
	public static int factorial(int n) {
		if(n<=1) return 1;
		
		return n * factorial(n-1);
	}

}
