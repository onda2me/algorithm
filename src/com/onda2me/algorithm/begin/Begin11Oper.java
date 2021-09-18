package com.onda2me.algorithm.begin;

/*
	Java 데이타 타입에 대한 예제
*/

public class Begin11Oper {

	public static void main(String[] args) {

		int a = 5;
		int b = -2;
		int c = 0;
		

		// 산술연산
		c = a + b;

		// 문자열 연결
		System.out.println("a + b = " + "얼마일까요?");
		System.out.println("a + b = " + c + " 입니다.");


		// 대입연산
		c += 1;
		System.out.println("c += 1 연산후 c 얼마일까요?");
		System.out.println("c = " + c + " 입니다.");

		// 증감연산
		c++;
		System.out.println("c++ 연산후 c는 얼마일까요?");
		System.out.println("c = " + c + "입니다.");

		// 조건연산
		String s =  (c > 0 ? "크다" : "작거나같다" );
		System.out.println("c는 0보다 클까요?");
		System.out.println("c는 0보다 " + s);
		

	}	
}

