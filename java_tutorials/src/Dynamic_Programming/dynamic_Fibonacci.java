package Dynamic_Programming;

public class dynamic_Fibonacci {
	/*
	 * ���̳��� ���α׷��� ������� �Ǻ���ġ ���� ����
	 * ���Ҿ� ��� Ȱ��
	 */
	public static long[] d = new long[100];
	
	public static void main(String[] args) {
		d[1]=1;
		d[2]=1;
		int n=50; //n��° �Ǻ���ġ �� 
		
		//���Ҿ� ���(�ݺ���)���� ����
		for(int i=3 ; i<=n ; i++) {
			d[i] = d[i-1]+d[i-2];
		}
		
		System.out.print(d[n]);
	}

}
