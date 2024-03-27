package Programmers;
import java.util.*;

public class ID_recommend {
	public String solution(String new_id) {
		String answer="";
		
		new_id = new_id.toLowerCase(); //1�ܰ�: �ҹ��� ġȯ
		new_id = new_id.replaceAll("[^a-z\\d\\-_.]*", ""); //2�ܰ�: ���ǿ� �����ʴ� ���� ����
		//'^'�� '[]'�ȿ� ������ ��� ������ �ǹ�
		//'\'�ι� ����ؾ� �������� �˻� ����
		// \d�� 0~9���� �ǹ�	
		
		new_id = new_id.replaceAll("\\.{2,}","."); // 3�ܰ�: .�� 2ȸ �̻��� ��� .���� ġȯ
		new_id = new_id.replaceAll("^[.]|[.]$", ""); // 4�ܰ�: ó���� ���� .�ΰ�� ����
		// '^'�� '[]' �ۿ� �ִ� ��� ������ ������ �ǹ� , '|'�� OR������
		//[.]$�� ���ڿ� ���� . �� ��츦 �ǹ�
		
		if(new_id.length()==0) new_id+="a"; //5�ܰ�: ����ִ� ��� a����
		
		if(new_id.length()>=16) new_id = new_id.substring(0,15); //6�ܰ�: 16�� �̻��̸� 15�� ���Ĵ� ����
		new_id = new_id.replaceAll("[.]$", ""); //6�ܰ�: ������ ��ħǥ�� ����
		
		while(new_id.length()<=2) {
			new_id += new_id.charAt(new_id.length()-1); //7�ܰ�
		}

		return new_id;
	}
	public static void main(String[] args) {
		String new_id = "123_.def";
		ID_recommend sol = new ID_recommend();
		
		System.out.print(sol.solution(new_id));
	}

}
