package com.onda2me.algorithm.begin;

import java.util.Scanner;

/*
	@문제
	a, b 두 정수를 입력받아 a+b, a-b, a*b, a/b(몫), a%b(나머지) 출력하기

	@ 입력
	10
	3

	@ 출력
	13
	7
	30
	3
	1
*/

public class Begin04Oper05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);		
		System.out.println(a%b);

	}	
}
