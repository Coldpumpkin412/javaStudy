package Programmers;
import java.util.HashMap;

//프로그래머스 완주하지 못한 선수 문제
public class participants_completion {
	public String solution(String[] participant, String[] completion) {
		/* 해시를 활용하여 풀기
		 * 해시는 Key와 Value의 조합(전화번호부와 비슷)
		 * Key에 선수의 이름, Value에 count를 갖는 HashMap 만들기
		 */
		String answer = "";
		//1. Hashmap 만들기(participant)
		HashMap<String, Integer> map = new HashMap<>(); //Key는 String, value는 int
		//getOrDefault : player의 값이 없다면 0을, 있다면 있던 값에 1을 더해 다시 넣는다 
		//동명이인이 있다면 value가 2 이상이 되는 것
		for(String player : participant) {
			map.put(player, map.getOrDefault(player, 0)+1);
			//출력 확인용 System.out.print(map); => {leo=1}{leo=1, kiki=1}{leo=1, eden=1, kiki=1}
		}
	
		//2. Hashmap 제거(completion)
		for(String player : completion) {
			//get함수로 key값을 통해 value를 가져오게 됨
			//완주자의 value는 1씩 제거, 동명이인이 있다면 0이 아닌 값이 남게됨
			map.put(player, map.get(player) -1);
		}
		//System.out.print(map);
		//3. value(count)가 0이 아닌 주자 찾기
		for(String key : map.keySet()) {
			//keySet() : 맵이 가지고 있는 키들을 배열로 담아주는 것
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
