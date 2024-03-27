package BaekJoon;
import java.util.*;
import java.io.*;


public class Practice {
	
	static int N;
	
	static boolean check;
	
	//selection_sort함수(배열, 교환횟수)
	static void selection_sort(int[] num, int[] num2) {
		
		//가장 큰 인덱스부터 두 번째 인덱스까지
		for(int last = num.length-1 ; last>=2 ; last--) {
			int max = 0;
			int index = -1;
			
			//배열인덱스 1~last 까지의 값중 최댓값의 인덱스 찾기
			for(int i=1 ; i<=last ; i++) {
				if(max < num[i]) {
					max = num[i];
					index = i;
				}
			}
			
			//최댓값의 인덱스가 끝 인덱스가 아닌경우 두 배열값 교환
			if(last != index) {
				int tmp = num[index];
				num[index] = num[last];
				num[last] = tmp;
			}
			
			//두 배열이 같아진 경우
			if(Arrays.equals(num, num2)) {
				//체크함수 바꾸기
				check = true;
				
				return;
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;    	
    	
    	//배열의 크기 N, 교환 횟수 K 입력
    	N = Integer.parseInt(br.readLine());
    	
    	//배열 A 선언 및 값 입력
    	int[] A = new int[N+1];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=1 ; i<=N ; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	//배열 B 선언 및 값 입력
    	int[] B = new int[N+1];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=1 ; i<=N ; i++) {
    		B[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	//시작부터 같은 배열인 경우 1 출력 후 종료
    	if(Arrays.equals(A, B)) {
    		System.out.print("1");
    		
    		return;
    	}
    	
    	//선택정렬 메소드 실행
    	selection_sort(A, B);
    	
    	//check가 참이면 배열출력, 아니면 -1 출력
    	System.out.println(check ? 1 : 0);
    	
    }
}	
