package com.onda2me.algorithm.step2;
/*
진법 변환

### 문제
10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

### 입력
첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

### 출력
첫째 줄에 10진법 수 N을 B진법으로 출력한다.


### 예제    

입    력 |  출    력     
----- | -----  
10 2 | 1010
12 8 | 14
12 16 | C
43 16 | 2B


### 문제원본    
[https://www.acmicpc.net/problem/11005](https://www.acmicpc.net/problem/11005){: target="_blank"}

*/

public class String07DigitConversion {    
   
    public static void main(String[] args) {

        // 입력정보
        solution(10, 2, "1010"); 
        solution(12, 8, "14");   
        solution(12, 16, "C");   
        solution(43, 16, "2B");        
    }

    /**
     * 
     * 주어진 10진수 숫자 num 을 b진수 수로 변환한다.
     * 출력값 : 10(10) -> 1010(2)                iscorrect? true
     * @param num       10진수 숫자
     * @param b         변경하는 진법
     * @param answer    b진수 변환 값
     */
    private static void solution(int num, int b, String answer) {

        String str = "";
        int remainder = 0;
        
        System.out.print(num +"(10) -> ");

        while(num  != 0) {
            remainder = num%b;

            if(remainder < 10) {
                str = remainder + str;            
            }
            else 
            {
                str = ((char)(remainder+55)) + str;
            }
            num = num/b;
            
        }

        System.out.println(str + "("+b+")  \t\t iscorrect? " + (answer.equals(str.toUpperCase())));
    }
}

                