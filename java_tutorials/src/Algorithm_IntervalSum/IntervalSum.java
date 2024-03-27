package Algorithm_IntervalSum;
import java.util.*;

/*
 * ���� �� ������ ����ϱ� �˰���
 * 
 * ���������� ������ N���� ���� ���� �� Ư�� ������ ��� ���� ���� �� ���ϱ�
 * 1. N���� �� �� ���Ͽ� ���λ� ��(Prefix Sum)�� ��� �� �迭 P�� ����
 * 2. �� M���� ��������[L,R]�� Ȯ���� �� �������� P[R]-P[L-1]�� �ȴ�.
 */
public class IntervalSum {
	public static int n=5; //�������� ���� n�� ������ �Է¹ޱ�
	public static int arr[] = {10, 20, 30, 40, 50};
	public static int[] prefixSum = new int[6];
	
	public static void main(String[] args) {
		//���λ� ��(prefix Sum) �迭 ���
		int sum = 0;
		
		for(int i=0 ; i<n ; i++) {
			sum += arr[i];
			prefixSum[i+1] = sum;
		}
		
		//���� �� ���(ex. �� ��° ������ �� ��° ������)
		int left = 3;
		int right = 4;
		System.out.println(prefixSum[right] - prefixSum[left-1]);
	}

}
