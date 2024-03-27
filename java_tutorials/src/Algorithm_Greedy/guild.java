package Algorithm_Greedy;
import java.util.*;

/*
 * 모험가 길드 문제(그리디 활용)
 * N명의 모험가를 대상으로 '공포도' 측정.
 * 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야한다. 
 * 이 때 만들 수 있는 모험가 그룹의 최댓값을 구하시오
 */
public class guild {
		public static int n;//모험가의 수
		public static ArrayList<Integer> list = new ArrayList<>(); //공포도 저장
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) list.add(sc.nextInt()); //공포도 입력
		
		Collections.sort(list); //오름차순 정렬
		
		int result = 0; //총 그룹의 수
		int count = 0; //현재 그룹에 포함 된 모헙가의 수
		
		for(int i=0 ; i<n ; i++) {
			count++; //현재 그룹에 해당 모험가 포함
			if(count>=list.get(i)) {
				result++;
				count=0;
			}
		}
		
	}

}
