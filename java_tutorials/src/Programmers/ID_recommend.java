package Programmers;
import java.util.*;

public class ID_recommend {
	public String solution(String new_id) {
		String answer="";
		
		new_id = new_id.toLowerCase(); //1단계: 소문자 치환
		new_id = new_id.replaceAll("[^a-z\\d\\-_.]*", ""); //2단계: 조건에 맞지않는 문자 제거
		//'^'가 '[]'안에 존재할 경우 부정의 의미
		//'\'두번 사용해야 정상적인 검사 가능
		// \d는 0~9숫자 의미	
		
		new_id = new_id.replaceAll("\\.{2,}","."); // 3단계: .이 2회 이상인 경우 .으로 치환
		new_id = new_id.replaceAll("^[.]|[.]$", ""); // 4단계: 처음과 끝이 .인경우 제거
		// '^'가 '[]' 밖에 있는 경우 문자의 시작을 의미 , '|'는 OR연산자
		//[.]$는 문자열 끝이 . 인 경우를 의미
		
		if(new_id.length()==0) new_id+="a"; //5단계: 비어있는 경우 a대입
		
		if(new_id.length()>=16) new_id = new_id.substring(0,15); //6단계: 16자 이상이면 15자 이후는 제거
		new_id = new_id.replaceAll("[.]$", ""); //6단계: 끝에가 마침표면 제거
		
		while(new_id.length()<=2) {
			new_id += new_id.charAt(new_id.length()-1); //7단계
		}

		return new_id;
	}
	public static void main(String[] args) {
		String new_id = "123_.def";
		ID_recommend sol = new ID_recommend();
		
		System.out.print(sol.solution(new_id));
	}

}
