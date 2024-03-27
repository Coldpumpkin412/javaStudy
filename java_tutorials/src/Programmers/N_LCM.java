package Programmers;

//���α׷��ӽ� N���� �� �ּҰ���� ���ϱ�
public class N_LCM {
	/*
	 * ��Ŭ���� ȣ���� Ȳ��.
	 * �� �� a,b�� �ִ�������(a,b)��� �Ѵٸ�. a�� b�� ���� �������� r�̶�� ���� ��
	 * (a,b) = (b,r)�� �����Ѵ�.
	 * r�� 0�� �ɶ����� �ݺ����� �� b�� ���� �ִ������� �ȴ�.
	 * ���Ұ� 3�� �̻��̶�� �տ� 2���� ���ҵ��� �ּҰ������ ���� ������ �ּҰ������ ���ϸ� �ȴ�
	 */
	public int solution(int[] arr) {
		int answer = 0;
		int g = gcd(arr[0],arr[1]); //ó�� �� ������ �ִ�����
		answer = (arr[0]*arr[1])/g; //ó�� �� ������ �ּҰ����
		
		if(arr.length==1) return arr[0]; //���Ұ� �� �� �� ��� �ٷ� ���
		
		if(arr.length>2) {
			for(int i=2 ; i<arr.length ; i++) {
				g = gcd(answer,arr[i]);
				answer = (answer*arr[i])/g;
			}
		}
		return answer;
	}
	
	private static int gcd(int num1, int num2) {
		int r = num1%num2; //������
		if(r==0) return num2;
		else return gcd(num2,r);
	}
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		
		N_LCM sol = new N_LCM();
		System.out.print(sol.solution(arr));
	}

}
