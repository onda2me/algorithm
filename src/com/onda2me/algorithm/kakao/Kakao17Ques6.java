package com.onda2me.algorithm.kakao;

import java.util.ArrayList;

/*

프렌즈4블록(난이도: 상)

# 문제원본 : 문제에 포함된 이미지를 봐야 문제 이해가 수월함.
https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/

같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.
같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.

블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.

만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.

위 초기 배치를 문자로 표시하면 아래와 같다.

TTTANT
RRFACC
RRRFCC
TRRRAA
TTMMMF
TMMTTJ

각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다
입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.

# 입력 형식
입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
2 ≦ n, m ≦ 30
board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.

# 출력 형식
입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.

#  입출력 예제
m	n	board	answer
4	5	[“CCBDE”, “AAADE”, “AAABF”, “CCBBF”]	14
6	6	[“TTTANT”, “RRFACC”, “RRRFCC”, “TRRRAA”, “TTMMMF”, “TMMTTJ”]	15

*/
public class Kakao17Ques6 {    
   
    public static void main(String[] args) {

        // 입력정보 
        solution(4,	5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}, 14 );
        solution(6,	6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}, 15 );
    }


    /**
     * 
     * 
     * @param m 높이
     * @param n 폭
     * @param arr 문자열
     * @param answer 정답
     */
    private static void solution(int m, int n, String[] arr, int answer) {
        String[][] board = new String[m][n];
        int totalCnt = 0;
        int hitCnt = 1;

        // 스트링 문자열을 2차원 배열로 변환
        for(int i=0; i<m; i++) {
            for(int k=0; k<n; k++) {
                board[i][k] = arr[i].substring(k, k+1);
            }
        }

        // Hit 블럭 (2x2 동일블럭) 이 있으면 계속 실행
        while((hitCnt = processHit(m, n, board)) >  0) {
            
            // Hit 블럭 (2x2 동일 블럭) 삭제 후 배열 재정렬
            arrangeList(m, n, board);
            totalCnt += hitCnt;
        }

        // 처리결과 출력
        System.out.println(totalCnt +"=="+answer + " -> \t " + (totalCnt == answer));
        
    }
    
    /**
     * Hit 블럭 체크 및 Hit 처리 함수
     * @param m
     * @param n
     * @param board
     * @return
     */
    private static int processHit(int m, int n, String[][] board) {

        ArrayList<int[]> hitList = new ArrayList<int[]>();

        for(int i=0; i<m-1; i++) {
            for(int k=0; k<n-1; k++) {

                if(!"*".equals(board[i][k])) {
                    if( board[i][k].equals(board[i][k+1]) &&
                        board[i][k].equals(board[i+1][k]) &&
                        board[i][k].equals(board[i+1][k+1])) {

                        if(isHit(i, k, hitList))
                            hitList.add(new int[]{i, k});
                        if(isHit(i, k+1, hitList))
                            hitList.add(new int[]{i, k+1});
                        if(isHit(i+1, k, hitList))
                            hitList.add(new int[]{i+1, k});
                        if(isHit(i+1, k+1, hitList))
                            hitList.add(new int[]{i+1, k+1});

                    }
                }
            }
        }
        for(int[] h : hitList) {
            board[h[0]][h[1]] = "*";
        }

        return hitList.size();
    }

    /**
     * Hit 가능여부 확인 함수
     * @param i
     * @param k
     * @param hitList
     * @return
     */
    private static boolean isHit(int i, int k, ArrayList<int[]> hitList) {

        for(int[] arr : hitList) {
            if(arr[0] == i && arr[1] == k)
                return false;
        }

        return true;
    }

    /**
     * Hit 블럭 재정렬
     * @param m
     * @param n
     * @param board
     */
    private static void arrangeList(int m, int n, String[][] board) {
        
        for(int x=0; x<n; x++) {
            for(int y=m-1; y>0; y--) {

                for(int z=y-1; z>=0; z--) {

                    if("*".equals(board[y][x]) && !"*".equals(board[z][x])) {
                        board[y][x] = board[z][x];
                        board[z][x] = "*";
                    }
                }
            }
        }
    }

    /**
     * 디버그용 배열 프린트 함수
     * @param arr
     */
    private static void print(String[][] arr) {

        System.out.println("");
        for(int i=0; i<arr.length; i++) {
            for(int k=0; k<arr[0].length; k++) {
                System.out.print(arr[i][k]);
            }
            System.out.println("");
        }
    }
}

