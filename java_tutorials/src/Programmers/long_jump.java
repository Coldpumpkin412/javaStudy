package Programmers;

/*
 * 프로그래머스 멀리뛰기 문제
 * 한 번에 1칸 혹은 2칸을 뛸 수 있을 때 N칸 까지 갈 수 있는 경우의 수는?
 * 이 값을 1234567로 나눈 값을 구하라
 */
public class long_jump {
	/*
	 * n칸 까지 이동하는 경우의 수 : n-1칸 까지 이동하는 경우의 수 + n-2칸까지 이동하는 경우의 수
	 * 1칸을 이동하는 경우의 수 : 1개
	 * 2칸을 이동하는 경우의 수 : 2개
	 * 
	 * 다이나믹 프로그래밍 활용하여 시간 줄이기
	 */
	
	public long solution(int n) {
		long answer[] = new long[2001];
		
		answer[1] = 1; //한 칸을 뛰는 경우의 수 : 1
		answer[2] = 2; //두 칸을 뛰는 경우의 수 : 2
		
		for(int i=3 ; i<=n ; i++) answer[i] = (answer[i-1]+answer[i-2]) % 1234567;
		
		return answer[n];
	}
	public static void main(String[] args) {
		int n=3;
		
		long_jump sol = new long_jump();
		System.out.print(sol.solution(n));

	}

}
