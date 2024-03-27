package Algorithm_Greedy;
import java.util.*;

/*
 * 곱하기 혹은 더하기 문제
 * 각자리가 0~9로 이루어진 문자열 S가 주어졌을 때
 * 각 숫자 사이에 X 혹은 + 연산자를 넣어 만들어질 수 있는 결과값중 최대값을 구하기
 * 연산순서는 무조건 왼쪽에서 오른쪽으로 진행
 */
public class sum_multiply {
	public static String s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		s = sc.next(); //문자열 입력
		
		//연산순서가 무조건 왼쪽에서 오른쪽이기 떄문에 0을 만나면 더하기, 이외에는 전부 곱하기
		long result = s.charAt(0)-'0'; //첫번째 인자 저장
		
		for(int i=1 ; i<s.length() ; i++) {
			
			//두 수 중 하나라도 0혹은1 인경우 더하기를 수행
			if(result<=1 || s.charAt(i)-'0'<=1) { 
				result += s.charAt(i)-'0';
			}else { //이외의 경우 곱하기
				result *= s.charAt(i)-'0';
			}
		}
		
		System.out.println(result);
	}

}
