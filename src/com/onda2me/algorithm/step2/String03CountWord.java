package com.onda2me.algorithm.step2;

/*

단어의 개수

### 문제설명 
영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 
이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 
단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

### 입력
첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 
이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 
또한 문자열은 공백으로 시작하거나 끝날 수 있다.

### 출력
첫째 줄에 단어의 개수를 출력한다.

입    력 |  출    력     
----- | -----    
The Curious Case of Benjamin Button  | 6
The first character is a blank   |  6
The last character is a blank | 6

### 문제원본
https://www.acmicpc.net/problem/1152

*/
public class String03CountWord {    

    public static void main(String[] args) {

        // 입력정보
        solution1("The Curious Case of Benjamin Button", 6);
        solution1("The first character is a blank ", 6);
        solution1(" The last character is a blank", 6);
    }

    /**
     * 방법1 : 자바 내장 함수를 이용한 단어개수 구하기
     * @param str
     * @param answer
     */
    private static void solution1(String str, int answer) {

        str = str.trim();
        String arr[] = str.split(" ");        
        System.out.println((arr.length == answer) +" ("+arr.length +" == " + answer +" ) " + str);
    }

    /**
     * 방법2 : 공백문자열을 카운트하여 단어개수 구하기
     * @param str
     * @param answer
     */
    private static void solution2(String str, int answer) {

        int spaceCnt = 0;
        int wordCnt = 0;
        for(int i=0; i<str.length(); i++) {
           
            if(" ".equals(str.substring(i, i+1))) {
                spaceCnt++;
            }
       } 

       wordCnt = spaceCnt + 1;  // 단어수는 공백수 + 1
       System.out.println((wordCnt == answer) +" ("+wordCnt +" == " + answer +" ) " + str);
    }
}

                