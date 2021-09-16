package com.onda2me.algorithm.begin;

/*
	Java 데이타 타입에 대한 예제
*/

public class Begin10Datatype {

	public static void main(String[] args) {

		int i1 = 1;
		int i2 = 3;

		System.out.println("int 데이타 범위내의 연산");
		System.out.println(i1 + i2);

		// int 자료범위 : -2147483648 ~ 2147483647
		int i3 = 1;
		int i4 = 2147483647;

		System.out.println("int 데이타 범위외의 연산");
		System.out.println(i3 + i4);		


		float f1 = 1.1F;
		float f2 = 3.2F;

		System.out.println("float 데이타 범위내의 연산");
		System.out.println(f1 + f2);

		// float 자료범위 : (+/-)1.4E-45 ~ (+/-)3.4028235E38
		float f3 = 340282350000000000000000000000000000000.1F;
		float f4 = 340282350000000000000000000000000000000.1F;

		System.out.println("float 데이타 범위외의 연산");
		System.out.println(f3+f4);		

	}	
}

