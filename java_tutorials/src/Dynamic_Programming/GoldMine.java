package Dynamic_Programming;
import java.util.*;

public class GoldMine {
	/*
	 * ���̳��� ���α׷����� Ȱ�� �ݱ����� �ذ�
	 * (n x m)ũ���� �ݱ�, �� ĭ�� Ư�� ũ�⿡ ���� ��� ����
	 * ä���ڴ� ù��° ������ ����Ͽ� ���� ĳ��, ó������ ù ��° �� ��� �࿡���� ��� ����
	 * ���� m-1���� ���� �Ź� ��������,������,������ �Ʒ� 3���� �� �� �������� �̵�
	 * �̶� ä���ڰ� ���� �� �ִ� ���� �ִ� ũ���?
	 * 
	 * (�ݱ��� ũ��� �ִ� 20x20�̴�)
	 */
	
	static int testCase, n , m;
	static int[][] arr = new int[20][20];
	static int[][] dp = new int[20][20];
	
	public static void main(String[] args) {
		/*
		 * arr[i][j] = i�� j���� �����ϴ� ���� ��
		 * dp[i][j] = i�� j�� ������ ������ ��(���� �� �ִ� ���� �ִ�)
		 * 
		 * ��ȭ�� : dp[i][j] = arr[i][j] + max(dp[i-1][j-1],dp[i][j-1],dp[i+1][j-1])
		 */
		
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt(); //�׽�Ʈ���̽� �� �Է�
		
		for(int tc=0 ; tc<testCase ; tc++) {
			//�ݱ����� �Է�
			n = sc.nextInt();
			m = sc.nextInt();
			
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<m ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//���̳������α׷����� ���� 2���� dp���̺� �ʱ�ȭ
			for(int i=0 ; i<n ; i++) {
				for(int j = 0; j<m ; j++) {
					dp[i][j] = arr[i][j];
					}
			}
			
			//�ݺ��� Ȱ��(���Ҿ� ���)
			for(int j=1 ; j<m ; j++) {
				for(int i=0 ; i<n ; i++) {
					int leftUp, leftDown, left;
					//���� ��
					if(i==0) leftUp = 0; //�迭�� ��� �� �����Ƿ� Ȯ��
					else leftUp = dp[i-1][j-1]; 
					//���� �Ʒ�
					if(i==n-1) leftDown = 0; //�迭�� ��� �� �����Ƿ� Ȯ��
					else leftDown = dp[i+1][j-1];
					//����
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
