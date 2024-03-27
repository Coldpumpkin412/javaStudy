package Algorithm_Implementation;
import java.util.*;

public class Kings_knight {

	public static void main(String[] args) {
		//구현을 활용하여 '킹스나이트' 문제 해결
		//행은 1행~8행, 열은 a열~h열로 표현된다.
		//입력 문자는 a1처럼 열과 행으로 이루어짐
		Scanner sc = new Scanner(System.in);
		
		String inputData = sc.nextLine();
		//nextLine()은 엔터를 치기 전까지 쓴 문자열을 반환
		//next()는 공백(space) 전까지 쓴 문자열 반환
		int row = inputData.charAt(1) - '0'; //문자를 int로 변형
		int column = inputData.charAt(0) - 'a' +1; //문자를 int로 변형
		
		//나이트가 이동할 수 있는 방향 8가지
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		//8방향에 대해 이동 가능한지 확인
		int count=0;
		for(int i=0 ; i<8 ; i++) {
			int nextRow = row+dx[i];
			int nextColumn = column+dy[i];
			
			if(nextRow>=1 && nextRow<=8 && nextColumn>=1 && nextColumn<=8) {
				count++; //이동한 좌표가 체스판 안에 존재하면 경우의 수 하나 증가
			}
		}
		
		System.out.println(count);
	}

}
