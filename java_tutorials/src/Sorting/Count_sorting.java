package Sorting;


public class Count_sorting {
	/*
	 * 계수정렬
	 * 시간복잡도 및 공간복잡도 : O(N+K) //K:데이터의 최대값
	 * 데이터의 범위가 모두 담길 수 있는 리스트(배열) 선언해야한다 //공간복잡도가 높지만, 더 빠르게 동작
	 * 각각의 데이터가 몇번 등장하는지 계수를 카운팅 한다.
	 * 동일한 값을 가지는 데이터가 여러개 등장할 때 효율적
	 */
	public static void main(String[] args) {
		int[] arr = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};
		
		//배열의 최소값(0)부터 최대값(9)를 다 담기 위해 10짜리 배열 선언
		int[] count = new int[10];
		
		for(int i=0 ; i<arr.length ; i++) {
			count[arr[i]]++; //각 데이터에 해당하는 인덱스 값 증가
		}
		
		for(int i=0 ; i<count.length ; i++) {
			for(int j=0 ; j<count[i] ; j++) { //해당 인덱스의 등장 회수만큼 출력
				System.out.print(i +" ");
			}
		}

	}

}
