package Programmers;
import java.util.*;

//���α׷��ӽ� ���ڿ� ������ ����
public class sentence {
	public int solution(String s) {
		int answer = 0;
		char ch = s.charAt(0); //�ʱⰪ�� �̸� ������ ��Ƶα�
		int maincount = 1; //������ �� ���ĺ��� ���� Ƚ��(�ʱⰪ�� �̹� �������Ƿ� 1���� ����)
		int subcount = 0; //maincount�� ���� ����
		
		for(int i=1 ; i<s.length() ; i++) {
			if(ch == ' ') {
				ch = s.charAt(i); 
				continue;// ������ �߷����� ��ĭ�ΰ�� �ٽ� �ʱⰪ ����
			}
			if(ch == s.charAt(i)) {
				maincount++;
			} else {
				subcount++;
			}
			
			if(maincount == subcount) { //Ƚ���� �������� �ٽ� �ʱ�ȭ
				answer++;
				ch = ' ';
				maincount = 1;
				subcount = 1;
			}
		}
		
		if(ch != ' ') {
			answer++;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String s = "banana";
		sentence sol = new sentence();
		
		System.out.print(sol.solution(s));
		
	}

}
