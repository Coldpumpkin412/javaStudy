package Programmers;
import java.util.*;
import java.util.Collections;

//���α׷��ӽ� ����¦�� ����
public class Coupled_Num {
	public String solution(String X, String Y) {
		/* 
		 * StringBuilder�� �������� �����⋚���� ���ڿ��� �߰�,����,������ ���� ����
		 * ������ ����ȭ�� ���������ʾ� ���Ͻ����� ȯ�濡 ����
		 * StringBuffer�� ����ȭ�� �����Ѵ�
		 * ����ӵ� : StringBuilder(�������) < StringBuffer < String(���� ����)
		 */

		
		//0~9������ �ε����� ���� �迭 ����
		int[] countX = new int[10];
		int[] countY = new int[10];
		
		//�ѱ��ھ� ���� �� ������ ��ȯ�Ͽ� �ش簪�� �ε����� ���� �迭�� �ϳ��� ����
		for(String strX : X.split("")) countX[Integer.parseInt(strX)]++;
		for(String strY : Y.split("")) countY[Integer.parseInt(strY)]++;
		
        StringBuilder sb = new StringBuilder();
		
		for(int i=9 ; i>=0 ; i--) {
			//�ش� �ε����� ���� �� �� 0���� ũ�ٸ� �������� ���� �ִٴ� ��
			while(countX[i]>0 && countY[i]>0) {
				sb.append(i);
                countX[i]--;
                countY[i]--;
			}
		}
		
		String answer="";
        
        if ("".equals(sb.toString())) {
            answer = "-1";
        } else if ("0".equals(sb.toString().substring(0,1))) {
            answer = "0";
        } else {
            answer = sb.toString();
        }

        return answer;

	}

	public static void main(String[] args) {
		String X = "100";
		String Y = "123450";
		Coupled_Num sol = new Coupled_Num();
		
		System.out.print(sol.solution(X, Y));
	}

}
