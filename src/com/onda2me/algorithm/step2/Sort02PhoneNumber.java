package com.onda2me.algorithm.step2;

/*

전화번호 목록 

### 문제
전화번호 목록이 주어진다. 이때, 이 목록이 일관성이 있는지 없는지를 구하는 프로그램을 작성하시오.    
전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.    
예를 들어, 전화번호 목록이 아래와 같은 경우를 생각해보자    

긴급전화: 911    
상근: 97 625 999    
선영: 91 12 54 26    

이 경우에 선영이에게 전화를 걸 수 있는 방법이 없다.        
전화기를 들고 선영이 번호의 처음 세 자리를 누르는 순간 바로 긴급전화가 걸리기 때문이다.    
따라서, 이 목록은 일관성이 없는 목록이다.    

### 입력    
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (1 ≤ t ≤ 50)    
각 테스트 케이스의 첫째 줄에는 전화번호의 수 n이 주어진다.(1 ≤ n ≤ 10000)    
다음 n개의 줄에는 목록에 포함되어 있는 전화번호가 하나씩 주어진다.    
전화번호의 길이는 길어야 10자리이며, 목록에 있는 두 전화번호가 같은 경우는 없다.    

### 출력    
각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력한다.    


### 예제    

입    력 |  출    력     
----- | ----- 
911, 97625999, 91125426 |  NO
113, 12340, 123440, 12345, 98346 | YES

### 문제원본    
[https://www.acmicpc.net/problem/5052](https://www.acmicpc.net/problem/5052){: target="_blank"}


*/

public class Sort02PhoneNumber {    
   
    public static void main(String[] args) {

        // 입력정보
        solution(new int[] {911, 97625999, 91125426}, "NO");
        solution(new int[] {113, 12340, 123440, 12345, 98346}, "YES");
    }

    private static void solution(int[] arr, String answer) {

        String str1, str2 = null;
        String result = "YES";

        // 주어진 배열을 하나씩 확인
        for(int i=0; i<arr.length; i++) {
            for(int k=0; k<arr.length; k++) {
                
                if(i != k) {
                    // int -> String으로 변환
                    str1 = String.valueOf(arr[i]);
                    str2 = String.valueOf(arr[k]);


                    /*
                    // 전화번호가 다른전화번호를 포함하는지 체크 
                    // 0이면 전화번호가 다른전화번호로 시작한다.
                    //if(str1.indexOf(str2) == 0) { 
                    */
                    //전화번호가 다른전화번호로 시작하는지 체크
                    if(str1.startsWith(str2)) {                    
                        result = "NO";
                        break;                        
                    }
                }

            }
        }

        // 결과 출력
        System.out.println((answer.equals(result)) + " => " + result + " == " + answer);
    }
}

                