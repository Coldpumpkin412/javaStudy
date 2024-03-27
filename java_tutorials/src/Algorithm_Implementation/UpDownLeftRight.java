package Algorithm_Implementation;
import java.util.*;

public class UpDownLeftRight {

	public static void main(String[] args) {
		//구현을 활용하여 '상하좌우'문제 해결
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //공간의 크기 N입력
		sc.nextLine(); //버퍼 비우기
		String[] plans = sc.nextLine().split(" "); //공백을 기준으로 문자열나누기
		int x=1, y=1;
		
		//L,R,U,D에 따른 이동방향
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		char[] moveTypes = {'L', 'R', 'U', 'D'};
		
		//이동계획 하나씩 확인
		for(int i=0 ; i<plans.length ; i++) {
			char plan = plans[i].charAt(0);
			int nx = -1;
			int ny = -1;
			
			//이동계획 하나씩 확인
			for(int j=0 ; j<4 ; j++) { 
				if(plan == moveTypes[j]) {
					//이동 후 좌표
					nx = x+dx[j];
					ny = y+dy[j];
				}
			}
			//좌표 넘어가는경우 무시
			if(nx<1 || ny <1 || nx>N || ny>N) continue;
			
			//이동
			x=nx;
			y=ny; 
		}
		System.out.println(x+" "+y);
	}

}
