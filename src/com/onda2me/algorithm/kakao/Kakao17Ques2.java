package com.onda2me.algorithm.kakao;

/*
다트 게임(난이도: 하)

# 문제설명
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

1.다트 게임은 총 3번의 기회로 구성된다.
2.각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
3.점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수^1 , 점수^2 , 점수^3 )으로 계산된다.
4.옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
5.스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
6.스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
7.스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
8.Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
9.스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.

# 입력 형식
“점수|보너스|[옵션]”으로 이루어진 문자열 3세트.
예) 1S2D*3T

점수는 0에서 10 사이의 정수이다.
보너스는 S, D, T 중 하나이다.
옵선은 *이나 # 중 하나이며, 없을 수도 있다.

# 출력 형식
3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
예) 37

# 입출력 예제
-   dartResult      answer	    설명
1   1S2D*3T         37          1^1 * 2 + 2^2 * 2 + 3^3
2   1D2S#10S        9           1^2 + 2^1 * (-1) + 10^1
3   1D2S0T          3           1^2 + 2^1 + 0^3
4   1S*2T*3S        23          1^1 * 2 * 2 + 2^3 * 2 + 3^1
5   1D#2S*3S        5           1^2 * (-1) * 2 + 2^1 * 2 + 3^1
6   1T2D3D#         -4          1^3 + 2^2 + 3^2 * (-1)
7   1D2S3T*         59          1^2 + 2^1 * 2 + 3^3 * 2

*/
    
public class Kakao17Ques2 {
    
   
    public static void main(String[] args) {

        // 입력정보 변수선언
        String question[] = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
        String answer[] = {"37", "9", "3", "23", "5", "-4", "59"};

        // 출력정보 변수선언
        int result = 0;

        // 결과 출력
        for(int i=0; i<question.length; i++) {
            result = getPoint(question[i]);
            System.out.println(result +" ==  " + answer[i] + " \t-> " + (result == Integer.parseInt(answer[i])));
        }
    }

    // 점수 계산 함수
    public static int getPoint(String pointStr) {

        int point[] = new int[3];
        String pointTmp = "";
        int idx = 0;  // 점수는 최대3개이므로 idx도 최대 3개
        int idxTmp = 0;
        
        // 원본 점수 저장
        for(char c : pointStr.toCharArray()) {
            if(Character.isDigit(c)) {
                pointTmp = pointTmp + c;              
            } else {

                if(!"".equals(pointTmp)) {
                    point[idx] = Integer.parseInt(pointTmp);        
                    pointTmp = "";
                    idx++;
                }
            }
        }

        // for(int i=0; i<point.length; i++) {
        //     System.out.println("point["+i+"] " + point[i]);
        // }

        // 보너스와 옵션에 따른 점수계산 함수
        for(int i=0; i<pointStr.length(); i++) {

            char c = pointStr.charAt(i);

            if(Character.isDigit(c)) {

                // 점수가 10, 즉 숫자가 2개 연달아 있는 경우는 제외
                if(i == 0 ||  (i > 0 && !Character.isDigit(pointStr.charAt(i-1)))) {
                    idxTmp++;
                    idx = idxTmp-1; // 보너스와 옵션은 점수뒤에 나오므로 점수 idx-1 해 준다.
                }
            } else {
                switch(c) {
                    case 'S' :
                        point[idx] = point[idx];
                        break;

                    case 'D' :
                        point[idx] = point[idx]*point[idx];
                        break;

                    case 'T' :
                        point[idx] = point[idx]*point[idx]*point[idx];
                        break;

                    case '*' :
                        point[idx] = point[idx]*2;
                        if(idx > 0)
                            point[idx-1] = point[idx-1]*2;
                        break; 

                    case '#' :
                        point[idx] = point[idx]*-1;
                        break;                       
                }
            }
        }

        // for(int i=0; i<point.length; i++) {
        //     System.out.println("point["+i+"] " + point[i]);
        // }

        return point[0] + point[1] + point[2];
    }
}
