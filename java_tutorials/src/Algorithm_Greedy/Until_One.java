package Algorithm_Greedy;
import java.util.Scanner;

public class Until_One {

	public static void main(String[] args) {
		//�׸��� �˰����� Ȱ���Ͽ� '1�� �� ������' �����ذ�
		//� �� N�� 1�� �� ������ ���� �� ���� �� �ϳ��� �ݺ�
		//1. N���� 1�� ����, 2. N�� K�� ������
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int count = 0; //���� Ƚ�� Ȯ��
		
		while(N!=1) {
			if(N%K == 0) {
				N /= K; //N�� K�� ���� �� ������ �ٷ� ������
				count++;
			}
			else {
				N -= 1; //N�� K�� ���� �� ���������� 1�� ����
				count++;
			}
			
		}
		
		System.out.println(count); //N�� 1�� ������ ����Ƚ�� ���
		
	}

}
