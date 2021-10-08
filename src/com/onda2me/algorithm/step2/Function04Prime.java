package com.onda2me.algorithm.step2;

/*

에라토스테네스의 체를 이용하여 소수 확인하기

### 에라토스테네스의 체
양의 정수 n이 합성수이면, n의 소인수 중에는 √n보다 작거나 같은 소인수(소수인 약수)가 존재한다. 
예를 들면 30은 합성수이다. 30의 약수 중에는 3이 있는데 3은 √30보다 작다. 
에라토스테네스의 체는 어떤 큰 자연수가 소수인지 아닌지 알아볼 때 쓸 수 있는 방법이다.

### 풀이방법
+ 예시1 
1001 => √1001 = 31
31보다 작거나 같은 소수는 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 이다.
1001은 7로 나누어 떨어지므로 소수가 아니다.

+ 예시2
911 => 911 = 30
30보다 작거나 같은 소수는 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 이다.
911은 위의 소수로 나누어 떨어지지 않으므로 소수이다.

*/

public class Function04Prime {    
   

    // 1부터 100까지의 소수
    private static int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static void main(String[] args) {

        // 입력정보
        int n = 911;
        System.out.println("prime("+n+") = " + prime(n));

        System.out.println("prime("+1001+") = " + prime(1001));
    }

    private static int prime(int n) {
        
        int result = (int) Math.sqrt(n);
   
        // 에라토스테네스의 체로 나누어 떨어지는지 확인
        for(int i=0; i<primes.length; i++) {

            // √n의 값이 비교하는 소수보다 크면 중지
            if(result < primes[i])
                 return 0;

            // n값이 소수로 나누어지면 그소수가 약수이다.
            if(n % primes[i] == 0)
                return primes[i];
            
        }
        return 0;     
    }
}                