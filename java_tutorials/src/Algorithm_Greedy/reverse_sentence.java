package Algorithm_Greedy;
import java.util.*;

/*
 * ���ڿ� ������ ����
 * 0�� 1�θ� �̷���� ���ڿ� S�� ���� ��, �� ���ڿ��� ��� ���ڸ� ���� ���� ��������Ѵ�.
 * �� �� ���ӵ� �ϳ� �̻��� ���ڸ� ��� ��� ������ �͸� �����ϴ�.
 */
public class reverse_sentence {
	public static String s; 
	public static int count0; //���� 0���� �ٲٴ� ���
	public static int count1; //���� 1�� �ٲٴ� ���
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		
		//ù ��° ���� ó��
		if(s.charAt(0)=='1') count0++;
		else count1++;
		
		//�� ��° ���Һ��� Ȯ��
		for(int i=0 ; i<s.length()-1 ; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				if(s.charAt(i+1) == '1') count0++; //���� ������ 1�� �ٲ�°��
				else count1++; //���� ������ 0���� �ٲ�� ���
			}
		}
		
		System.out.println(Math.min(count1, count0));
	}

}
