package Algorithm_Greedy;

public class change {
	
	public static void main(String[] args) {
		//�׸��� �˰����� Ȱ���� �Ž����� ���� �ذ�
		//�׻� 10�� ����� �Ž����� N���� �� �� �ִ� ��� �� ������ �ּ� ���� ���ϱ�
		
		int n = 1260; //�Ž����� 1260������ ����
		int count = 0;; //������ ����
		
		int[] coinTypes = {500, 100, 50, 10}; //������ ����
		
		for (int i=0 ; i<4 ; i++) {
			int coin = coinTypes[i];
			count = count + n/coin;
			n = n%coin;
		}
		System.out.println(count);
	}

}
