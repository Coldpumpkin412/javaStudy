package Binary_Search;
import java.util.*;


public class ricecake {
	/*
	 * 이진탐색을 활용하여 떡볶이 떡 만들기 문제풀이
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //떡의 개수
		int m = sc.nextInt(); //요청한 떡의 길이
		
		//각 떡의 개별 길이 정보
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt();
		
		int start = 0 ; //이진탐색에 활용할 시작점
		int end = (int) 1e9; //제시된 기준높이가 10억 이하이므로 초기값 이렇게 설정
		int result = 0;
		
		while(start<=end) {
			long total=0;
			int mid=(start+end)/2; //중간값
			
			for(int i=0 ; i<n ; i++) {
				//떡이 절단기보다 길면 자른 후 잘린 길이 합 구하기
				if(arr[i]>mid) total += (arr[i]-mid); 
			}
			if(total<m) end = mid-1; //잘린 떡의 길이가 요청보다 적으면 절단기 왼쪽으로 이동
			else {
				result = mid;
				start = mid+1;
			}
			
		}
		System.out.print(result);
	}

}
