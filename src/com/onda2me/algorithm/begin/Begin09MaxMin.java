package com.onda2me.algorithm.begin;

/*
	@문제
	입력받은 숫자에서 최소값과 최대값을 구하는 함수를 만들어 최소값과 최대값을 출력한다.
	
	
	@ 입력
	5 3 8 4

	@ 출력
	3 8 

*/

public class Begin09MaxMin {

	private static int[] a = {5, 3, 8, 4};

	public static void main(String[] args) {	
		
		printMin();
		printMax();

	}	

	/**
	 * 최소값을 구하여 출력한다.
	 */
	public static void printMin() {

		int min = Integer.MAX_VALUE;
		for(int i=0; i<a.length; i++) {

			if(min > a[i])
				min = a[i];
		}

		System.out.println(min);
	}

	/**
	 * 최대값을 구하여 출력한다.
	 */
	public static void printMax() {

		int max = Integer.MIN_VALUE;
		for(int i=0; i<a.length; i++) {

			if(max < a[i])
				max = a[i];
		}

		System.out.println(max);
	}	
}

