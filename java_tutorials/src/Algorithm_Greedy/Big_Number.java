package Algorithm_Greedy;
import java.util.Scanner;
import java.util.Arrays;
public class Big_Number {

	public static void main(String[] args) {
		//그리디 알고리즘을 활용한 큰 수의 법칙 문제해결
		//첫째 줄에 N, M, K의 자연수가 주어지며 공백으로 구분
		//둘째 줄에 N개의 자연수 입력, 공백으로 구분
		//K<=M
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //입력할 자연수
		int M = sc.nextInt(); //M번 더하기
		int K = sc.nextInt(); //연속 K번 초과로 더할 수 없음
		
		int[] number = new int[N]; //숫자 저장배열
		
		for(int i=0 ; i<N ; i++) {
			number[i] = sc.nextInt();
		}
		Arrays.sort(number); //입력받은 수 정렬
		
		int first = number[N-1]; //가장 큰 수
		int second = number[N-2]; //두번째로 큰 수
		
		int count = (M / (K+1)) * K; //가장 큰 수가 더해지는 횟수
		count = count + (M % (K+1));
		
		int result = 0; //결과값
		result = result + (count*first); //가장 큰 수 더하기
		result = result + (M-count)*second; //두번째로 큰 수 더하기
		
		System.out.println(result);
	}

}
