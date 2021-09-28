package com.onda2me.algorithm.kakao;


/*
# 문제원본
https://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/

# N진수 게임
튜브가 활동하는 코딩 동아리에서는 전통적으로 해오는 게임이 있다. 
이 게임은 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임인데, 규칙은 다음과 같다.

숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.
이렇게 게임을 진행할 경우,
0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, …
순으로 숫자를 말하면 된다.

한편 코딩 동아리 일원들은 컴퓨터를 다루는 사람답게 이진수로 이 게임을 진행하기도 하는데, 이 경우에는
0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, …
순으로 숫자를 말하면 된다.

이진수로 진행하는 게임에 익숙해져 질려가던 사람들은 좀 더 난이도를 높이기 위해 이진법에서 십육진법까지 모든 진법으로 게임을 진행해보기로 했다. 
숫자 게임이 익숙하지 않은 튜브는 게임에 져서 벌칙을 받는 굴욕을 피하기 위해, 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만들려고 한다. 
튜브의 프로그램을 구현하라.

# 입력 형식
진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.

2 ≦ n ≦ 16
0 ＜ t ≦ 1000
2 ≦ m ≦ 100
1 ≦ p ≦ m

# 출력 형식
튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열. 단, 10~15는 각각 대문자 A~F로 출력한다.

# 입출력 예제
진법    숫자수  게임인원   튜브순서  정답
n       t       m	    p	    result
2	    4       2	    1	    “0111”
16	    16	    2	    1	    “02468ACE11111111”
16	    16	    2	    2	    “13579BDF01234567”

*/
public class Kakao17Ques31 {      
    public static void main(String[] args) {
        // 입력정보 
        solution(2, 4, 2, 1, "0111");
        solution(16,	    16,	    2,	    1, "02468ACE11111111");
        solution(16,	    16,	    2,	    2, "13579BDF01234567");        
    }

    /**
     * 
     * 1, 2, 3, 4 ... 숫자를 n진법으로 변환하기
     * 
     * @param n
     * @param t
     * @param m
     * @param p
     * @param answer
     */
    private static void solution(int n, int t, int m, int p, String answer) {

        StringBuffer ball = new StringBuffer();
        StringBuffer btube = new StringBuffer();
        
        int idx = 0;

        // n진법으로 변환한 숫자가 t개가 될때까지 계속 실행
        while(btube.toString().length() < t){ 
            
            // n진법으로 변환
            conversion(n, idx, ball);

            // p순서의 숫자를 저장한다.
            if(idx%2+1 == p) {                
                btube.append(ball.toString().charAt(idx));
            }

            idx++;
        }

        System.out.println(answer.equals(btube.toString().toUpperCase()) + " -->  " + btube.toString() +" == " + answer);
    }

    /**
     * 숫자 i를 n진법으로 변환한다
     * 
     * @param n
     * @param i
     * @param ball
     */
    public static void conversion(int n, int i, StringBuffer ball) {
        switch(n) {
            case 2:
                ball.append(Integer.toBinaryString(i));
                break;
            case 16:
                ball.append(Integer.toHexString(i));
                break;
        }

    }    
}

