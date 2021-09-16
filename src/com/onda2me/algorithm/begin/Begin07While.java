package com.onda2me.algorithm.begin;

/*
	@문제
	1부터 입력받은 숫자까지 출력하기
	
	@ 입력
	5

	@ 출력
	1
	2
	3
	4
	5	
*/

public class Begin07While {

	public static void main(String[] args) {
			
		int n = 5;
		int i = 1;
		while(i <= n) {

			System.out.println(i);
			i++;
		}

	}	
}
