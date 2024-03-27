package Algorithm_Greedy;
import java.util.Scanner;

public class Number_Card {

	public static void main(String[] args) {
		//그리디 알고리즘을 활용한 숫자카드게임해결
		//N x M행렬 모양의 카드꼴이 존재
		//각 행에서 제일 낮은 수 중에 제일 큰 수를 찾아야한다.
		//카드는 1~10000의 숫자를 가진다.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //행의 개수
		int M = sc.nextInt(); //열의 개수
		int result = 0;
		
		for(int i=0 ; i<N ;i++) {
			int min_value = 10001;
			for(int j=0 ; j<M ;j++) {
				int number = sc.nextInt(); //배열 값 입력
				min_value = Math.min(min_value, number); //작은 값 비교
			}
			
			result = Math.max(result, min_value);
			//가장 작은 수 중 제일 큰 수 
		}
		
		System.out.println(result);
	}

}
