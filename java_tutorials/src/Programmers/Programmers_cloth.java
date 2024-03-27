package Programmers;
import java.util.*;

//���α׷��ӽ� ü���� ����
public class Programmers_cloth {
    public int solution(int n, int[] lost, int[] reserve) {
    	/*Set�� Ȱ���Ͽ� Ǯ��.
    	 * Set�� ������ ������� ����
    	 * �ߺ��� ������ ����
    	 * contains()�� �ӵ��� list���� ������ ����
    	 * �����Ͱ� ���� �ʴٸ� ���ɺ��� ������ ������ List�� Ȱ���ϴ°� ���� �� ����
    	 */
    	//1.Set �����
    	HashSet<Integer> resSet = new HashSet<>();
    	HashSet<Integer> lostSet = new HashSet<>();
    	
    	for(int i : reserve) resSet.add(i);
    	for(int i : lost) {
    		//������ ü������ �ִ� �л��� ���ϸ¾Ҵ��� 1���� Ȯ��
    		if(resSet.contains(i)) resSet.remove(i); //������ ���ϸ¾����� ������ ���»���
    		else lostSet.add(i); //������ ���� ���� �¾Ҵٸ� lostSet�� �߰�
    	}
    	
    	//2.������ �������� ��,�� ���� Ȯ��. ü���� �����ֱ�
    	for(int i : resSet) {
    		if(lostSet.contains(i-1)) lostSet.remove(i-1);
    		else if(lostSet.contains(i+1)) lostSet.remove(i+1);
    	}
    	//3.��ü�л�-lost Set ���ϱ�

        return n-lostSet.size();
    }

	public static void main(String[] args) {
		Programmers_cloth sol = new Programmers_cloth();
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.print(sol.solution(5, lost, reserve));
	}

}
