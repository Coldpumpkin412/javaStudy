package Dynamic_Programming;
import java.util.*;

public class Make_one {
	/*
	 * 1�θ���� ����
	 * 
	 */
	public static int[] d = new int[30001]; //�־��� ������ 30000����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		//���̳������α׷���(���Ҿ�)
		for(int i=2 ; i<=x ; i++) {
			d[i] = d[i-1]+1; //������ ������ 1�� ���� ���
			
			//2�� ����������� ���
			if(i%2==0) d[i] = Math.min(d[i], d[i/2]+1);
			//3���� ������ �������� ���
			if(i%3==0) d[i] = Math.min(d[i], d[i/3]+1);
			//5�� ������ �������� ���
			if(i%5==0) d[i] = Math.min(d[i], d[i/5]+1);
		}
		
		System.out.print(d[x]);
	}

}
