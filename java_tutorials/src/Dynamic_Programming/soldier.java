package Dynamic_Programming;
import java.util.*;

public class soldier {
	/*
	 * 다이나믹프로그래밍 활용하여 병사 배치하기
	 * N명의 병사가 무작위로 나열, 각 병사는 특정값의 전투력 보유
	 * 특정 위치에 있는 병사를 열외시키는 방법을 이용하여
	 * 남은 병사들의 전투력이 내림차순으로 배치된다면
	 * 이 때 남아있는 병사가 최대가 되게하는 열외된 병사의 수를 구하기
	 * 
	 * (병사의 수 1<=N<=2000, 전투력 : 1000만 이하 자연수)
	 * (시간제한 1초)
	 */
	
	static int n;
	static ArrayList<Integer> v = new ArrayList<Integer>();
	static int[] dp =new int[2000];
	
	public static void main(String[] args) {
		/*
		 * N의 최대값이 2000이고 시간제한이 1초이기 떄문에
		 * 가능한 O(N^2) 이하의 시간복잡도를 가지는 알고리즘을 설계
		 */
		
		/*
		 * 기본 아이디어 : 가장 긴 증가하는 부분 수열(LIS)
		 * -----<LIS알고리즘>------
		 * D[i] = arr[i]를 마지막 원소로 가지는 부분 수열의 최대 길이라면,
		 * 모든 0<=j<i에 대하여 만약 arr[j]<arr[i]라면, D[i] = max(D[i], D[j]+1)
		 * 
		 * 본 문제는 가장 긴 감소하는 부분 수열을 찾는것이므로 LIS를 조금 수정
		 */
		
		Scanner sc = new Scanner(System.in);
		//병사의 전투력 입력
		for(int i=0 ; i<n ; i++) {
			v.add(sc.nextInt());
		}
		
		//순서를 뒤집어 가장 긴 증가하는 부분수열 문제로 변환
		Collections.reverse(v);
		
		//다이나믹 프로그래밍을 위한 1차원 DP테이블 초기화
		for(int i=0 ; i<n ; i++) dp[i]=1;
		
		//LIS알고리즘 수행
		for(int i=1 ; i<n ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(v.get(j) < v.get(i)) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		//열외해야하는 병사의 최소 수 출력
		int maxValue = 0;
		
		for(int i=0 ; i<n ; i++) maxValue = Math.max(maxValue, dp[i]);
		
		System.out.print(n - maxValue);
	}

}
