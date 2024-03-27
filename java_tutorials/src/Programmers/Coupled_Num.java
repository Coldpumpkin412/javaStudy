package Programmers;
import java.util.*;
import java.util.Collections;

//프로그래머스 숫자짝꿍 문제
public class Coupled_Num {
	public String solution(String X, String Y) {
		/* 
		 * StringBuilder는 가변성을 가지기떄문에 문자열의 추가,수정,삭제가 비교적 용이
		 * 하지만 동기화를 보장하지않아 단일스레드 환경에 적합
		 * StringBuffer는 동기화를 보장한다
		 * 연산속도 : StringBuilder(가장빠름) < StringBuffer < String(가장 느림)
		 */

		
		//0~9까지의 인덱스를 갖는 배열 선언
		int[] countX = new int[10];
		int[] countY = new int[10];
		
		//한글자씩 분할 후 정수로 변환하여 해당값을 인덱스로 갖는 배열을 하나씩 증가
		for(String strX : X.split("")) countX[Integer.parseInt(strX)]++;
		for(String strY : Y.split("")) countY[Integer.parseInt(strY)]++;
		
        StringBuilder sb = new StringBuilder();
		
		for(int i=9 ; i>=0 ; i--) {
			//해당 인덱스의 값이 둘 가 0보다 크다면 공통으로 갖고 있다는 뜻
			while(countX[i]>0 && countY[i]>0) {
				sb.append(i);
                countX[i]--;
                countY[i]--;
			}
		}
		
		String answer="";
        
        if ("".equals(sb.toString())) {
            answer = "-1";
        } else if ("0".equals(sb.toString().substring(0,1))) {
            answer = "0";
        } else {
            answer = sb.toString();
        }

        return answer;

	}

	public static void main(String[] args) {
		String X = "100";
		String Y = "123450";
		Coupled_Num sol = new Coupled_Num();
		
		System.out.print(sol.solution(X, Y));
	}

}
