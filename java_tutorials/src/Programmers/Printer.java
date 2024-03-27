package Programmers;
import java.util.*;

/*
 * �μ� ����Ͽ��� ���� �տ��ִ� ������ ���� ��
 * ������ ����Ͽ��� ���� �տ� �������� �߿䵵�� ���� ������ �� ���� �����ϸ�
 * �� �ڷ� ������. �׷��� �ʴٸ� ���
 * �� ��, location�� ��ġ�ϴ� ������ ��¼����� ���Ͻÿ�
 */
public class Printer {
	class PrintJob{
		int priority;
		int location;
		
		//������
		public PrintJob(int location, int priority) {
			this.location = location;
			this.priority = priority;
		}
	}
	public int solution(int[] priorities, int location) {
		//ť ����
		List<PrintJob> printer = new ArrayList<PrintJob>();
		for(int i=0 ; i<priorities.length ; i++) {
			printer.add(new PrintJob(i, priorities[i]));
		}
		
		int turn=0; //����Ƚ��
		
		while(!printer.isEmpty()) {
			//0���� ���� �� max priority�� �ƴϸ� ���� �ֱ�
			PrintJob job = printer.remove(0);
			//printer�� �����ִ� �͵� �߿� ���簪���� �켱������ �������� �ִ°�
			if(printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
				printer.add(job); //�����Ѵٸ� �ٽ� �� �ڿ� �ֱ�
			}else {
				//max priority�� �´ٸ� �ε����� location�� �������� Ȯ���Ѵ�
				turn++;
				
				if(location == job.location) { //�������� ������ �ε����� ��ġ�ϴ��� Ȯ��
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
