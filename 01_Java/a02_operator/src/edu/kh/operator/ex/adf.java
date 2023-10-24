package edu.kh.operator.ex;

public class adf {

	public static void main(String[] args) {
		
		
		int iNum1 = 10;
		int iNum2 = 4;
		float fNum = 3.0f;
		double dNum =  2.5;
		char ch = 'A';
		
		
		
		System.out.println(iNum1 / iNum2); //2
		System.out.println( (int)dNum ); //2
		
		
		System.out.println((double)iNum1); // 10.0 - 맞춤
		System.out.println( iNum2 * dNum ); // 10.0 - 틀린 문제 [복습]
		
		
	    System.out.println((int)fNum); // 3
	    System.out.println( (int)(iNum1 / fNum) ); // 3
	    
	    System.out.println(iNum1 / fNum); // 3.3333333
	    
	    
	   
	    //위 아래 같음
	    System.out.println((double)iNum1 / fNum); // 3.333333333333333
	    System.out.println(iNum1 / (double)fNum); // 3.333333333333333
		
	    
	    System.out.println( ch ); //A  
	    System.out.println( (int)ch ); //65 윗 문장을 정수로 변환
	    
	    System.out.println( iNum1 + ch ); // 75
	    
	    
	    
	    System.out.println((char)(iNum1 + ch)); // 'K' -  틀림 복습
	    
	    // ABCDE FGHIJ KLMNO PQRST UVWXY Z
	    
	}
}
