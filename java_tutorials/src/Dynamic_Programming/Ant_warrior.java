package Dynamic_Programming;
import java.util.*;

public class Ant_warrior {
	/*
	 * ���̳������α׷����� Ȱ��
	 * ���̰� i��° �ķ�â���� ���� �� �ִ� ������ �ش�?
	 * (i-1��°������ ��)�� (i-2��°������ ��+����ķ�â���� ��)�� �ִ밪
	 *  
	 */
	
	//�ռ� ���� �ᰡ ������ ���� DP���̺�
	public static int[] d = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(); //�ķ�â���� ����
		
		int[] arr = new int[n]; //�� �ķ�â���� ��
		for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt(); //�ķ�â�� �� �Է�
		
		//���̳��� ���α׷���, ���Ҿ� ���(�ݺ���) Ȱ��
		/*
		 * ���̴� ������ �ķ�â��� ���ÿ� �� �� ����
		 */
		
		d[0] = arr[0]; //1��° �ķ�â��
		d[1] = Math.max(arr[0], arr[1]); //�� ���� ���� ���� ���� ���� ������ ��
		
		for(int i=2 ; i<n ; i++) {
			d[i] = Math.max(d[i-1], d[i-2]+arr[i]);
		}
		System.out.println(d[n-1]);
		
	}

}
