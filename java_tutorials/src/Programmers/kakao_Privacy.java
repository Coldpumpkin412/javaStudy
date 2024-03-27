package Programmers;
import java.util.*;


//프로그래머스 kakao blind recruitment 개인정보 수집 유효기간 문제
public class kakao_Privacy {
	/*
	 * today변수는 "YYYY.MM.DD"형태의 오늘날짜
	 * terms 배열의 원소는 공백하나를 기준으로 약관종류 및 유효기간 표현(유효기간은 1~100)
	 * privacies 배열의 원소는 i+1번째 개인정보의 수집 일자 및 약관종류 나타냄
	 * privacies 배열의 원소는 공백 하나를 기준으로 날짜 및 약관 종류 표현(날짜는 today 이전 날짜만)
	 * 날짜는 점(.) 하나로 구분
	 */
	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer=new ArrayList<>();
		HashMap<String, Integer> standard = new HashMap<>();
		
		//오늘 날짜
		String[] t = today.split("\\."); //점을 기준으로 분해
		int tCount = Integer.parseInt(t[0])*12*28 + Integer.parseInt(t[1])*28 + Integer.parseInt(t[2]);
		
		for(String i : terms) {
			String[] arr = i.split(" ");
			standard.put(arr[0], Integer.parseInt(arr[1]));
		}
		
		for(int i=0 ; i<privacies.length ; i++) {
			int year = Integer.parseInt(privacies[i].substring(0,4)); //연도
			int month = Integer.parseInt(privacies[i].substring(5,7)); //월
			int day = Integer.parseInt(privacies[i].substring(8,10)); //일
			
			String type = privacies[i].substring(11,12); //약관종류
			
			int tp = standard.get(type); //해시맵에서 약관종류의 유효기간 가져오기
			
			month += tp;
			
			Integer tmp = year*12*28 + month*28 + day -1; //유효기간 마지노선
			
			if(tCount > tmp) answer.add(i+1);
		}
		
		return answer.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		String today =  "2022.05.19";
		String[] terms ={"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		kakao_Privacy sol = new kakao_Privacy();
		
		System.out.println(sol.solution(today, terms, privacies));
	}
	
}
