package com.onda2me.algorithm.step1;

/*
	@문제
	연산함수를 만들어 입력받은 두개의 숫자를 더하기, 빼기, 곱하기, 나누기하여 결과를 출력한다.
	
	@ 입력
	5 2

	@ 출력
	7
	3
	10
	2
*/

public class Step02Function2 {

	public static void main(String[] args) {
			
		oper(5, 2);

		oper(7, 3);
	}	

	public static void oper(int a, int b) {

		System.out.println("# oper (" + a +", " + b + ") ----------- ");
		System.out.println(a +"+" + b +"=" + (a+b));
		System.out.println(a +"-" + b +"=" + (a-b));
		System.out.println(a +"*" + b +"=" + (a*b));
		System.out.println(a +"/" + b +"=" + (a/b));
	}	
}
