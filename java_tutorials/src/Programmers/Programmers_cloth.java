package Programmers;
import java.util.*;

//프로그래머스 체육복 문제
public class Programmers_cloth {
    public int solution(int n, int[] lost, int[] reserve) {
    	/*Set을 활용하여 풀기.
    	 * Set은 순서가 보장되지 않음
    	 * 중복이 허용되지 않음
    	 * contains()의 속도가 list보다 월등히 빠름
    	 * 데이터가 많지 않다면 성능보단 구조가 간단한 List를 활용하는게 나을 수 있음
    	 */
    	//1.Set 만들기
    	HashSet<Integer> resSet = new HashSet<>();
    	HashSet<Integer> lostSet = new HashSet<>();
    	
    	for(int i : reserve) resSet.add(i);
    	for(int i : lost) {
    		//여분의 체육복이 있는 학생이 도둑맞았는지 1차로 확인
    		if(resSet.contains(i)) resSet.remove(i); //여분을 도둑맞았으니 여분이 없는상태
    		else lostSet.add(i); //여분이 없고 도둑 맞았다면 lostSet에 추가
    	}
    	
    	//2.여분을 기준으로 앞,뒤 숫자 확인. 체육복 빌려주기
    	for(int i : resSet) {
    		if(lostSet.contains(i-1)) lostSet.remove(i-1);
    		else if(lostSet.contains(i+1)) lostSet.remove(i+1);
    	}
    	//3.전체학생-lost Set 수하기

        return n-lostSet.size();
    }

	public static void main(String[] args) {
		Programmers_cloth sol = new Programmers_cloth();
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.print(sol.solution(5, lost, reserve));
	}

}
