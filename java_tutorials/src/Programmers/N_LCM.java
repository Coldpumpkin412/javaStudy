package Programmers;

//프로그래머스 N개의 수 최소공배수 구하기
public class N_LCM {
	/*
	 * 유클리드 호제법 황용.
	 * 두 수 a,b의 최대공약수를(a,b)라고 한다면. a를 b로 나눈 나머지를 r이라고 했을 때
	 * (a,b) = (b,r)이 성립한다.
	 * r이 0이 될때까지 반복했을 때 b의 값이 최대공약수가 된다.
	 * 원소가 3개 이상이라면 앞에 2개의 원소들의 최소공배수와 이후 값들의 최소공배수를 구하면 된다
	 */
	public int solution(int[] arr) {
		int answer = 0;
		int g = gcd(arr[0],arr[1]); //처음 두 원소의 최대공약수
		answer = (arr[0]*arr[1])/g; //처음 두 원소의 최소공배수
		
		if(arr.length==1) return arr[0]; //원소가 한 개 인 경우 바로 출력
		
		if(arr.length>2) {
			for(int i=2 ; i<arr.length ; i++) {
				g = gcd(answer,arr[i]);
				answer = (answer*arr[i])/g;
			}
		}
		return answer;
	}
	
	private static int gcd(int num1, int num2) {
		int r = num1%num2; //나머지
		if(r==0) return num2;
		else return gcd(num2,r);
	}
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		
		N_LCM sol = new N_LCM();
		System.out.print(sol.solution(arr));
	}

}
