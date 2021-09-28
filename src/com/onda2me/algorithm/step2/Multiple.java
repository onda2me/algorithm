package com.onda2me.algorithm.step2;

/*

3의 배수

원본문제 : https://www.acmicpc.net/problem/1769

문제 1. "양의 정수 X는 3의 배수인가?"

X의 각 자리의 수를 단순히 더한 수 Y를 만든다. 
예를 들어 X가 1107이었다면, Y는 1+1+0+7=9가 된다. 그리고 Y에 대해서, 아래와 같은 문제를 생각한다.

문제 2. "Y는 3의 배수인가?"

위의 문제 1의 답은 아래의 문제 2의 대답과 일치한다. 위의 예의 경우, Y=9는 3의 배수이므로 X=1107 역시 3의 배수가 되는 것이다. 
214는 각 자리수의 합 2+1+4=7이 3의 배수가 아니므로 3의 배수가 아니다.

문제 변환의 과정을 여러 번 거쳐 Y가 한 자리 수가 될 때까지 문제 변환을 반복한다는 뜻이다. 
변환 후의 Y가 3, 6, 9 중 하나이면 원래의 수 X는 3의 배수이고, Y가 1, 2, 4, 5, 7, 8 중 하나이면 원래의 수 X는 3의 배수가 아니다.

큰 수 X가 주어졌을 때, 문제 변환의 과정을 몇 번 거쳐야 Y가 한 자리 수로 만들어 3의 배수인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 큰 자연수 X가 주어진다. X는 1,000,000자리 이하의 수이다.

출력
첫째 줄에 문제 변환의 과정을 몇 번 거쳤는지를 출력한다. 이 수는 음이 아닌 정수가 되어야 한다. 
둘째 줄에는 주어진 수가 3의 배수이면 YES, 아니면 NO를 출력한다.

예제 입력       예제 출력          
1234567         3, NO
1107            1, YES

# 힌트
1234567 -> 28 -> 10 -> 1 (NO)

*/

public class Multiple {    
   
    public static void main(String[] args) {

        // 입력정보
        solution(1234567, 3, "NO");
        solution(1107, 1, "YES"); 
    }


    private static void solution(int n, int anw1, String anw2 ) {

        int sum = processSum(n);

        System.out.println(sum);
    }

    private static int processSum(int n) {

        if(n > 10) {
            String str = String.valueOf(n);
            int sum = 0;
    
            for(int i=0; i<str.length(); i++) {
                sum += Integer.parseInt(str.substring(i, i+1));
            }

            System.out.println(n +" -- > " + sum);
 
            return processSum(sum);
        } 

        return n;
    }
}

                