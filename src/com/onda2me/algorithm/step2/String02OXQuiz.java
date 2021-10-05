package com.onda2me.algorithm.step2;

/*
OX퀴즈 

### 문제설명 
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 
예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

### 입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.

### 출력
각 테스트 케이스마다 점수를 출력한다.

### 예제

입    력 |  출    력     
----- | -----    
OOXXOXXOOO |  10
OOXXOOXXOO | 9    
OXOXOXOXOXOXOX | 7
OOOOOOOOOO | 55
OOOOXOOOOXOOOOX | 30

### 문제원본 
[https://www.acmicpc.net/problem/8958](https://www.acmicpc.net/problem/8958){: target="_blank"}

*/
public class String02OXQuiz {    

    public static void main(String[] args) {

        // 입력정보
        solution("OOXXOXXOOO", 10);
        solution("OOXXOOXXOO", 9);
        solution("OXOXOXOXOXOXOX", 7);
        solution("OOOOOOOOOO", 55);
        solution("OOOOXOOOOXOOOOX", 30);
    }

    /**
     * O의 점수를 계산한다.
     * @param str
     * @param answer
     */
    private static void solution(String str, int answer) {
        int sum = 0;
        int hit = 0;
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            switch(c) {
                case 'O':
                    hit++;      
                    break;
                case 'X':
                    hit = 0;
                    break;
            }
            sum += hit;
        }

        System.out.println((answer == sum) + " ("+sum +" == " + answer +") -> " + str);
    }
}

                