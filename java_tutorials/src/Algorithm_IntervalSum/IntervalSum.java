package Algorithm_IntervalSum;
import java.util.*;

/*
 * 구간 합 빠르게 계산하기 알고리즘
 * 
 * 연속적으로 나열된 N개의 수가 있을 때 특정 구간의 모든 수를 합한 값 구하기
 * 1. N개의 수 에 대하여 접두사 합(Prefix Sum)을 계산 후 배열 P에 저장
 * 2. 매 M개의 쿼리정보[L,R]을 확인할 때 구간합은 P[R]-P[L-1]이 된다.
 */
public class IntervalSum {
	public static int n=5; //데이터의 개수 n과 데이터 입력받기
	public static int arr[] = {10, 20, 30, 40, 50};
	public static int[] prefixSum = new int[6];
	
	public static void main(String[] args) {
		//접두사 합(prefix Sum) 배열 계산
		int sum = 0;
		
		for(int i=0 ; i<n ; i++) {
			sum += arr[i];
			prefixSum[i+1] = sum;
		}
		
		//구간 합 계산(ex. 세 번째 수부터 네 번째 수까지)
		int left = 3;
		int right = 4;
		System.out.println(prefixSum[right] - prefixSum[left-1]);
	}

}
