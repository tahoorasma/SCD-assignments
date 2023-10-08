package com.mycompany.assignment2.Q2;

import java.util.Scanner;

public class FirstNonRepeatingStream {
    int size;
    char [] array;
    FirstNonRepeatingStream(){
        array = new char[128];
        size = 0;
    }
    void add(char c){
        array[size] = c;
        size++;
    }
    void display(){
        System.out.print("Stream: ['");
        for (int i = 0; i<size-1; i++){
        System.out.print(array[i]+"', '");}
        System.out.println(array[size-1]+"']");
    }
    char getFirstNonRepeating(){
        char []arr = new char[128];
        int s = 0;
        boolean flag;
        for (int i = 0; i<size; i++){
            flag = false;
            for (int j = i+1; j<size; j++){
                if (array[i]==array[j]){
                    flag = true;
                    arr[s] = array[i];
                    s++;
                    break;
                }  
            }
            for (int k = 0; k < s; k++){
                    if (array[i] == arr[k]){
                        flag = true;
                        break;
                    }
                }
            if (!flag)
            return array[i];
        }
        return '-';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FirstNonRepeatingStream stream = new FirstNonRepeatingStream();
        int size;
        //System.out.print("Enter size of stream: ");
        //size = sc.nextInt();
        char ch;
        //for (int i = 0; i<size; i++){
        int i = 0;
        System.out.print("Enter char at "+i+": ");
        ch = sc.next().charAt(0);
        stream.add(ch);
        i++;
        System.out.print("Enter char at "+i+": ");
        ch = sc.next().charAt(0);
        stream.add(ch);
        i++;
        System.out.print("Enter char at "+i+": ");
        ch = sc.next().charAt(0);
        stream.add(ch);
        i++;
        System.out.print("Enter char at "+i+": ");
        ch = sc.next().charAt(0);
        stream.add(ch);
        stream.display();
        System.out.println("Non-Repeating: "+stream.getFirstNonRepeating());
    }
}
