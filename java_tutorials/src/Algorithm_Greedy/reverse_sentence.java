package Algorithm_Greedy;
import java.util.*;

/*
 * 문자열 뒤집기 문제
 * 0과 1로만 이루어진 문자열 S가 있을 때, 이 문자열의 모든 숫자를 전부 같게 만드려고한다.
 * 이 때 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것만 가능하다.
 */
public class reverse_sentence {
	public static String s; 
	public static int count0; //전부 0으로 바꾸는 경우
	public static int count1; //전부 1로 바꾸는 경우
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		
		//첫 번째 원소 처리
		if(s.charAt(0)=='1') count0++;
		else count1++;
		
		//두 번째 원소부터 확인
		for(int i=0 ; i<s.length()-1 ; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				if(s.charAt(i+1) == '1') count0++; //다음 수에서 1로 바뀌는경우
				else count1++; //다음 수에서 0으로 바뀌는 경우
			}
		}
		
		System.out.println(Math.min(count1, count0));
	}

}
