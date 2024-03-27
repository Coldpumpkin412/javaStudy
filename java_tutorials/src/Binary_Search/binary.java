package Binary_Search;
import java.util.*;

public class binary {
	/*
	 * 이진탐색
	 * 내부 데이터가 정렬 돼있는 경우에만 사용가능
	 * 탐색 범위를 절반씩 좁혀가며 탐색(시간복잡도 : O(logN)
	 * 시작점, 끝점, 중간점 필요
	 */
	public static int binarySearch(int[] arr, int target, int start, int end) {
		while(start<=end) {
			int mid = (start+end)/2; //중간점
			
			if(arr[mid] == target) return mid; //찾은 경우 중간점의 인덱스 반환
			else if(arr[mid]>target) end = mid-1; //타겟이 중간점보다 작은경우 중간점의 왼쪽부분 확인
			else start = mid+1; //타겟이 중간점보다 큰 경우 중간점의 오른쪽부분 확인
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //원소의 개수
		int target = sc.nextInt(); //찾고자 하는 데이터
		int[] arr = new int[n];
		
		for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt(); //원소입력
		
		//이진탐색 수행결과
		int result = binarySearch(arr, target, 0, n-1);
		
		if(result==-1) System.out.print("원소가 존재하지 않습니다");
		else System.out.print(result + 1);
	}

}
