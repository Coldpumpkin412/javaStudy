package Programmers;

public class tournament {
	public int soulution(int n, int a, int b) {
		int answer = 1;
		
		while(true) {
			a = (a+1)/2;
			b = (b+1)/2;
			
			if(a==b) break;
			
			answer++;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int N=8;
		int A=4;
		int B=7;
		
		tournament sol = new tournament();
		System.out.print(sol.soulution(N, A, B));
	}

}
