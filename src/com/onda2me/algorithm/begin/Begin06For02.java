package com.onda2me.algorithm.begin;

/*
	@문제
	1단부터 입력받은 숫자까지 구구단을 출력하기
	
	@ 입력
	3

	@ 출력
	1*1=1
	1*2=2
	1*3=3
	1*4=4
	1*5=5
	1*6=6
	1*7=7
	1*8=8
	1*9=9
	2*1=2
	2*2=4
	. . .
	9*8=72
	9*9=81
*/

public class Begin06For02 {

	public static void main(String[] args) {
			
		for(int a=1; a<10; a++) {

			for(int i=1; i<10; i++) {
				System.out.println(a + "*" + i +"=" + (a*i));
			}
		}
	}	
}
