package org.opentutoirals.javatutorials.method;

public class MethodDemo6 {
	public static String numbering(int init, int limit) {
		int i = init;
		//��������� ���ڸ� output�̶�� ������ ��� ���� ������ �� �� �ο�
		String output = "";
		while(i<limit) {
			//���ڸ� ȭ�鿡 ����ϴ� ��� ���� output�� ���
			output += i;
			i++;
		}
		// �߿�! output�� ��� ���ڿ��� �޼ҵ� �ܺη� ��ȯ�Ϸ��� 
		//�Ʒ�ó�� return�� ��ġ
		return output; //�ڹٴ� return�� ������ �޼ҵ� �ݵ�� ����
	}

	public static void main(String[] args) {
		String result = numbering(1,5);
		System.out.println(result); //��� : 1234
	}

}
