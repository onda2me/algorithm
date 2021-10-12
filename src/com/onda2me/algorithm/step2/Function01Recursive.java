package com.onda2me.algorithm.step2;

/*

재귀함수란?
특정 조건(= 끝나는 조건)이 될 때까지 자기자신을 계속 호출하는 함수이다.
함수 안에 끝나는 조건이 있고, return에서 자기 자신을 호출한다.

*/
public class Function01Recursive {    
   
    public static void main(String[] args) {
        solution(7);
    }

    public static void solution(int n) {
        int result = 0;
        String resultstr = null;

        // factorial
        result = factorial(n);
        System.out.println(n+"! = "+ result );

        // 누적합
        result = sum(n);
        System.out.println("sum("+n+") = "+ result );        

        // 피보나치
        result = fibonacci(n);
        System.out.println("f("+n+") = "+ result );

        // n의 m제곱수 
        result = squared(2, 4);
        System.out.println("squared(2, 4) = "+ result );  

        // n부터 1씩 감소하여 출력하기
        resultstr = decrease(n);
        System.out.println("decrease("+n+") = "+ resultstr );

        // 10진수를 2진수로 변환
        resultstr = binary("", n);
        System.out.println("binary("+n+") = "+ resultstr );      
        
    }

    /**
     * Factorial(계승) : 1부터  n까지의 곱, n!로 표시
     * 0! = 1
     * 1! = 1
     * 2! = 2 * 1! = 2
     * 3! = 3 * 2! = 6
     * 4! = 4 * 3! = 24
     * 5! = 5 * 4! = 120
     * 6! = 6 * 5! = 720
     * 7! = 7 * 6! = 5040
     * 
     * @param n
     * @return
     */
    private static int factorial(int n) {

        if (n == 1)
            return 1;

        return n * factorial(n-1);
    }

    /**
     * 1부터 n까지의 숫자의 누적합 구하기
     * sum(1) = 1
     * sum(2) = 2 + sum(1) = 3
     * sum(3) = 3 + sum(2) = 6
     * sum(4) = 4 + sum(3) = 10
     * sum(5) = 5 + sum(4) = 15
     * sum(6) = 6 + sum(5) = 21
     * sum(7) = 7 + sum(6) = 28
     * 
     * @param n
     * @return
     */
    public static int sum(int n) {
        if(n == 1)
            return 1;

        return n + sum(n-1);
    }

    /**
     * 피보나치 수열 : 앞의 두 수의 합이 바로 뒤의 수가 되는 배열
     * 
     * f(0) = 0
     * f(1) = 1
     * f(2) = f(1) + f(0) = 1 
     * f(3) = f(2) + f(1) = 1 + 1 = 2
     * f(4) = f(3) + f(2) = 2 + 1 = 3
     * f(5) = f(4) + f(3) = 3 + 2 = 5
     * f(6) = f(5) + f(4) = 5 + 3 = 8
     * f(7) = f(6) + f(5) = 8 + 5 = 13
     * f(8) = f(7) + f(6) = 13+ 8 = 21
     * 
     * @param n
     * @return
     */
    public static int fibonacci(int n) {

        if(n <= 2) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    
    /**
     * n 의 m 제곱수 구하기 (n * n * n ... m번)
     * s(2, 1) = 2
     * s(2, 2) = 2 * s(2, 1) = 4
     * s(2, 3) = 2 * s(2, 2) = 8
     * s(2, 4) = 2 * s(2, 3) = 16
     * 
     * @param n
     * @param m
     * @return
     */
    public static int squared(int n, int m) {

        if(m < 1)
            return 1;

        return n * squared(n, m-1);
    }

    

    /**
     * n부터 1씩 감소하여 출력한다.
     * d(1) = 1
     * d(2) = 2 + d(1)
     * d(3) = 3 + d(2) = 3 + 2 + 1
     * d(4) = 4 + d(3) = . . . . 
     * 
     * 
     * @param n
     * @return
     */
    private static String decrease(int n) {

        if(n < 1)
            return "";
        
        return n + decrease(n-1);
    }

    /**
     * 
     * 양의정수 n을 2진수로 변환
     * 
     * b(0) = 0
     * b(1) = 1
     * b(2) = 10 = b(2/2) + r(2%2) = b(1) + r(0)
     * b(3) = 11 = b(3/2) + r(3%2) = b(1) + r(1) = 1 1
     * b(4) = 100 = b(4/2) + r(4%2) = b(2) + r(0) = b(1) + r(0) + r(0) = 1 0 0
     * b(5) = 101 = b(5/2) + r(5%2) = b(2) + r(1) = b(1) + r(0) + r(1) = 1 0 1
     * b(6) = 110 = b(6/2) + r(6%2) = b(3) + r(0) = b(1) + r(1) + r(0) = 1 1 0
     * b(7) = 111 = b(7/2) + r(7%2) = b(3) + r(1) = b(1) + r(1) + r(1) = 1 1 1
     * b(8) = 1000 = b(8/2) + r(8%2) = b(4) + r(0) = b(1) + r(0) + r(0) + r(0) = 1 0 0 0
     * b(9) = 1001 = b(9/2) + r(9%2) = b(4) + r(1) = b(1) + r(0) + r(0) + r(1) = 1 0 0 1
     * b(10) = 1010 = b(10/2) + r(10%2) = b(5) + r(0) 
     * @param n
     * @return
     */
    public static String binary(String str, int n) {

        if(n < 1) {
            return "";
        }
        
        return binary(str, n/2) + String.valueOf(n%2); 
    }
}

                