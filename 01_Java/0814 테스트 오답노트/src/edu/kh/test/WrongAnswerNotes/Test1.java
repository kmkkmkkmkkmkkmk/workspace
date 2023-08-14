package edu.kh.test.WrongAnswerNotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<IPInfo> ipInfoList = null;
		
		ipInfoList.add(new IPInfo("123.123.123.123", "홍길동"));
		ipInfoList.add(new IPInfo("212.133.7.8"));
		ipInfoList.add(new IPInfo("177.233.111.222", "고길순"));
		
		System.out.println("ip 입력 : ");
		String ip = sc.next();
		
		for(int i=0 ; i<ipInfoList.size() ; i++) {
			if(ipInfoList.get(i) == ip) {
				System.out.println(ipInfoList.get(i));
				break;
			}
		}
		
		System.out.println("일치하는 ip 사용자가 없습니다.");
	}
}


/*  오답노트
 * 
 * 
 * 
 *  1. 	(원인)
 *  	13번째 줄 : 참조변수 ipInfoList에 객체가 없다는 null이 대입되어
 *  				이후 ipInfoList를 활용한 코드에서 모두 NullPointerException이 발생함
 *  
 *  	(결과)
 *  	13번째 줄 : List를 상속한 객체를 생성하여 ipInfoList에 대입
 *  				List<INPnfo> ipinfoList = new ArrayList<IPInfo>();
 *  
 *  2. 	(원인)
 *  	14번째 줄 : IPInfo 클래스에 String 매개 변수 하나를 
 *  				전달 받는 생성자가 존재하지않아 객체 생성 불가
 *  
 *  	(결과)
 *  	14번째 줄 : 
 *  
 *  	방법 1 : IPInfo 클래스 String 매개 변수 하나짜리 생성자를 작성 
 *  	public IPInfo(String ip){
 *  	this.ip=ip;
 *  
 *  	}
 *  	방법 2 : IPInfo 객체 생성 구문에 두번째 매개변수 (String)을 추가
 *  	ininfoList.add(new IPInfo("212.133.7.8", "아무이름"));
 *  
 *  3. (원인)
 *  	21번째 줄 : 
 *  	if문에서 입력 받은 String 자료형 ip와 비교하는 값 ipInfoList.get(i)의 자료형은 
 *  	IPInfo로 서로 다른 타입으로 비교 불가하고 String 값 비교를 위해서는
 *  	equals()를 사용해야 하는데 그러지 않아 비교 불가
 *  
 *  	(결과)
 *  	21번째 줄 : 
 *  	if문 조건식 ip와 비교할 수 있게 변경
 *  	if(ipinfoList.get(i).getip().equals(ip))
 *  	
 *  4. 	(원인)
 *  	일치하는 ip가 있을 때 반복문만 종료하는 break 구문을 작성하여 
 *  	일치하는 ip가 있어도 27번 "일치하는 ip 사용자가 없습니다"가 출력되는 문제 발생
 *  	
 *  	(결과)
 *  	23번째 줄 : 일치하는 ip가 있을 경우 메서드를 바로 종료할 수 있게
 *  	return으로 변경
 *  	break; -> return;
 *  
 */

















