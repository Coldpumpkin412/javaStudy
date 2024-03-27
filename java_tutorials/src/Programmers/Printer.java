package Programmers;
import java.util.*;

/*
 * 인쇄 대기목록에서 가장 앞에있는 문서를 꺼낸 후
 * 나머지 대기목록에서 가장 앞에 문서보다 중요도가 높은 문서가 한 개라도 존재하면
 * 맨 뒤로 보낸다. 그렇지 않다면 출력
 * 이 때, location에 위치하는 문서의 출력순서를 구하시오
 */
public class Printer {
	class PrintJob{
		int priority;
		int location;
		
		//생성자
		public PrintJob(int location, int priority) {
			this.location = location;
			this.priority = priority;
		}
	}
	public int solution(int[] priorities, int location) {
		//큐 생성
		List<PrintJob> printer = new ArrayList<PrintJob>();
		for(int i=0 ; i<priorities.length ; i++) {
			printer.add(new PrintJob(i, priorities[i]));
		}
		
		int turn=0; //수행횟수
		
		while(!printer.isEmpty()) {
			//0번을 꺼낸 후 max priority가 아니면 끝에 넣기
			PrintJob job = printer.remove(0);
			//printer에 남아있는 것들 중에 현재값보다 우선순위가 높은것이 있는가
			if(printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
				printer.add(job); //존재한다면 다시 맨 뒤에 넣기
			}else {
				//max priority가 맞다면 인덱스가 location과 동일한지 확인한다
				turn++;
				
				if(location == job.location) { //문제에서 제시한 인덱스와 일치하는지 확인
					break;
				}
			}
		}
		
		return turn;
	}

	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
		int location = 2;
		
		Printer sol = new Printer();
		System.out.println(sol.solution(priorities, location));
	}

}
