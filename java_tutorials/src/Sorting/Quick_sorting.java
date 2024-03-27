package Sorting;


public class Quick_sorting {
	/*
	 * 퀵정렬
	 * 평균 시간복잡도 : O(NlogN)
	 * 최악의경우(이미 정렬돼있는 데이터) : O(N^2)
	 */
	public static void quickSort(int[] arr, int start, int end) {
		if(start >= end) return; // 원소가 1개인 경우 종료
		int pivot = start; //기준데이터(피벗)은 첫번째 원소[0]
		int left = start+1;
		int right = end;
		
		while(left<=right) {
			//피벗보다 큰 데이터를 배열의 왼쪽에서부터 탐색
			while(left <= end && arr[left] <= arr[pivot]) left++;
			//피벗보다 작은 데이터를 배열의 오른쪽에서부터(피벗+1) 탐색
			while(right > start && arr[right] >= arr[pivot]) right--;
			
			//인덱스가 엇갈렸다면 그 중 작은데이터(arr[right])와 피벗을 교체
			if(left>right) {
				int tmp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = tmp;
			}
			//인덱스가 엇갈리지 않았다면 작은데이터(arr[right]와 큰 데이터(arr[left])를 교체
			else {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
			
			//분할 이후 왼쪽 부분과 오른쪽 부분을 각각 재귀적으로 호출하여 정렬
			quickSort(arr, start, right-1);
			quickSort(arr, right+1, end);
		}
	}
	public static void main(String[] args) {
		int n=10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		
		quickSort(arr,0,n-1);
		
		for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i]+" ");
		
	}

}
