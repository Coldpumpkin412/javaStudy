package Programmers;


//���α׷��ӽ� ���� ū ����
public class NextNumber {
	
	public int solution(int n) {
		/*
		 * Integer.bitCount() ���
		 * �Ű������� 2����ȯ ������ �� 1�� ���� ��ȯ
		 */
		int answer=0;
		int i= n+1;
		
		while(Integer.bitCount(n) != Integer.bitCount(i)) {
			i++;
		}
		
		return i;
	}

	public static void main(String[] args) {
		int n=78;
		
		NextNumber sol = new NextNumber();
		
		System.out.print(sol.solution(n));
	}

}
