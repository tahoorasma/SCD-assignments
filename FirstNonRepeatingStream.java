package com.mycompany.assignment2.Q2;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstNonRepeatingStream {
    private ArrayList<Character> list = new ArrayList<Character>();
    int size;
    char [] array;
    FirstNonRepeatingStream(){
        array = new char[128];
        size = 0;
    }
    void add(char c){
        array[size] = c;
        size++;
        if (list.contains(c)){
            list.remove(Character.valueOf(c));
            return;
        }
        else
        list.add(c);
    }
    void display(){
        if (size>0){
        System.out.print("Stream: ['");
        for (int i = 0; i<size-1; i++){
        System.out.print(array[i]+"', '");}
        System.out.println(array[size-1]+"']");}
        else
        System.out.println("No data");
    }
    char getFirstNonRepeating(){
        if (!list.isEmpty())
        return list.get(0);
        return '-';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FirstNonRepeatingStream stream = new FirstNonRepeatingStream();
        char ch;
        int i = 0;
        System.out.println("Enter 0 to stop");
        while (i<100){
        System.out.print("Enter char at "+i+": ");
        ch = sc.next().charAt(0);
        if (ch == '0') break;
        stream.add(ch);
        i++;
        }
        stream.display();
        System.out.println("Non-Repeating: "+stream.getFirstNonRepeating());
    }
}
