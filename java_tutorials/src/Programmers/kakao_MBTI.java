package Programmers;
import java.util.*;

//프로그래머스 성격유형검사 문제
public class kakao_MBTI {
	public String solution(String[] survey, int[] choices) {
		String answer = "";
		//mbti 해시맵 생성, (Key는 성격유형, Value는 값)
		HashMap<Character, Integer> mbti = new HashMap<>();
		mbti.put('R', 0);	mbti.put('T', 0);
		mbti.put('C', 0);	mbti.put('F', 0);
		mbti.put('J', 0);	mbti.put('M', 0);
		mbti.put('A', 0);	mbti.put('N', 0);
		
	
		for(int i=0 ; i<choices.length ; i++) {

			switch(choices[i]){
			case 1: mbti.put(survey[i].charAt(0), mbti.get(survey[i].charAt(0))+3); break;
			case 2: mbti.put(survey[i].charAt(0), mbti.get(survey[i].charAt(0))+2); break;
			case 3: mbti.put(survey[i].charAt(0), mbti.get(survey[i].charAt(0))+1); break;
			//case 4: mbti.put(survey[i].charAt(i), mbti.get(survey[i].charAt(i))+3); break;
			case 5: mbti.put(survey[i].charAt(1), mbti.get(survey[i].charAt(1))+1); break;
			case 6: mbti.put(survey[i].charAt(1), mbti.get(survey[i].charAt(1))+2); break;
			case 7: mbti.put(survey[i].charAt(1), mbti.get(survey[i].charAt(1))+3); break;
			}
			
		}
		
		answer += (mbti.get('R') >= mbti.get('T')) ? 'R' : 'T';
		answer += (mbti.get('C') >= mbti.get('F')) ? 'C' : 'F';
		answer += (mbti.get('J') >= mbti.get('M')) ? 'J' : 'M';
		answer += (mbti.get('A') >= mbti.get('N')) ? 'A' : 'N';
		
		return answer;
	}
	
	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5,3,2,7,5};
		
		kakao_MBTI sol = new kakao_MBTI();
		
		System.out.print(sol.solution(survey, choices));
	}

}
