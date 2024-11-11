package org.example;

// [PCCP 기출문제] 1번 / 동영상 재생기
public class RecordPlayer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String time = "13:14";
        String[] commands = {"next", "prev"};
        System.out.println(solution.solution("34:33"	,"13:00"	,"00:55"	,"02:55",commands));
    }
}

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_len_sec = parseToSeconds(video_len);
        int pos_sec = parseToSeconds(pos);
        int op_start_sec = parseToSeconds(op_start);
        int op_end_sec = parseToSeconds(op_end);

        pos_sec = posSec(pos_sec, op_start_sec, op_end_sec);

        for(int i = 0 ; i < commands.length ; i ++){
            pos_sec = posSec(pos_sec, op_start_sec, op_end_sec);
            if(commands[i].equals("prev")){
                pos_sec = Math.max(0, pos_sec-10);
            } else if(commands[i].equals("next")){
                pos_sec = Math.min(video_len_sec, pos_sec+10);
            }
        }
        pos_sec = posSec(pos_sec, op_start_sec, op_end_sec);
        String answer = parseToTimeString(pos_sec);

        return answer;
    }
    int parseToSeconds(String time){
        String[] minSec = time.split(":");
        int secondTime = Integer.parseInt(minSec[0])*60 + Integer.parseInt(minSec[1]);
        return secondTime;
    }
    String parseToTimeString(int time){
        String minute = String.valueOf(time/60);
        minute = addZero(minute);
        String seconds = String.valueOf(time%60);
        seconds = addZero(seconds);
        return minute+":"+seconds;
    }
    String addZero(String time){
        return (time.length() == 1)?"0"+time : time;
    }
    // return inOpenning? openEnd : pos
    int posSec(int pos, int op_start, int op_end){
        if(op_start <= pos && pos <= op_end){
            return op_end;
        }
        return pos;
    }
    int prevSeconds(int pos, int op_start){

        return Math.max(pos - 10, 0);

    }
    
}