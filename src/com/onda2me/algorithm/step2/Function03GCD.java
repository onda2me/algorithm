package com.onda2me.algorithm.step2;

/*

유클리드 호제법을 이용하여 최대공약수 구하기

### 유클리드 호제법
두정수 a, b의 최대공약수를 gcd(a, b)라고 하면 gcd(a, b) = gcd(b, r) 이다
(위 식에서 r은 a/b의 나머지인 a%b의 값이다.)

### 예시
gcd(30, 12) = gcd(12, 6) = gcd(6, 0)
따라서 30과 12의 최대공약수는 6이다

*/

public class Function03GCD {    
   
    public static void main(String[] args) {

        // 입력정보
        solution(30, 12);
        solution(32, 60);
    }

    private static void solution(int a, int b) {

        int result = gcd(a, b);
        System.out.println("gcd("+a+", "+b+") = " + result);
    }

    private static int gcd(int a, int b) {

        // 나머지가 0 이면, 비교되는 수가 공약수
        if(b == 0)
            return a;

        // 두 비교 수 중에 1이 있으면, 공약수가 없다.
        if(a == 1 || b == 1)
            return 1;
                
        if(a > b)
            return gcd(b, a%b);
        
        return gcd(a, b%a);        
    }
}

                