package com.onda2me.algorithm.kakao;

/*
비밀 지도(난이도: 하)
문제 원본 : https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/

# 문제설명
1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 “공백”(“ “) 또는 “벽”(“#”) 두 종류로 이루어져 있다.
2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 “지도 1”과 “지도 2”라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
3. “지도 1”과 “지도 2”는 각각 정수 배열로 암호화되어 있다.
4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

# 입력 형식
1. 입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다. (1 ≦ n ≦ 16)
2. arr1, arr2는 길이 n인 정수 배열로 주어진다.
3. 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2^n – 1을 만족한다.

# 출력 형식
원래의 비밀지도를 해독하여 "#", 공백으로 구성된 문자열 배열로 출력하라.


# 입출력 예제1
매개변수	값
n	5
arr1	[9, 20, 28, 18, 11]
arr2	[30, 1, 21, 17, 28]
출력	["#####","# # #", "### #", "# ##", "#####"]

# 입출력 예제2
매개변수	값
n	6
arr1	[46, 33, 33 ,22, 31, 50]
arr2	[27 ,56, 19, 14, 14, 10]
출력	["######", "### #", "## ##", " #### ", " #####", "### # "]

*/

public class Kakao17Ques1 {
    
    public static void main(String[] args) {

        // 입력정보 변수선언
        // int n = 5;
        // int []arr1 = {9, 20, 28, 18, 11};
        // int []arr2 = {30, 1, 21, 17, 28};

        int n = 6;
        int []arr1 = {46, 33, 33 ,22, 31, 50};
        int []arr2 = {27 ,56, 19, 14, 14, 10};

        // 출력정보 변수선언
        String bitArr[] = toBinary(n, arr1, arr2);
        
        // 결과 출력
        print(bitArr);
	}

    /**
     * 입력받은 두개의 숫자 배열을 or 연산하여 binaryString 배열로 변환한다.
     * 
     * @param n
     * @param arr1
     * @param arr2
     * @return
     */
    public static String[] toBinary(int n, int arr1[], int arr2[]) {

        String bitArr[] = new String[n];


        for(int i=0; i<n; i++) {
            bitArr[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // 처리과정 확인용
            // System.out.print(bitArr[i]);
            // System.out.print(" --> ");

            bitArr[i] = decodeMap(n, bitArr[i]);
            // 처리결과 확인용
            // System.out.println(bitArr[i]);

        }

        return bitArr;
    }

    /**
     * 1과 0으로 구성된 문자열을 #으로 구성된 지도문자로 변환한다.
     * 
     * @param n
     * @param bitStr
     * @return String
     */
    public static String decodeMap(int n, String bitStr) {

        for(int k=0; k< n - bitStr.length(); k++) {
            bitStr = "0" + bitStr;
        }
        
         return bitStr.replace("0", "_").replace("1", "#");
    }

    /**
     * 결과를 출력한다.
     * @param arr
     */
    public static void print(String arr[]) {

        StringBuffer sb = new StringBuffer();
        for(String s : arr) {
            sb.append(", ").append(s);
        }

        System.out.println(sb.toString().replaceFirst(", ", ""));
    }
}
