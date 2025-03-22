package pccp;

import java.util.Arrays;

public class PuzzleGameChallenge {
    public static void main(String[] args) {
        int[] diffs = {1, 99999, 100000, 99995};
        int[] times = {9999, 9001, 9999, 9001};
        System.out.println(Solution.solution(diffs,times,3456789012L));
    }

    class Solution {
        public static int solution(int[] diffs, int[] times, long limit) {
            int maxLevel = Arrays.stream(diffs).max().getAsInt();

            return verifyLevel(diffs,times,limit,1,maxLevel);
        }
    }

    //조건  getCostTime < limit인 가장 작은 level, 가장 짧은 시간 = level == diff일 때
    //level <= diff
    static int verifyLevel(int[] diffs, int[] times, long limit, int lowLevel, int highLevel){

        while(lowLevel < highLevel){
            int splitLevel = (highLevel+lowLevel)/2;
            long cost = getCostTime(diffs,times, splitLevel);
            if(cost > limit){
                if(splitLevel == lowLevel) {
                    lowLevel +=1;
                } else {
                    lowLevel = splitLevel;
                }
            } else {
                highLevel = splitLevel;
            }
        }
        return lowLevel;

    }

    static long getCostTime(int[] diffs, int[] times, int level){
        long costTime = 0;
        for (int i = 0 ; i< diffs.length ; i ++){
            if(diffs[i] <= level){
                costTime += times[i];
            } else {
                int prevTime = (i>0)? times[i-1] : times[0];
                costTime += (diffs[i] - level) * (times[i] + prevTime) + times[i];
            }
        }
        return costTime;
    }

    int n; // puzzle amount
    int diff; // current puzzle level
    int time_cur; //current puzzle time cost
    int time_prev; //previous puzzle time cost   ; n -1
    int level; //my proficiency
    int limit; // limit time for solution of all puzzles
    //
    // if(diff <= level || puzzle == 이미 푼 퍼즐) -> 소요 시간 == time_cur
    // else  소요 시간 == (diff - level) * (time_cur+time_prev) + time_cur
    // 관건 = 어떻게 해야 limit에 가장 가깝게 난이도를 고르는가?
    //결국 시간계산 하면  limit보다 낮은 가장 작은 수
}
