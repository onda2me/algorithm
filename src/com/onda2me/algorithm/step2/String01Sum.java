package com.onda2me.algorithm.step2;

/*

숫자의 합

### 문제설명    
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.    

### 입력    
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다.     
둘째 줄에 숫자 N개가 공백없이 주어진다.    

### 출력    
입력으로 주어진 숫자 N개의 합을 출력한다.    

### 예제    

입    력 | 출    력    
----- | -----    
1, 1 | 1    
5, 54321 | 15    
25, 7000000000000000000000000 | 3    
11, 10987654321 | 46    


### 문제원본
https://www.acmicpc.net/problem/11720

*/
public class String01Sum {    

    public static void main(String[] args) {

        // 입력정보
        solution(1, "1", 1);
        solution(5, "54321", 15);
        solution(25, "7000000000000000000000000", 7);
        solution(11, "10987654321", 46);
       
    }


    /**
     * 주어진 숫자의 모든 자리수의 숫자의 합을 구한다.
     * 숫자를 int나 long 숫자형으로 받을 경우 데이타의 범위 제한이 있으므로
     * 문자열로 받은 뒤 한자리씩 잘라서 숫자로 변환하여 처리한다.
     * 
     * int 자료범위 : -2147483648 ~ 2147483647
     * @param n
     * @param num
     * @param answer
     */
    private static void solution(int n, String num, int answer) {

        int sum = 0;
       
        for(int i=0; i<num.length(); i++) {
            sum += Integer.parseInt(num.substring(i, i+1));  // 한글자씩 잘라서 숫자로 변환
        }

        System.out.println((sum == answer) + " -> (" + sum + " == " + answer +") \t\t" + num +" sum");
    }
}

                