package Algorithm_Greedy;
import java.util.*;

/*
 * ���谡 ��� ����(�׸��� Ȱ��)
 * N���� ���谡�� ������� '������' ����.
 * �������� X�� ���谡�� �ݵ�� X�� �̻����� ������ ���谡 �׷쿡 �����ؾ��Ѵ�. 
 * �� �� ���� �� �ִ� ���谡 �׷��� �ִ��� ���Ͻÿ�
 */
public class guild {
		public static int n;//���谡�� ��
		public static ArrayList<Integer> list = new ArrayList<>(); //������ ����
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) list.add(sc.nextInt()); //������ �Է�
		
		Collections.sort(list); //�������� ����
		
		int result = 0; //�� �׷��� ��
		int count = 0; //���� �׷쿡 ���� �� ���鰡�� ��
		
		for(int i=0 ; i<n ; i++) {
			count++; //���� �׷쿡 �ش� ���谡 ����
			if(count>=list.get(i)) {
				result++;
				count=0;
			}
		}
		
	}

}
