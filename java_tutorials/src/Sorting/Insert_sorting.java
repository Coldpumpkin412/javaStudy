package Sorting;

//삽입정렬
public class Insert_sorting {

	public static void main(String[] args) {
		int n=10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		
		//삽입정렬에서 첫번째 인덱스는 정렬돼있다고 가정 후 시작 하므로 1부터 시작
		for(int i=1 ; i<n ; i++) {
			//기준 인덱스를 기준으로 한 칸씩 왼쪽으로 이동
			for(int j=i ; j>0 ; j--) {
				if(arr[j]<arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
				else break; //자기보다 작은 데이터를 만나면 그 위치에서 멈춤
			}
		}
		
		for(int i=0 ; i<n ; i++) System.out.print(arr[i]+" ");
		}

}
