package Algorithm_Implementation;
import java.util.*;

/*
 * ��Ű��Ʈ����Ʈ ����
 * �־��� ���� N�� �ڸ����� �������� ������ ������ ���� �κ��� �ڸ����� �հ� ������ �κ��� �ڸ����� ���� ���ٸ�
 * LUCKY��, �ƴ϶�� READY�� ��ȯ�ϴ� ����
 * 
 * ù°�ٿ� ���� N�� �Է�(�ڸ����� �׻� ¦��)
 */
public class LuckyStraight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		
		String str = Integer.toString(N); //���� N�� ���ڿ��� ��ȯ
		int sum=0;
		
		for(int i=0 ; i<str.length()/2 ; i++) {
			sum += str.charAt(i)-'0'; //������ ��ȯ �� �� �����ֱ�
		}
		
		for(int i=str.length()/2 ; i<str.length() ; i++) {
			sum -= str.charAt(i)-'0';
		}
		
		if(sum==0) System.out.println("LUCKY");
		else System.out.println("READY");
		
		sc.close();
	}

}
