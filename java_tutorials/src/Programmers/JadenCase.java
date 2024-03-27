package Programmers;
import java.util.*;

//���α׷��ӽ� JadenCase ���ڿ�
public class JadenCase {
	public String solution(String s) {
		/*
		 * �־����� s�� ���ĺ�, ����, ���鹮�ڷ� �̷����
		 * ���ڴ� �ܾ��� ù ���ڷθ� ����
		 * ������ �����ؼ� ���� �� ����
		 */
		String answer = "";
		int index=0; //index�� 0�϶� �빮�ڷ� ġȯ, ������ ������ �ٽ� 0���� �ʱ�ȭ
		
		for(int i=0 ; i<s.length() ; i++) {
			char ch;
			//�ε����� 0�̰� �ҹ��ڸ� �빮�ڷ� ġȯ �� �ε��� �� ����
			if('a'<=s.charAt(i) && s.charAt(i) <='z' && index==0) {
				ch = Character.toUpperCase(s.charAt(i));
				answer += ch;
				index++;
			}else if(s.charAt(i)==' ') {
				//������ ������ �ε����� �ٽ� 0���� �ʱ�ȭ
				answer += s.charAt(i);
				index = 0;
			}else if(index!=0){ 
				//�ε����� 0�� �ƴѰ�� ��� �ҹ���
				ch = Character.toLowerCase(s.charAt(i));
				answer += ch;
				index++;
			}else { //�̿��� ���(����)
				answer += s.charAt(i);
				index++;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String s = "3people   unFollowed me";
		JadenCase sol = new JadenCase();
		
		System.out.print(sol.solution(s));
	}

}
