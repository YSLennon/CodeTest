package secureCoding;

import java.util.Scanner;

public class SecureCoding2 {
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 5, 4};
        System.out.println(maxNum(arr));
        System.out.println(maxNum2(arr));

    }
    public static int maxNum(int[] arr){
        int tmp = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[tmp] < arr[i]){
                tmp = i;
            }
        }
        return arr[tmp];
    }
    public static int maxNum2(int[] arr){
        int tmp = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            tmp = Math.max(tmp,arr[i]);
        }
        return tmp;
    }
}
