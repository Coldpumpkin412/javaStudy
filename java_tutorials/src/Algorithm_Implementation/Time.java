package Algorithm_Implementation;
import java.util.*;

public class Time {
	
	public static boolean check(int h, int m, int s) {
		//Ư�� �ð��� 3�� ���Ե��ִ��� Ȯ��
		if(h%10==3 || m/10==3 || m%10==3 || s/10==3 || s%10==3) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		//������ Ȱ���Ͽ� '�ð�'���� �ذ�
		//N��59��59�� ���� 3�� �ϳ��� ���ԵǴ� ��� ����� �� ���
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt(); //�ð� �Է�
		int count = 0; //3�����ԵǴ� Ƚ��
		
		for(int i=0 ; i<h ; i++) {//��
			for(int j=0 ; j<60 ; j++) {//��
				for(int k=0 ; k<60 ; k++) {//��
					if(check(i,j,k)) count++;
				}
			}
		}
		System.out.println(count);
	}

}
