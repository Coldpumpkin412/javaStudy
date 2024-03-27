package Programmers;
import java.util.*;

/*
 * ���α׷��ӽ� ��ɰ���(Lv2) ����
 */
public class function_development {
	
    public int[] solution(int[] progresses, int[] speeds) {
    	
    	ArrayList<Integer> answer = new ArrayList<>();
    	
    	for(int i=0 ; i< progresses.length ; i++) {
        	//1.�� �� ����� �����ϴµ� �ʿ��� ��¥ ���
    		double days = (100 - progresses[i])/(double)speeds[i];
    		int daysUp = (int)Math.ceil(days); //�Ǽ����� �ø���  �� ���������� ĳ����
    		
        	//2.�Բ� ������ ����� index ã��
    		int j = i+1;
    		for(; j<progresses.length ; j++) {
    			if(progresses[j] + daysUp * speeds[j] < 100) break;
    		}
        	//3.�̹��� ������ ����� ���� �߰�
    		answer.add(j-i);
    		i = j-1;
    	}


        //stream�� �迭 Ȥ�� �÷��ǵ��� �����Ҹ� �ϳ��� �����ϴ� ������ ����
        //�� answer��� ArrayList�� ������ Integer��ü�� ������ �� mapToInt�� int���·� �ٲ���
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
    
	public static void main(String[] args) {
		int[] progress = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1,};
		
		function_development sol = new function_development();
		
		System.out.println(sol.solution(progress, speeds));
	}

}
