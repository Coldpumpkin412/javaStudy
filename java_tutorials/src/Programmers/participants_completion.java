package Programmers;
import java.util.HashMap;

//���α׷��ӽ� �������� ���� ���� ����
public class participants_completion {
	public String solution(String[] participant, String[] completion) {
		/* �ؽø� Ȱ���Ͽ� Ǯ��
		 * �ؽô� Key�� Value�� ����(��ȭ��ȣ�ο� ���)
		 * Key�� ������ �̸�, Value�� count�� ���� HashMap �����
		 */
		String answer = "";
		//1. Hashmap �����(participant)
		HashMap<String, Integer> map = new HashMap<>(); //Key�� String, value�� int
		//getOrDefault : player�� ���� ���ٸ� 0��, �ִٸ� �ִ� ���� 1�� ���� �ٽ� �ִ´� 
		//���������� �ִٸ� value�� 2 �̻��� �Ǵ� ��
		for(String player : participant) {
			map.put(player, map.getOrDefault(player, 0)+1);
			//��� Ȯ�ο� System.out.print(map); => {leo=1}{leo=1, kiki=1}{leo=1, eden=1, kiki=1}
		}
	
		//2. Hashmap ����(completion)
		for(String player : completion) {
			//get�Լ��� key���� ���� value�� �������� ��
			//�������� value�� 1�� ����, ���������� �ִٸ� 0�� �ƴ� ���� ���Ե�
			map.put(player, map.get(player) -1);
		}
		//System.out.print(map);
		//3. value(count)�� 0�� �ƴ� ���� ã��
		for(String key : map.keySet()) {
			//keySet() : ���� ������ �ִ� Ű���� �迭�� ����ִ� ��
			if(map.get(key) != 0) {
				answer = key;
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] part = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] comp = {"josipa", "filipa", "marina", "nikola"};
		participants_completion sol = new participants_completion();
		System.out.print(sol.solution(part, comp));
	}

}
