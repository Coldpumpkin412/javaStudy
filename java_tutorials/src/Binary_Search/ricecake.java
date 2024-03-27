package Binary_Search;
import java.util.*;


public class ricecake {
	/*
	 * ����Ž���� Ȱ���Ͽ� ������ �� ����� ����Ǯ��
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //���� ����
		int m = sc.nextInt(); //��û�� ���� ����
		
		//�� ���� ���� ���� ����
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt();
		
		int start = 0 ; //����Ž���� Ȱ���� ������
		int end = (int) 1e9; //���õ� ���س��̰� 10�� �����̹Ƿ� �ʱⰪ �̷��� ����
		int result = 0;
		
		while(start<=end) {
			long total=0;
			int mid=(start+end)/2; //�߰���
			
			for(int i=0 ; i<n ; i++) {
				//���� ���ܱ⺸�� ��� �ڸ� �� �߸� ���� �� ���ϱ�
				if(arr[i]>mid) total += (arr[i]-mid); 
			}
			if(total<m) end = mid-1; //�߸� ���� ���̰� ��û���� ������ ���ܱ� �������� �̵�
			else {
				result = mid;
				start = mid+1;
			}
			
		}
		System.out.print(result);
	}

}
