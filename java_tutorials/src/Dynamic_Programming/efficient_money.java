package Dynamic_Programming;
import java.util.*;

public class efficient_money {
	/*
	 * 다이나믹 프로그래밍을 활용 효율적인 화폐구성 문제
	 * N가지 종류의 화폐가 있고, 화폐 개수를 최소한으로 이용하여 M원으로 만들 때,
	 * 최소한의 화폐 개수는? (불가능시 -1을 출력)
	 * 
	 * (1<=N<=100, 1<=M<=10000)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //화폐종류의 개수
		int m = sc.nextInt(); //만들고자하는 금액
		
		//n개의 화폐단위 정보 입력
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		//DP테이블 초기화
		int[] d = new int[m+1];
		Arrays.fill(d, 10001); //배열d의 값을 모두 10001로 초기화
		
		d[0] = 0;
		
		for(int i=0 ; i<n ; i++) {
			for(int j=arr[i] ; j<=m ; j++) {
				//i-k원을 만드는 방법이 존재하는 경우
				if(d[j-arr[i]] != 10001) {
					d[j] = Math.min(d[j],  d[j-arr[i]]+1);
				}
			}
		}
		
		if(d[m] == 10001) System.out.print(-1);
		else System.out.print(d[m]);
		
	}

}
