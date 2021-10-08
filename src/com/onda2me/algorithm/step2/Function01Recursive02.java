package com.onda2me.algorithm.step2;

/*

재귀함수란?
특정 조건(= 끝나는 조건)이 될 때까지 자기자신을 계속 호출하는 함수이다.
함수 안에 끝나는 조건이 있고, return에서 자기 자신을 호출한다.

### 문제설명
주어진 문자열을 For문과 재귀함수를 이용하여 거꾸로 출력하는 함수를 각각 만들어 비교한다.

*/

public class Function01Recursive02 {    
   
    public static void main(String[] args) {

        solution("abcdef");
    }

    public static void solution(String str) {

        System.out.println("--------------------");
        System.out.println("f("+str+") = "+ reverse(str) ); 
        
        System.out.println("--------------------");
        System.out.println("r("+str+") = "+ reverse(str.toCharArray(), str.length()));        
    }
    

    /**
     * for문을 이용하여 문자열을 거꾸로 출력
     * 예) abcdef -> fedcba
     * 
     * @param str
     * @return
     */
    public static String reverse(String str) {

        StringBuilder bld = new StringBuilder();
        for(int i=0; i<str.length(); i++) {

            bld.append(str.substring(str.length()-1-i, str.length()-i));
        }
        return bld.toString();
    }

    /**
     * 재귀함수를 이용하여 주어진 문자열을 거꾸로 출력
     * 예) abcdef -> fedcba
     * 
     * r(1) = a
     * r(2) = b + r(1) = ba
     * r(3) = c + r(2) = cba
     * r(4) = d + r(3) = dcba
     * r(5) = e + r(4) = edcba
     * r(6) = f + r(5) = fedcba
     * 
     * @param arr
     * @param n
     * @return
     */
    public static String reverse(char arr[], int n) {
        
        if(n <= 0)
            return "";

        return arr[n-1] + reverse(arr, n-1);
    }

}

                