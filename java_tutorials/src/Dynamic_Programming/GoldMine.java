package Dynamic_Programming;
import java.util.*;

public class GoldMine {
	/*
	 * 다이나믹 프로그래밍을 활용 금광문제 해결
	 * (n x m)크기의 금광, 각 칸에 특정 크기에 금이 들어 있음
	 * 채굴자는 첫번째 열부터 출발하여 금을 캐며, 처음에는 첫 번째 열 어느 행에서든 출발 가능
	 * 이후 m-1번에 걸쳐 매번 오른쪽위,오른쪽,오른쪽 아래 3가지 중 한 방향으로 이동
	 * 이때 채굴자가 얻을 수 있는 금의 최대 크기는?
	 * 
	 * (금광의 크기는 최대 20x20이다)
	 */
	
	static int testCase, n , m;
	static int[][] arr = new int[20][20];
	static int[][] dp = new int[20][20];
	
	public static void main(String[] args) {
		/*
		 * arr[i][j] = i행 j열에 존재하는 금의 양
		 * dp[i][j] = i행 j열 까지의 최적의 해(얻을 수 있는 금의 최댓값)
		 * 
		 * 점화식 : dp[i][j] = arr[i][j] + max(dp[i-1][j-1],dp[i][j-1],dp[i+1][j-1])
		 */
		
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt(); //테스트케이스 수 입력
		
		for(int tc=0 ; tc<testCase ; tc++) {
			//금광정보 입력
			n = sc.nextInt();
			m = sc.nextInt();
			
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<m ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//다이나믹프로그래밍을 위한 2차원 dp테이블 초기화
			for(int i=0 ; i<n ; i++) {
				for(int j = 0; j<m ; j++) {
					dp[i][j] = arr[i][j];
					}
			}
			
			//반복문 활용(보텀업 방식)
			for(int j=1 ; j<m ; j++) {
				for(int i=0 ; i<n ; i++) {
					int leftUp, leftDown, left;
					//왼쪽 위
					if(i==0) leftUp = 0; //배열을 벗어날 수 있으므로 확인
					else leftUp = dp[i-1][j-1]; 
					//왼쪽 아래
					if(i==n-1) leftDown = 0; //배열을 벗어날 수 있으므로 확인
					else leftDown = dp[i+1][j-1];
					//왼쪽
					left = dp[i][j-1];
					
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
				}
			}
			
			int result = 0;
			for(int i=0 ; i<n ; i++) {
				result = Math.max(result, dp[i][m-1]);
			}
			
			System.out.print(result);
		}

	}

}
