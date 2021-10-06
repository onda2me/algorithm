package com.onda2me.algorithm.step2;

/*

단어 뒤집기 

### 문제
문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오.    
단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.    

### 입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.    
각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다.     
단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.

### 출력
각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.

### 예제    

입    력 |  출    력     
----- | -----  
I am happy today | I ma yppah yadot
We want to win the first prize | eW tnaw ot niw eht tsrif ezirp


### 문제원본    
[https://www.acmicpc.net/problem/9093](https://www.acmicpc.net/problem/9093){: target="_blank"}

*/

public class String08ReverseString {    
   
    public static void main(String[] args) {

        // 입력정보
       solution("I am happy today", "I ma yppah yadot");
       solution("We want to win the first prize", "eW tnaw ot niw eht tsrif ezirp");
    }


    private static void solution(String str, String answer) {

        String[] arr = str.split(" ");      // " "로 단어를 구분하여 배열로 저장
        StringBuilder bld = new StringBuilder();

        
        for(int i=0; i<arr.length; i++) {

            for(int k=arr[i].length(); k>0; k--) {      // 단어개수 만큼 실행
                bld.append(arr[i].substring(k-1, k));   // 배열에 저장된 단어를 뒤에서 읽어 StringBuilder에 저장
            }
            
            bld.append(" ");
        }

        System.out.println(answer.equals(bld.toString().trim()) + " : " + str +" -> " + bld.toString());

    }
}

                