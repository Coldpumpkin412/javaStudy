package Algorithm_Implementation;
import java.util.*;

/*
 * 럭키스트레이트 문제
 * 주어진 숫자 N의 자릴수를 기준으로 반으로 나누어 왼쪽 부분의 자릿수의 합과 오른쪽 부분의 자릿수의 합이 같다면
 * LUCKY를, 아니라면 READY를 반환하는 문제
 * 
 * 첫째줄에 정수 N을 입력(자리수는 항상 짝수)
 */
public class LuckyStraight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		
		String str = Integer.toString(N); //정수 N을 문자열로 변환
		int sum=0;
		
		for(int i=0 ; i<str.length()/2 ; i++) {
			sum += str.charAt(i)-'0'; //정수로 변환 후 값 더해주기
		}
		
		for(int i=str.length()/2 ; i<str.length() ; i++) {
			sum -= str.charAt(i)-'0';
		}
		
		if(sum==0) System.out.println("LUCKY");
		else System.out.println("READY");
		
		sc.close();
	}

}
