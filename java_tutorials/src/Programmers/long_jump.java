package Programmers;

/*
 * ���α׷��ӽ� �ָ��ٱ� ����
 * �� ���� 1ĭ Ȥ�� 2ĭ�� �� �� ���� �� Nĭ ���� �� �� �ִ� ����� ����?
 * �� ���� 1234567�� ���� ���� ���϶�
 */
public class long_jump {
	/*
	 * nĭ ���� �̵��ϴ� ����� �� : n-1ĭ ���� �̵��ϴ� ����� �� + n-2ĭ���� �̵��ϴ� ����� ��
	 * 1ĭ�� �̵��ϴ� ����� �� : 1��
	 * 2ĭ�� �̵��ϴ� ����� �� : 2��
	 * 
	 * ���̳��� ���α׷��� Ȱ���Ͽ� �ð� ���̱�
	 */
	
	public long solution(int n) {
		long answer[] = new long[2001];
		
		answer[1] = 1; //�� ĭ�� �ٴ� ����� �� : 1
		answer[2] = 2; //�� ĭ�� �ٴ� ����� �� : 2
		
		for(int i=3 ; i<=n ; i++) answer[i] = (answer[i-1]+answer[i-2]) % 1234567;
		
		return answer[n];
	}
	public static void main(String[] args) {
		int n=3;
		
		long_jump sol = new long_jump();
		System.out.print(sol.solution(n));

	}

}
