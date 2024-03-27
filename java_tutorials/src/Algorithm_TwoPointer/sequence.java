package Algorithm_TwoPointer;

/*
 * �������͸� Ȱ���Ͽ� Ư������ ������ �κ� ���� ���� ã��
 * �� ������ : ����Ʈ�� ���������� ���� �� 2���� �� ��ġ�� ����ϸ� ó���ϴ� �˰���
 * 
 * Ư���� �κ����� M�̶�� �� ��
 * �������� ������ ù��° ������ �ε����� ����Ű���� �Ѵ�.
 * ���� �κ����� M�� ���ٸ� count++
 * ���� �κ����� M���� ������ ������ 1 ����
 * ���� �κ����� M���� ũ�ų� ������ ������ 1 ����
 * ��� ��츦 Ȯ���� ������ �� ���� �ݺ�
 */
public class sequence {
	public static int n = 5; //�������� ����
	public static int M = 5; //ã�����ϴ� �κ���
	public static int[] arr = {1, 2, 3, 2, 5}; //��ü ����
	
	public static void main(String[] args) {
		int count = 0; //������ �����ϴ� �κ����� ����
		int intervalSum = 0; //�κ���
		int end = 0; //�� ���� �ε���
		
		//������(start)�� ���ʴ�� ������Ű�� �ݺ�
		for(int start=0 ; start<n ; start++) {
			//����(end)�� ������ ��ŭ �̵�
			while(intervalSum < M && end < n) {
				intervalSum += arr[end];
				end++;
			}
			
			//�κ����� m�� �� ī��Ʈ ����
			if(intervalSum == M) count++;
			
			intervalSum -= arr[start];
		}
		
		System.out.println(count);
	}

}
