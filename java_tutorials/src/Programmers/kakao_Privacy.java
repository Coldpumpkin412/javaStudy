package Programmers;
import java.util.*;


//���α׷��ӽ� kakao blind recruitment �������� ���� ��ȿ�Ⱓ ����
public class kakao_Privacy {
	/*
	 * today������ "YYYY.MM.DD"������ ���ó�¥
	 * terms �迭�� ���Ҵ� �����ϳ��� �������� ������� �� ��ȿ�Ⱓ ǥ��(��ȿ�Ⱓ�� 1~100)
	 * privacies �迭�� ���Ҵ� i+1��° ���������� ���� ���� �� ������� ��Ÿ��
	 * privacies �迭�� ���Ҵ� ���� �ϳ��� �������� ��¥ �� ��� ���� ǥ��(��¥�� today ���� ��¥��)
	 * ��¥�� ��(.) �ϳ��� ����
	 */
	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer=new ArrayList<>();
		HashMap<String, Integer> standard = new HashMap<>();
		
		//���� ��¥
		String[] t = today.split("\\."); //���� �������� ����
		int tCount = Integer.parseInt(t[0])*12*28 + Integer.parseInt(t[1])*28 + Integer.parseInt(t[2]);
		
		for(String i : terms) {
			String[] arr = i.split(" ");
			standard.put(arr[0], Integer.parseInt(arr[1]));
		}
		
		for(int i=0 ; i<privacies.length ; i++) {
			int year = Integer.parseInt(privacies[i].substring(0,4)); //����
			int month = Integer.parseInt(privacies[i].substring(5,7)); //��
			int day = Integer.parseInt(privacies[i].substring(8,10)); //��
			
			String type = privacies[i].substring(11,12); //�������
			
			int tp = standard.get(type); //�ؽøʿ��� ��������� ��ȿ�Ⱓ ��������
			
			month += tp;
			
			Integer tmp = year*12*28 + month*28 + day -1; //��ȿ�Ⱓ �����뼱
			
			if(tCount > tmp) answer.add(i+1);
		}
		
		return answer.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		String today =  "2022.05.19";
		String[] terms ={"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		kakao_Privacy sol = new kakao_Privacy();
		
		System.out.println(sol.solution(today, terms, privacies));
	}
	
}
