package com.onda2me.algorithm.begin;

/*
	@문제
	점수 a를 입력받아 100~90점은 A, 89~80은 B, 79~70은 C, 나머지 점수는 F 출력하기

	@ 입력
	82

	@ 출력
	B

*/

public class Begin05If02 {

	public static void main(String[] args) {

		int a = 82;

		if(a >= 90)
			System.out.println("A");
		
		else if(a >= 80)
			System.out.println("B");

		else if(a >= 70)
			System.out.println("C");			

		else
			System.out.println("F");			
	}	
}
