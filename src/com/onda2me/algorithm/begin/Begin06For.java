package com.onda2me.algorithm.begin;

/*
	@문제
	입력받은 숫자에 해당하는 구구단을 출력하기
	
	@ 입력
	3

	@ 출력
	3*1=3
	3*2=6
	3*3=9
	3*4=12
	3*5=15
	3*6=18
	3*7=21
	3*8=24
	3*9=27
*/

public class Begin06For {

	public static void main(String[] args) {

		int a = 3;
				
		for(int i=1; i<10; i++) {

			System.out.println(a + "*" + i +"=" + (a*i));
		}
	}	
}
