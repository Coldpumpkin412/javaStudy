package DFS_BFS;

public class Example_RECURSIVE {

	public static void main(String[] args) {
		//����Լ��� �̿��� '���丮��'���� �ذ�
		//5! �� ����Լ��� ǥ��
		System.out.println(factorial(5));
	}
	
	public static int factorial(int n) {
		if(n<=1) return 1;
		
		return n * factorial(n-1);
	}

}
