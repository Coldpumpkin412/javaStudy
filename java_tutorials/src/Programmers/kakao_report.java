package Programmers;
import java.util.*;

//프로그래머스 카카오 신고결과받기 문제

public class kakao_report {
	public int[] solution(String[] id_list, String[] report, int k) {
		//HashSet을 활용하여 report의 중복된 정보를 제거(HashSet에 담는순간 중복은 모두 사라짐)
		/*신고자 목록을 Hash로 생성 (notifyListHash)
		 * (신고 당한사람이 Key값이 되고, 해당 키 값을 기준으로 신고한 사람을 List로 관리)
		 * List의 사이즈를 가지고 정지여부 확인 가능
		 */
		// 신고한 사용자가 메일을 몇번 받았는지 값을 저장하는 Hash또한 생성(reportHash)
		
		int[] answer = new int[id_list.length];
		
		//1.중복제거
		HashSet<String> reportSet = new HashSet<>();
		for(String str : report) reportSet.add(str);
		
		//2.notifyListHash 생성(Key는 String(신고 받은사람), Value는 ArrayList(신고한사람들))
		HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
		for(String str : reportSet) {
			int blankidx = str.indexOf(" "); //띄어쓰기의 인덱스 찾기
			String reporter = str.substring(0, blankidx); //0부터 띄어쓰기 한 곳 까지 사람 : 신고자
			String reportee = str.substring(blankidx+1); //띄어쓰기 이후 : 피 신고자
			
			//notifyListHash안에 피신고자의 이름으로 ArrayList가 있다면 가져오고 없다면 null값을 가져온다
			ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
			//처음 신고를 받은거라면 리스트를 생성한다
			if(reporterList == null) reporterList = new ArrayList<>();
			

			reporterList.add(reporter);	//신고자리스트에 신고자를 추가
			notifyListHash.put(reportee, reporterList); //해당 신고자 리스트를 Hash에 추가
		}
		
		//3.notifyListHAsh를 기반으로 reporterHash만들기
		HashMap<String, Integer> reporterHash = new HashMap<>();
		for(ArrayList<String> notifyList : notifyListHash.values()) {
			if(notifyList.size() >= k) {
				for(String reporter : notifyList) {
					reporterHash.put(reporter, reporterHash.getOrDefault(reporterHash, 0) +1);
				}
			}
		}
		
		for(int i=0 ; i<id_list.length ; i++) {
			//key는 기본적으로 id_list[i]를 넣고 없을경우 0을 담는다
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
