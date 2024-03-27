package Algorithm_Implementation;
import java.util.*;

/*
 * 문자열 재정렬 문제
 * 첫쨰 줄에 문자열 S입력(1<= S의길이 <=10000)
 * 이 때, 모든 알파벳을 오름차순으로 정렬한 후 그 뒤에 모든 숫자를 더한 값을 출력
 */
public class Rearrange {

	public static void main(String[] args) {
		//문자열 입력
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		
		//주어진 문자열을 문자 배열로 변경
		char[] arr = S.toCharArray();
		
		//변경 후 값을 하나씩 확인. 문자일 경우 리스트에 저장, 숫자일 경우 따로 값 저장
		int sum=0;
		List<String> list = new ArrayList<>();
		
		for(int i=0 ; i<arr.length ; i++) {
			if(0<=arr[i]-'0' && arr[i]-'0'<=9) {
				sum += arr[i]-'0';
			}else {
				list.add(Character.toString(arr[i]));
			}
		}

		//리스트의 값들은 오름차순으로 정렬 후 정수 값 붙여주기
		Collections.sort(list);
		list.add(Integer.toString(sum));
		
		//리스트의 값을 문자열로 변경 후 출력
		String str="";
		for(int i=0 ; i<list.size() ; i++) {
			str += list.get(i);
		}
		
		System.out.println(str);
		
		sc.close();
	}

}
