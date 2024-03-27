package Disjoint;
import java.util.*;

/*
 * ���μ����� �ڷᱸ��
 * ������ ����� ã�� �������� �̷�����ִ�.
 * 1.������ ����(Union) : 2���� ���Ұ� ���Ե� ������ �ϳ��� �������� ��ġ�� ����
 * 2.ã�� ����(Find) : Ư�� ���Ұ� ���� ������ � �������� �˷��ִ� ����
 * 
 * Ʈ�� �ڷᱸ���� �̿��Ͽ� ������ ǥ��
 * 1.������ ������ Ȯ���Ͽ� ���� ����� �� ���A,B�� Ȯ���Ѵ�.
 *   �� ��, A��B�� ��Ʈ ��� A',B'�� ���� ã�´�.
 *   �� �� A'�� B'�� �θ���� �����Ѵ�(B'�� A'�� ����Ű���� �Ѵ�)
 *   *A'�� B'���� �� ���� ��ȣ�� ���´�
 * 2.��� ������ ������ ó���� �� ���� 1�� ������ �ݺ��Ѵ�.
 * 
 * �Ϸķ� �����Ǵ� ��Ȳ�� �� �� �� ��忡�� �θ���� ���� ���� �ִ� O(V)�� �ð��� �ҿ�� �� ����
 * ��������� ����� ������ V���̰� findȤ�� union ������ M���� �� ��ü �ð����⵵ : O(VM)
 * ��ȿ������ �� �� �ִ�. �� ��ξ���(Path Compression)����� ���� ���� ����
 */
public class disjoint_sets {
	//����� ���� v, ����(Union ����)�� ���� e
	//��� ������ �ִ� 100,000���� ����
	public static int v,e;
	public static int[] parent = new int[100001]; //�θ����̺� �ʱ�ȭ
	
	//Ư�� ���Ұ� ���� ���� ã��
	public static int findParent(int x) {
		//��Ʈ��尡 �ƴ϶�� ��Ʈ��带 ã�� ������ ����� ȣ��
		if(x == parent[x]) return x;
		return findParent(parent[x]);
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
