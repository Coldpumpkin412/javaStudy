package Dynamic_Programming;

public class dynamic_Fibonacci {
	/*
	 * 다이나믹 프로그래밍 방법으로 피보나치 수열 구현
	 * 바텀업 방식 활용
	 */
	public static long[] d = new long[100];
	
	public static void main(String[] args) {
		d[1]=1;
		d[2]=1;
		int n=50; //n번째 피보나치 수 
		
		//보텀업 방식(반복문)으로 구현
		for(int i=3 ; i<=n ; i++) {
			d[i] = d[i-1]+d[i-2];
		}
		
		System.out.print(d[n]);
	}

}
