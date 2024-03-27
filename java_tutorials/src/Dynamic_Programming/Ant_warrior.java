package Dynamic_Programming;
import java.util.*;

public class Ant_warrior {
	/*
	 * 다이나믹프로그래밍을 활용
	 * 개미가 i번째 식량창고에서 구할 수 있는 최적의 해는?
	 * (i-1번째까지의 값)과 (i-2번째까지의 값+현재식량창고의 값)의 최대값
	 *  
	 */
	
	//앞서 계산된 결가 저장을 위한 DP테이블
	public static int[] d = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(); //식량창고의 개수
		
		int[] arr = new int[n]; //각 식량창고의 값
		for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt(); //식량창고 값 입력
		
		//다이나믹 프로그래밍, 보텀업 방식(반복문) 활용
		/*
		 * 개미는 인접한 식량창고는 동시에 털 수 없다
		 */
		
		d[0] = arr[0]; //1번째 식량창고값
		d[1] = Math.max(arr[0], arr[1]); //두 개중 양이 많은 곳의 값이 최적의 해
		
		for(int i=2 ; i<n ; i++) {
			d[i] = Math.max(d[i-1], d[i-2]+arr[i]);
		}
		System.out.println(d[n-1]);
		
	}

}
