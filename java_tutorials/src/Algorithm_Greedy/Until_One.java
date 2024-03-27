package Algorithm_Greedy;
import java.util.Scanner;

public class Until_One {

	public static void main(String[] args) {
		//그리디 알고리즘을 활용하여 '1이 될 때까지' 문제해결
		//어떤 수 N이 1이 될 때까지 다음 두 과정 중 하나를 반복
		//1. N에서 1을 빼기, 2. N을 K로 나눈다
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int count = 0; //연산 횟수 확인
		
		while(N!=1) {
			if(N%K == 0) {
				N /= K; //N을 K로 나눌 수 있으면 바로 나눠줌
				count++;
			}
			else {
				N -= 1; //N을 K로 나눌 수 있을때까지 1씩 뺀다
				count++;
			}
			
		}
		
		System.out.println(count); //N이 1이 됐을때 연산횟수 출력
		
	}

}
