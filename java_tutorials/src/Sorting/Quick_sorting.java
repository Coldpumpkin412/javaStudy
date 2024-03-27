package Sorting;


public class Quick_sorting {
	/*
	 * ������
	 * ��� �ð����⵵ : O(NlogN)
	 * �־��ǰ��(�̹� ���ĵ��ִ� ������) : O(N^2)
	 */
	public static void quickSort(int[] arr, int start, int end) {
		if(start >= end) return; // ���Ұ� 1���� ��� ����
		int pivot = start; //���ص�����(�ǹ�)�� ù��° ����[0]
		int left = start+1;
		int right = end;
		
		while(left<=right) {
			//�ǹ����� ū �����͸� �迭�� ���ʿ������� Ž��
			while(left <= end && arr[left] <= arr[pivot]) left++;
			//�ǹ����� ���� �����͸� �迭�� �����ʿ�������(�ǹ�+1) Ž��
			while(right > start && arr[right] >= arr[pivot]) right--;
			
			//�ε����� �����ȴٸ� �� �� ����������(arr[right])�� �ǹ��� ��ü
			if(left>right) {
				int tmp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = tmp;
			}
			//�ε����� �������� �ʾҴٸ� ����������(arr[right]�� ū ������(arr[left])�� ��ü
			else {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
			
			//���� ���� ���� �κа� ������ �κ��� ���� ��������� ȣ���Ͽ� ����
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
