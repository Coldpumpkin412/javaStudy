package Algorithm_TwoPointer;

/*
 * 투포인터를 활용하여 특정합을 가지는 부분 연속 수열 찾기
 * 투 포인터 : 리스트에 순차적으로 접근 시 2개의 점 위치를 기록하며 처리하는 알고리즘
 * 
 * 특정한 부분합을 M이라고 할 때
 * 시작점과 끝점이 첫번째 원소의 인덱스를 가리키도록 한다.
 * 현재 부분합이 M과 같다면 count++
 * 현재 부분합이 M보다 작으면 끝점을 1 증가
 * 현재 부분합이 M보다 크거나 같으면 시작점 1 증가
 * 모든 경우를 확인할 때까지 위 과정 반복
 */
public class sequence {
	public static int n = 5; //데이터의 개수
	public static int M = 5; //찾고자하는 부분합
	public static int[] arr = {1, 2, 3, 2, 5}; //전체 수열
	
	public static void main(String[] args) {
		int count = 0; //조건을 만족하는 부분합의 개수
		int intervalSum = 0; //부분합
		int end = 0; //끝 점의 인덱스
		
		//시작점(start)을 차례대로 증가시키며 반복
		for(int start=0 ; start<n ; start++) {
			//끝점(end)을 가능한 만큼 이동
			while(intervalSum < M && end < n) {
				intervalSum += arr[end];
				end++;
			}
			
			//부분합이 m일 때 카운트 증가
			if(intervalSum == M) count++;
			
			intervalSum -= arr[start];
		}
		
		System.out.println(count);
	}

}
