package Algorithm_Greedy;
import java.util.Scanner;

public class Number_Card {

	public static void main(String[] args) {
		//�׸��� �˰����� Ȱ���� ����ī������ذ�
		//N x M��� ����� ī����� ����
		//�� �࿡�� ���� ���� �� �߿� ���� ū ���� ã�ƾ��Ѵ�.
		//ī��� 1~10000�� ���ڸ� ������.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //���� ����
		int M = sc.nextInt(); //���� ����
		int result = 0;
		
		for(int i=0 ; i<N ;i++) {
			int min_value = 10001;
			for(int j=0 ; j<M ;j++) {
				int number = sc.nextInt(); //�迭 �� �Է�
				min_value = Math.min(min_value, number); //���� �� ��
			}
			
			result = Math.max(result, min_value);
			//���� ���� �� �� ���� ū �� 
		}
		
		System.out.println(result);
	}

}
