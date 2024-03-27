package Programmers;
import java.util.*;

public class babble {
	public int solution(String[] babbling) {
		int answer = 0;

		for(int i=0 ; i<babbling.length ; i++) {
			
			if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") ||
			   babbling[i].contains("woowoo") || babbling[i].contains("mama")) {
				babbling[i] = "wrong"; //연속해서 나오는게 있는경우 제외
			}else {
				String[] str = babbling[i].split("aya|ye|woo|ma");
				if(str.length==0) answer++;
			}
		}
		
		return answer;
		
		
	}
	public static void main(String[] args) {
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		
		babble sol = new babble();
		
		System.out.print(sol.solution(babbling));

	}

}
