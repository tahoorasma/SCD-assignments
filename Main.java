package com.mycompany.assignment2;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println("\t\t\t\tGENERIC STACK");
            System.out.println("-------------------------------------------------------------------------");
            GenericStack <Integer> stack = new GenericStack <>();
            System.out.print("Enter stack size: ");
            int size = sc.nextInt();
            System.out.println("Enter stack values:");
            for (int i = 0; i < size; i++ ){
                int value = sc.nextInt();
                stack.push(value);
            }
            stack.items();
            char ch = 'y';
            while(ch == 'y' || ch == 'Y'){
                System.out.print("\nPerform Stack Operations\n1. Push\n2. Pop\n3. Peek\n4. Size\n5. Is Empty\n6. Show Stack Items\n7. Quit\nEnter your choice: ");
                int op;
                if (sc.hasNext()){
                    op = sc.nextInt();
                    switch(op){
                        case 1 -> {
                            System.out.print("Enter value to push: ");
                            int val = sc.nextInt();
                            stack.push(val);
                            System.out.println("New element added to stack");
                        }
                        case 2 -> {System.out.println("Popped: "+stack.pop());}
                        case 3 -> {System.out.println("Top element: "+stack.peek());}
                        case 4 -> {System.out.println("Size: "+stack.size());}
                        case 5 -> {
                            if (!stack.isEmpty())
                            System.out.println("Stack is not empty");}
                        case 6 -> {stack.items();}
                        case 7 -> {
                            System.out.println("Program Exited!\n");
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("No input available.");
                    break;
                }
                System.out.print("\nContinue? y/n ");
                if (sc.hasNext()) {
                    ch = sc.next().charAt(0);
                    sc.nextLine();
                } else {
                    System.out.println("No input available.");
                    break;
                }
                if (ch == 'N' || ch == 'n'){
                    System.out.println("\nApplication terminated!\n");
                    break;}
            }
        }
        //catch (){}
    }
}
