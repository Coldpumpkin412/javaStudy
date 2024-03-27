package Programmers;
import java.util.*;

//프로그래머스 끝말잇기문제
public class word {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int[] count = new int[n]; //인원별 몇번째 시도인지 체크
		List<String> list = new ArrayList<>(); //사용된 단어 저장리스트
		
		for(int i=0 ; i<n ; i++) count[i]++; //시도 횟수 초기값 1로 시작
		
		list.add(words[0]); //첫번째 단어 저장
		
		for(int i=1 ; i<words.length ; i++) {
			if(words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0)) {
				for(int j=0 ; j<list.size() ; j++) {
					if(list.get(j).equals(words[i])) { //이전에 나온 단어
						answer[0] = i%n+1;
						answer[1] = count[i%n];
					}
				}
				list.add(words[i]); //새로운 단어일때 저장리스트에 추가
				count[i%n]++; //시도 횟수 추가
			}else {
				answer[0] = i%n+1;
				answer[1] = ++count[i%n];
			}
			
		}
		
		for(int i=0 ; i<2 ; i++) System.out.print(answer[i]);
		return answer;
		
	}
	public static void main(String[] args) {
		int n=2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		word sol = new word();
		
		System.out.print(sol.solution(n, words));
	}

}
