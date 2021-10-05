package com.onda2me.algorithm.step2;
/*

알파벳 개수

### 문제설명 
알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.

### 입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

### 출력
단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.

### 예제    

입    력 |  출    력     
----- | -----  
baekjoon | 1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0


### 문제원본    
[https://www.acmicpc.net/problem/10808](https://www.acmicpc.net/problem/10808){: target="_blank"}

*/
public class String05CountAlphabet {    

    public static void main(String[] args) {

        // 입력정보
        solution("baekjoon", "1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0");
    }

    /**
     * 각 알파벳의 개수를 구한다.
     * @param str
     * @param answer
     */
    private static void solution(String str, String answer) {

        int arr[] = new int[26];
        int idx = 0;
        StringBuffer buff = new StringBuffer();

        // 각 알파벳의 위치에 해당 알파벳갯수를 저장한다.
        // a 의 Ascii값은 97 이므로, 배열위치는 arr[Ascii - 97] => arr[0] 위치에 저장한다.
        // a -> arr[0], b -> arr[1], c -> arr[2] . . . 
        for(char c: str.toCharArray()) {
            idx = (int)c - 97;
            arr[idx] = arr[idx]+1;
        }

        // 알파벳의 개수가 저장된 arr의 출력정보를 저장한다.
        for(int i: arr) {
            buff.append(i).append(" ");
        }       
        
        // 결과 출력
        System.out.println("Is right? " + answer.equals(buff.toString().trim()));
        System.out.println(buff.toString());
        
    }
}

                