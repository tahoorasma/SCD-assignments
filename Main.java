package com.mycompany.assignment2.Q3;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void mergeIntervals(List<int[]> intervals){
        int s = 0;
        int e = 0;
        for (int[] array : intervals) {
            s = array[0];
            if (e>s){
            array[0] = e;
            }
            e = array[1];
        }
        s = 0;
        e = 0;
        int a = 0;
        int i = -1;
        int j = -1;
        for (int[] array : intervals){
            s = array[0];
            if (e == s){
            array[0] = a;
            j = i;
            }
            e = array[1];
            a= array[0];
            i++;
        }
        if (j>0)
            intervals.remove(j);
}
    public static void display(List<int[]> intervals){
        System.out.print("[ ");
        for (int[] array : intervals) {
            System.out.print("{" + array[0] + "," + array[1] + "} ");
        }
        System.out.println("]");
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            int [] array = new int[2];
            for (int j = 0; j < 2; j++) {
                String s;
                if (j == 0) s = "start";
                else s = "end";
                System.out.print("Enter "+s+" for interval "+(i+1)+":\t");
                array[j] = sc.nextInt();
            }
            intervals.add(array);
        }
        display(intervals);
        mergeIntervals(intervals);
        System.out.println("After merging");
        display(intervals);
    }
}
