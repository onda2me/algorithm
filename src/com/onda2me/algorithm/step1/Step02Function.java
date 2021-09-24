package com.onda2me.algorithm.step1;

/*
	@문제
	입력받은 두개의 숫자를 더하는 함수를 만들어 결과를 출력한다.
	
	@ 입력
	3 5

	@ 출력
	8

*/

public class Step02Function {

	public static void main(String[] args) {
			

		int[] arr = {3, 5};

		sum(arr[0], arr[1]);
		sumDesc(arr[0], arr[1]);
		
		complex(arr[0], arr[1]);
		complexDesc(arr[0], arr[1]);
	}	

	public static void sum(int a, int b) {

		System.out.println(a+b);
	}

	public static void sumDesc(int a, int b) {

		System.out.println(a +"+" + b +"=" + (a+b));
	}	

	public static void complex(int a, int b) {

		System.out.println(a*b);
	}

	public static void complexDesc(int a, int b) {

		System.out.println(a +"*" + b +"=" + (a*b));
	}	
}
