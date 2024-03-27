package Algorithm_Implementation;
import java.util.*;

public class Kings_knight {

	public static void main(String[] args) {
		//������ Ȱ���Ͽ� 'ŷ������Ʈ' ���� �ذ�
		//���� 1��~8��, ���� a��~h���� ǥ���ȴ�.
		//�Է� ���ڴ� a1ó�� ���� ������ �̷����
		Scanner sc = new Scanner(System.in);
		
		String inputData = sc.nextLine();
		//nextLine()�� ���͸� ġ�� ������ �� ���ڿ��� ��ȯ
		//next()�� ����(space) ������ �� ���ڿ� ��ȯ
		int row = inputData.charAt(1) - '0'; //���ڸ� int�� ����
		int column = inputData.charAt(0) - 'a' +1; //���ڸ� int�� ����
		
		//����Ʈ�� �̵��� �� �ִ� ���� 8����
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		//8���⿡ ���� �̵� �������� Ȯ��
		int count=0;
		for(int i=0 ; i<8 ; i++) {
			int nextRow = row+dx[i];
			int nextColumn = column+dy[i];
			
			if(nextRow>=1 && nextRow<=8 && nextColumn>=1 && nextColumn<=8) {
				count++; //�̵��� ��ǥ�� ü���� �ȿ� �����ϸ� ����� �� �ϳ� ����
			}
		}
		
		System.out.println(count);
	}

}
