package Programmers;
import java.util.*;

//���α׷��ӽ� īī�� �Ű����ޱ� ����

public class kakao_report {
	public int[] solution(String[] id_list, String[] report, int k) {
		//HashSet�� Ȱ���Ͽ� report�� �ߺ��� ������ ����(HashSet�� ��¼��� �ߺ��� ��� �����)
		/*�Ű��� ����� Hash�� ���� (notifyListHash)
		 * (�Ű� ���ѻ���� Key���� �ǰ�, �ش� Ű ���� �������� �Ű��� ����� List�� ����)
		 * List�� ����� ������ �������� Ȯ�� ����
		 */
		// �Ű��� ����ڰ� ������ ��� �޾Ҵ��� ���� �����ϴ� Hash���� ����(reportHash)
		
		int[] answer = new int[id_list.length];
		
		//1.�ߺ�����
		HashSet<String> reportSet = new HashSet<>();
		for(String str : report) reportSet.add(str);
		
		//2.notifyListHash ����(Key�� String(�Ű� �������), Value�� ArrayList(�Ű��ѻ����))
		HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
		for(String str : reportSet) {
			int blankidx = str.indexOf(" "); //������ �ε��� ã��
			String reporter = str.substring(0, blankidx); //0���� ���� �� �� ���� ��� : �Ű���
			String reportee = str.substring(blankidx+1); //���� ���� : �� �Ű���
			
			//notifyListHash�ȿ� �ǽŰ����� �̸����� ArrayList�� �ִٸ� �������� ���ٸ� null���� �����´�
			ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
			//ó�� �Ű� �����Ŷ�� ����Ʈ�� �����Ѵ�
			if(reporterList == null) reporterList = new ArrayList<>();
			

			reporterList.add(reporter);	//�Ű��ڸ���Ʈ�� �Ű��ڸ� �߰�
			notifyListHash.put(reportee, reporterList); //�ش� �Ű��� ����Ʈ�� Hash�� �߰�
		}
		
		//3.notifyListHAsh�� ������� reporterHash�����
		HashMap<String, Integer> reporterHash = new HashMap<>();
		for(ArrayList<String> notifyList : notifyListHash.values()) {
			if(notifyList.size() >= k) {
				for(String reporter : notifyList) {
					reporterHash.put(reporter, reporterHash.getOrDefault(reporterHash, 0) +1);
				}
			}
		}
		
		for(int i=0 ; i<id_list.length ; i++) {
			//key�� �⺻������ id_list[i]�� �ְ� ������� 0�� ��´�
			answer[i] = reporterHash.getOrDefault(id_list[i], 0);
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k=2;
		
		kakao_report sol = new kakao_report();
		System.out.print(sol.solution(id_list, report, k));
	}

}
