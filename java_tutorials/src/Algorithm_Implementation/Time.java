package Algorithm_Implementation;
import java.util.*;

public class Time {
	
	public static boolean check(int h, int m, int s) {
		//특정 시간에 3이 포함돼있는지 확인
		if(h%10==3 || m/10==3 || m%10==3 || s/10==3 || s%10==3) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		//구현을 활용하여 '시각'문제 해결
		//N시59분59초 까지 3이 하나라도 포함되는 모든 경우의 수 출력
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt(); //시간 입력
		int count = 0; //3이포함되는 횟수
		
		for(int i=0 ; i<h ; i++) {//시
			for(int j=0 ; j<60 ; j++) {//분
				for(int k=0 ; k<60 ; k++) {//초
					if(check(i,j,k)) count++;
				}
			}
		}
		System.out.println(count);
	}

}
