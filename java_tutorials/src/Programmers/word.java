package Programmers;
import java.util.*;

//���α׷��ӽ� �����ձ⹮��
public class word {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int[] count = new int[n]; //�ο��� ���° �õ����� üũ
		List<String> list = new ArrayList<>(); //���� �ܾ� ���帮��Ʈ
		
		for(int i=0 ; i<n ; i++) count[i]++; //�õ� Ƚ�� �ʱⰪ 1�� ����
		
		list.add(words[0]); //ù��° �ܾ� ����
		
		for(int i=1 ; i<words.length ; i++) {
			if(words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0)) {
				for(int j=0 ; j<list.size() ; j++) {
					if(list.get(j).equals(words[i])) { //������ ���� �ܾ�
						answer[0] = i%n+1;
						answer[1] = count[i%n];
					}
				}
				list.add(words[i]); //���ο� �ܾ��϶� ���帮��Ʈ�� �߰�
				count[i%n]++; //�õ� Ƚ�� �߰�
			}else {
				answer[0] = i%n+1;
				answer[1] = ++count[i%n];
			}
			
		}
		
		for(int i=0 ; i<2 ; i++) System.out.print(answer[i]);
		return answer;
		
	}
	public static void main(String[] args) {
		int n=2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		word sol = new word();
		
		System.out.print(sol.solution(n, words));
	}

}
