package Algorithm_Implementation;
import java.util.*;

public class UpDownLeftRight {

	public static void main(String[] args) {
		//������ Ȱ���Ͽ� '�����¿�'���� �ذ�
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //������ ũ�� N�Է�
		sc.nextLine(); //���� ����
		String[] plans = sc.nextLine().split(" "); //������ �������� ���ڿ�������
		int x=1, y=1;
		
		//L,R,U,D�� ���� �̵�����
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		char[] moveTypes = {'L', 'R', 'U', 'D'};
		
		//�̵���ȹ �ϳ��� Ȯ��
		for(int i=0 ; i<plans.length ; i++) {
			char plan = plans[i].charAt(0);
			int nx = -1;
			int ny = -1;
			
			//�̵���ȹ �ϳ��� Ȯ��
			for(int j=0 ; j<4 ; j++) { 
				if(plan == moveTypes[j]) {
					//�̵� �� ��ǥ
					nx = x+dx[j];
					ny = y+dy[j];
				}
			}
			//��ǥ �Ѿ�°�� ����
			if(nx<1 || ny <1 || nx>N || ny>N) continue;
			
			//�̵�
			x=nx;
			y=ny; 
		}
		System.out.println(x+" "+y);
	}

}
