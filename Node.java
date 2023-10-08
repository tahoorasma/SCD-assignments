package com.mycompany.assignment2.Q1;

public class Node<T> {
    public T data;
    public Node next;
    public Node(){
        data = null;
        next = null;
    }
    public Node(T value){
        data = value;
        next = null;
    }
}
