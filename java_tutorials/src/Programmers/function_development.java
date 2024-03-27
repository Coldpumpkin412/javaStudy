package Programmers;
import java.util.*;

/*
 * 프로그래머스 기능개발(Lv2) 문제
 */
public class function_development {
	
    public int[] solution(int[] progresses, int[] speeds) {
    	
    	ArrayList<Integer> answer = new ArrayList<>();
    	
    	for(int i=0 ; i< progresses.length ; i++) {
        	//1.한 개 기능을 개발하는데 필요한 날짜 계산
    		double days = (100 - progresses[i])/(double)speeds[i];
    		int daysUp = (int)Math.ceil(days); //실수형을 올림한  후 정수형으로 캐스팅
    		
        	//2.함께 배포할 기능의 index 찾기
    		int j = i+1;
    		for(; j<progresses.length ; j++) {
    			if(progresses[j] + daysUp * speeds[j] < 100) break;
    		}
        	//3.이번에 배포할 기능의 개수 추가
    		answer.add(j-i);
    		i = j-1;
    	}


        //stream은 배열 혹은 컬렉션등의 저장요소를 하나씩 참조하는 동작을 해줌
        //즉 answer라는 ArrayList의 각각의 Integer객체를 꺼내온 후 mapToInt로 int형태로 바꿔줌
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
    
	public static void main(String[] args) {
		int[] progress = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1,};
		
		function_development sol = new function_development();
		
		System.out.println(sol.solution(progress, speeds));
	}

}
