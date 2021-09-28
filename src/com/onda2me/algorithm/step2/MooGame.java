package com.onda2me.algorithm.step2;

/*
# 문제
Moo 게임은 Moo수열을 각 사람이 하나씩 순서대로 외치면 되는 게임이다.
Moo 수열은 길이가 무한대이며, 다음과 같이 생겼다. 

m o o m o o o m o o m o o o o m o o m o o o m o o m o o o o o 
Moo 수열은 다음과 같은 방법으로 재귀적으로 만들 수 있다. 먼저, S(0)을 길이가 3인 수열 "m o o"이라고 하자. 
1보다 크거나 같은 모든 k에 대해서, S(k)는 S(k-1)과 o가 k+2개인 수열 "m o ... o" 와 S(k-1)을 합쳐서 만들 수 있다.

S(0) = "m o o"
S(1) = "m o o m o o o m o o"
S(2) = "m o o m o o o m o o m o o o o m o o m o o o m o o"
위와 같은 식으로 만들면, 길이가 무한대인 문자열을 만들 수 있으며, 그 수열을 Moo 수열이라고 한다.

N이 주어졌을 때, Moo 수열의 N번째 글자를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N (1 ≤ N ≤ 109)이 주어진다.

출력
N번째 글자를 출력한다.

예제 입력 1 
11
예제 출력 1 
m
*/

public class MooGame {    
   
    public static void main(String[] args) {

        // 입력정보
        solution(2);
        //solution(3);

       
    }


    private static void solution(int n) {
        StringBuffer buff = new StringBuffer();
        //makeMoo(n, buff);

        System.out.println(buff.toString());
    }

    private static StringBuffer makeMooDel(int k, StringBuffer buff_org) {
        StringBuffer buff = new StringBuffer("");
        String moo = "moo";

        System.out.print("makeMoo:"+k+"\n-----\n");

        if(k  < 1)
            return buff;

        for(int i=0; i<=k; i++) {
            
            buff.append(moo);

            for(int j=0; j<i; j++) {
                buff.append("o");
            }

            buff.append(" ").append(buff.toString());
            System.out.println(i + ":" + buff.toString());
        }

         //makeMoo(k-1, buff);
       
        System.out.println("");

        return buff_org.append(buff.toString());
    }
    
    private static void makeMoo(int k, StringBuffer bbuff) {

        

    }
}
                