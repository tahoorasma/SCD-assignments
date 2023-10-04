import java.util.Scanner;
public class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("\t\t\tGENERIC STACK");
        System.out.println("-------------------------------------------------------------------------");
        Stack <Integer> stack = new Stack <>();
        System.out.println("Enter stack size: ");
        int size = sc.nextInt();
        //push function
        System.out.println("Enter stack values:");
        for (int i = 0; i < size; i++ ){
            T value = sc.next();
        }

        char ch = 'y';
        while(ch == 'y' || ch == 'Y'){
        System.out.print("Perform Stack Operations\n1. Push\n2. Pop\n3. Size\n4. Is Empty\n5. Quit\nEnter your choice: ");
        int op = 0;
        if (sc.hasNext()){
        op = sc.nextInt();
        switch(op){
            case 1:
            System.out.println("New element added to stack");
            break;
            case 2:
            System.out.println("Popped: ");
            break;
            case 3:
            System.out.println("Size: ");
            break;
            case 4:
            System.out.println("");
            break;
            case 5:
            System.out.println("Program Exited!\n");
            System.exit(0);
            break;}
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
    sc.close();
    }
}