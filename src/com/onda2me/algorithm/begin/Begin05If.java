package com.onda2me.algorithm.begin;

/*
	@문제
	a, b 두 정수를 비교하여 결과 출력하기
	 + a가 b 보다 작으면 '<' 출력
	 + a가 b 보다 크면 '>' 출력
	 + a와 b 가 같으면 '=' 출력

	@ 입력
	10
	3

	@ 출력
	>

*/

public class Begin05If {

	public static void main(String[] args) {

		int a = 10;
		int b = 3;
		

		if(a > b)
			System.out.println(">");
		
		if(a < b)
			System.out.println("<");

		if(a == b)
			System.out.println("=");			
	}	
}
