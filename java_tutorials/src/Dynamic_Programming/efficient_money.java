package Dynamic_Programming;
import java.util.*;

public class efficient_money {
	/*
	 * ���̳��� ���α׷����� Ȱ�� ȿ������ ȭ�󱸼� ����
	 * N���� ������ ȭ�� �ְ�, ȭ�� ������ �ּ������� �̿��Ͽ� M������ ���� ��,
	 * �ּ����� ȭ�� ������? (�Ұ��ɽ� -1�� ���)
	 * 
	 * (1<=N<=100, 1<=M<=10000)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //ȭ�������� ����
		int m = sc.nextInt(); //��������ϴ� �ݾ�
		
		//n���� ȭ����� ���� �Է�
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		//DP���̺� �ʱ�ȭ
		int[] d = new int[m+1];
		Arrays.fill(d, 10001); //�迭d�� ���� ��� 10001�� �ʱ�ȭ
		
		d[0] = 0;
		
		for(int i=0 ; i<n ; i++) {
			for(int j=arr[i] ; j<=m ; j++) {
				//i-k���� ����� ����� �����ϴ� ���
				if(d[j-arr[i]] != 10001) {
					d[j] = Math.min(d[j],  d[j-arr[i]]+1);
				}
			}
		}
		
		if(d[m] == 10001) System.out.print(-1);
		else System.out.print(d[m]);
		
	}

}
