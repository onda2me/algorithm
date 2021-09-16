package com.onda2me.algorithm.begin;

import java.util.Scanner;

/*
	@문제
	1부터 입력받은 숫자에 해당하는 정보 출력하기
	
	@ 입력
	2

	@ 출력
	화요일	
*/

public class Begin08Switch03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		while(true) {

			System.out.println("1~7까지의 숫자를 입력하세요. (-1 을 입력하면 종료됩니다.)");
			int n = sc.nextInt();

			if(n == -1) {
				System.out.println("종료완료");
				break;
			}

			switch(n) {
				case 1: 
					System.out.println("월요일");
					break;
				case 2:

					System.out.println("화요일");
					break;
				case 3: 
					System.out.println("수요일");
					break;
				case 4:
					System.out.println("목요일");
					break;
				case 5: 
					System.out.println("금요일");
					break;
				case 6: 
					System.out.println("토요일");
					break;
				case 7: 
					System.out.println("일요일");
					break;
				default: 
					System.out.println("해당하는 요일이 없습니다.");
					break;
			}
		}

		sc.close();
	}	

}
