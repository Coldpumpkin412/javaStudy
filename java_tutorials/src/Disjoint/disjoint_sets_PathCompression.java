package Disjoint;
import java.util.*;

/*
 * ���μ����� �ڷᱸ��
 * ��ξ���(Path Compression)�� ���� ���μ� �ڷᱸ�� ����
 * 
 * find�Լ��� ��������� ȣ���� �� �θ����̺� ���� �����Ѵ�.
 * ���� ������ ��Ʈ��忡 ������ �� �ִ�
 */
public class disjoint_sets_PathCompression {
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
		
		//Union ���� ���� ����
		for(int i=0 ; i<e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			unionParent(a,b);
		}
		
		//�� ���Ұ� ���� ���� ���
		System.out.print("�� ���Ұ� ���� ����: ");
		for(int i=1 ; i<=v ; i++) System.out.print(findParent(i) + " ");
		System.out.println();
		
		//�θ� ���̺� ���� ���
		System.out.print("�θ� ���̺�: ");
		for(int i=1 ; i<=v ; i++) System.out.print(parent[i] + " ");
		System.out.println();
	}

}
