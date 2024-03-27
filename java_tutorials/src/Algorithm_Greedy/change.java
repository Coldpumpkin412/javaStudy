package Algorithm_Greedy;

public class change {
	
	public static void main(String[] args) {
		//그리디 알고리즘을 활용한 거스름돈 문제 해결
		//항상 10의 배수인 거스름돈 N원을 줄 수 있는 방법 중 동전의 최소 개수 구하기
		
		int n = 1260; //거스름돈 1260원으로 가정
		int count = 0;; //동전의 개수
		
		int[] coinTypes = {500, 100, 50, 10}; //동전의 종류
		
		for (int i=0 ; i<4 ; i++) {
			int coin = coinTypes[i];
			count = count + n/coin;
			n = n%coin;
		}
		System.out.println(count);
	}

}
