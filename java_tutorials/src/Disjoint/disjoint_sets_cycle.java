package Disjoint;
import java.util.*;

/*
 * ���μ� ������ Ȱ���Ͽ� ������ �׷��� ������ ����Ŭ ���� �Ǻ� ����
 * (���� �׷��������� ����Ŭ ���δ� DFSȰ��)
 * 
 * 1.�� ������ Ȯ���Ͽ� �� ����� ��Ʈ��带 Ȯ��(find ����)
 *   �� ��, �� ����� ��Ʈ��尡 �ٸ��ٸ� union ���� ����
 *   �� ����� ��Ʈ��尡 ���ٸ� ����Ŭ�� �߻��� ��
 * 2.�׷����� ���� ���ִ� ��� ������ ���� 1�������� �ݺ�
 */
public class disjoint_sets_cycle {
	//����� ���� v, ����(Union ����)�� ���� e
	//��� ������ �ִ� 100,000���� ����
	public static int v,e;
	public static int[] parent = new int[100001]; //�θ����̺� �ʱ�ȭ
	
	//Ư�� ���Ұ� ���� ���� ã��
	public static int findParent(int x) {
		//��Ʈ��尡 �ƴ϶�� ��Ʈ��带 ã�� ������ ����� ȣ��
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]); //�����Ⱥκ�(�θ����̺� ���� �� �� �κ��� ��ȯ)
	}
	
	//�� ���Ұ� ���� ���� ��ġ��
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		//�� ���� ��ȣ�� ��尡 �θ���
		if(a<b) parent[b] = a;
		else parent[a] = b;
	} 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		//�θ� ���̺��� �θ� �ڱ��ڽ����� �ʱ�ȭ
		for(int i=1 ; i<=v ; i++) parent[i] = i;
		
		boolean cycle = true; //����Ŭ �߻�����
		
		for(int i=0 ; i<e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			//����Ŭ�� �߻��� ���(��Ʈ��尡 ���ٸ�) ����
			if(findParent(a) == findParent(b)) {
				cycle = true;
				break;
			}
			//����Ŭ�� �߻����� �ʾҴٸ� ������ ����(union) ����
			else {
				unionParent(a,b);
			}
		}
		
		if(cycle) System.out.println("����Ŭ�� �߻��߽��ϴ�.");
		else System.out.println("����Ŭ�� �߻����� �ʾҽ��ϴ�.");
	}

}
