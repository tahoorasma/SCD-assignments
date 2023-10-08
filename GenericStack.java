package com.mycompany.assignment2.Q1;
import java.util.EmptyStackException;
import java.util.Scanner;

public class GenericStack<T> {
    private Node<T> top;    
    private int size;
    private T data;
    public <T> GenericStack(){
        size = 0;
        top = null;
    }
    public void push(T value){
        Node<T> newnode = new Node<>(value);
        newnode.next = top;
        top = newnode;
        size++;
    }
    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        else {
        T value = (T)top.data;
        top = top.next;
        size--;
        return value;}
    }
    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return (T)top.data;
    }
    public boolean isEmpty(){
        if (top == null){
            System.out.println("Stack is empty");
            return true;
        }
        else {
            return false;
        }
    }
    public int size(){
        return size;
    }
    public void items(){
        if (!isEmpty()){
        System.out.print("Stack items: [");
        Node<T> current;
        current = top;
           while(current.next != null){
            System.out.print(current.data+", ");
            current = current.next;
        }
        System.out.println(current.data+"]");
    }
        else {
            throw new EmptyStackException();
        }
    }
}
