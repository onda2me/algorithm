package com.onda2me.algorithm.begin;

/*
	Java 데이타 타입에 대한 예제
*/

public class Begin11Oper {

	public static void main(String[] args) {

		int a = 85;

		// if 를 사용한 조건문
		System.out.println("if 를 사용한 조건문 : ");
		if(a < 90) 
			System.out.println("불합격");
		else
			System.out.println("합격");

		// 3항 연산자를 사용한 조건문
		System.out.println("3항 연산자를 사용한 조건문 : ");
		String result = (a < 90) ? "불합격" : "합격";
		System.out.println(result);

	}	
}

