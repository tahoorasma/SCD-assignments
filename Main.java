package com.mycompany.assignment2.Q1;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    public static int checkInput(int op){
        Scanner sc = new Scanner(System.in);
        while (true) {
        try {
            if(sc.hasNext())
            break;
            else 
                throw new Exception();
        } catch (Exception e) {
            sc.next();
            System.out.print("No input available");
        }
        }
        while (true) {
        try {
            op = sc.nextInt();
            break;
        } catch (Exception e) {
            sc.next();
            System.out.println("Invalid input.\nPlease enter an integer value.");
            System.out.print("Enter your choice: ");
        }
        }  
        return op;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println("\t\t\t\tGENERIC STACK");
            System.out.println("-------------------------------------------------------------------------");
            GenericStack <Integer> intStack = new GenericStack <>();
            System.out.print("Enter integer stack size: ");
            int size = sc.nextInt();
            System.out.println("Enter integer stack values:");
            for (int i = 0; i < size; i++){
                int value; 
                System.out.print("->");
                while (true) {
                    try {
                        value = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        sc.next();
                        System.out.println("Invalid input.\nPlease enter an integer value.");
                        System.out.print("->");
                    }
                    }
                intStack.push(value);
            }
            try {
            intStack.items();
            } catch (EmptyStackException e) {
            System.out.println("Empty stack exception caught");}
            GenericStack <Float> floatStack = new GenericStack <>();
            System.out.print("Enter float stack size: ");
            size = sc.nextInt();
            System.out.println("Enter float stack values:");
            for (int i = 0; i < size; i++){
                float value; 
                System.out.print("->");
                while (true) {
                    try {
                        value = sc.nextFloat();
                        break;
                    } catch (Exception e) {
                        sc.next();
                        System.out.println("Invalid input.\nPlease enter a float value.");
                        System.out.print("->");
                    }
                    }
                floatStack.push(value);
            }
            try {
            floatStack.items();
            } catch (EmptyStackException e) {
            System.out.println("Empty stack exception caught");}
            GenericStack <String> stringStack = new GenericStack <>();
            System.out.print("Enter string stack size: ");
            size = sc.nextInt();
            System.out.println("Enter string stack values:");
            for (int i = 0; i < size; i++){
                String value; 
                System.out.print("->");
                while (true) {
                    try {
                        value = sc.next();
                        break;
                    } catch (Exception e) {
                        sc.next();
                        System.out.println("Invalid input.\nPlease enter a string value.");
                        System.out.print("->");
                    }
                    }
                stringStack.push(value);
            }
            try {
            stringStack.items();
            } catch (EmptyStackException e) {
            System.out.println("Empty stack exception caught");}
            char ch = 'y';
            while(ch == 'y' || ch == 'Y'){
                System.out.print("\nPerform Stack Operations\n1. Push\n2. Pop\n3. Peek\n4. Size\n5. Is Empty\n6. Show Stack Items\n7. Quit\nEnter your choice: ");
                int op = 0;
                op = checkInput(op);
                    switch(op){
                        case 1 -> {
                            System.out.print("1. Integer\n2. Float\n3. String\nEnter: ");
                            int i = 0;
                            i = checkInput(i);
                            switch(i){
                            case 1 -> {
                            System.out.print("Enter value to push: ");
                            int val = sc.nextInt();
                            intStack.push(val);}
                            case 2 -> {
                            System.out.print("Enter value to push: ");
                            float val = sc.nextFloat();
                            floatStack.push(val);}
                            case 3 -> {
                            System.out.print("Enter value to push: ");
                            String val = sc.nextLine();
                            stringStack.push(val);}
                            }
                            System.out.println("New element added to stack");
                        }
                        case 2 -> {
                            try {
                            System.out.print("1. Integer\n2. Float\n3. String\nEnter: ");
                            int i = 0;
                            i = checkInput(i);
                            switch(i){
                            case 1 -> System.out.println("Popped: "+intStack.pop());
                            case 2 -> System.out.println("Popped: "+floatStack.pop());
                            case 3 -> System.out.println("Popped: "+stringStack.pop());
                            }
                        } catch (EmptyStackException e) {
                        System.out.println("Empty stack exception caught");}
                        }
                        case 3 -> {
                            try {
                            System.out.print("1. Integer\n2. Float\n3. String\nEnter: ");
                            int i = 0;
                            i = checkInput(i);
                            switch(i){
                            case 1 -> System.out.println("Top element: "+intStack.peek());
                            case 2 -> System.out.println("Top element: "+floatStack.peek());
                            case 3 -> System.out.println("Top element: "+stringStack.peek());
                            }
                        } catch (EmptyStackException e) {
                        System.out.println("Empty stack exception caught");}
                        }
                        case 4 -> {
                            System.out.print("1. Integer\n2. Float\n3. String\nEnter: ");
                            int i = 0;
                            i = checkInput(i);
                            switch(i){
                            case 1 -> System.out.println("Size: "+intStack.size());
                            case 2 -> System.out.println("Size: "+floatStack.size());
                            case 3 -> System.out.println("Size: "+stringStack.size());
                        }}
                        case 5 -> {
                            System.out.print("1. Integer\n2. Float\n3. String\nEnter: ");
                            int i = 0;
                            i = checkInput(i);
                            switch(i){
                            case 1 -> 
                            {if (!intStack.isEmpty())
                            System.out.println("Stack is not empty");}
                            case 2 -> 
                            {if (!floatStack.isEmpty())
                            System.out.println("Stack is not empty");}
                            case 3 -> 
                            {if (!stringStack.isEmpty())
                            System.out.println("Stack is not empty");}
                        }}
                        case 6 -> {
                            try {
                            System.out.print("1. Integer\n2. Float\n3. String\nEnter: ");
                            int i = 0;
                            i = checkInput(i);
                            switch(i){
                            case 1 -> intStack.items();
                            case 2 -> floatStack.items();
                            case 3 -> stringStack.items();
                        }
                        } catch (EmptyStackException e) {
                        System.out.println("Empty stack exception caught");}
                        }
                        case 7 -> {
                            System.out.println("Program Exited!\n");
                            System.exit(0);
                        }
                    }
                System.out.print("\nContinue? y/n ");
                    while (true) {
                    try {
                        if(sc.hasNext())
                        break;
                        else 
                            throw new Exception();
                    } catch (Exception e) {
                        sc.next();
                        System.out.print("No input available");
                    }
                    }
                    while (true) {
                    try {
                    ch = sc.next().charAt(0);
                        if (!Character.isLetter(ch)) {
                            throw new Exception ("Invalid character input.\nPlease enter a letter.");
                        }
                        else
                            break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.out.print("\nContinue? y/n ");
                        ch = sc.next().charAt(0);
                    }
                    }
                    sc.nextLine();
                if (ch == 'N' || ch == 'n'){
                    System.out.println("\nProgram Terminated!\n");
                    break;
                }
            }
        }
    }
}
