package Dynamic_Programming;
import java.util.*;

public class Make_one {
	/*
	 * 1로만들기 문제
	 * 
	 */
	public static int[] d = new int[30001]; //주어진 조건이 30000까지
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		//다이나믹프로그래밍(보텀업)
		for(int i=2 ; i<=x ; i++) {
			d[i] = d[i-1]+1; //현재의 수에서 1을 뺴는 경우
			
			//2로 나누어떨어지는 경우
			if(i%2==0) d[i] = Math.min(d[i], d[i/2]+1);
			//3으로 나누어 떨어지는 경우
			if(i%3==0) d[i] = Math.min(d[i], d[i/3]+1);
			//5로 나누어 떨어지는 경우
			if(i%5==0) d[i] = Math.min(d[i], d[i/5]+1);
		}
		
		System.out.print(d[x]);
	}

}
