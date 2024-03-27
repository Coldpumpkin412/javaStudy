package Algorithm_Greedy;
import java.util.Scanner;
import java.util.Arrays;
public class Big_Number {

	public static void main(String[] args) {
		//�׸��� �˰����� Ȱ���� ū ���� ��Ģ �����ذ�
		//ù° �ٿ� N, M, K�� �ڿ����� �־����� �������� ����
		//��° �ٿ� N���� �ڿ��� �Է�, �������� ����
		//K<=M
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //�Է��� �ڿ���
		int M = sc.nextInt(); //M�� ���ϱ�
		int K = sc.nextInt(); //���� K�� �ʰ��� ���� �� ����
		
		int[] number = new int[N]; //���� ����迭
		
		for(int i=0 ; i<N ; i++) {
			number[i] = sc.nextInt();
		}
		Arrays.sort(number); //�Է¹��� �� ����
		
		int first = number[N-1]; //���� ū ��
		int second = number[N-2]; //�ι�°�� ū ��
		
		int count = (M / (K+1)) * K; //���� ū ���� �������� Ƚ��
		count = count + (M % (K+1));
		
		int result = 0; //�����
		result = result + (count*first); //���� ū �� ���ϱ�
		result = result + (M-count)*second; //�ι�°�� ū �� ���ϱ�
		
		System.out.println(result);
	}

}
