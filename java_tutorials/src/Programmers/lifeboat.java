package Programmers;
import java.util.*;

//프로그래머스 구명보트 문제
public class lifeboat {
	
	public int solution(int[] people, int limit) {
		int answer=0;
		int min=0;
		
		Arrays.sort(people);
		
		for(int i=people.length-1 ; i >= min ; i++) {
			if(people[i]+people[min] <= limit) {
				min++;
				answer++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] people = {70,50,80,50};
		int limit = 100;
		
		lifeboat sol = new lifeboat();
		
		System.out.print(sol.solution(people, limit));

	}

}
