package calc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import calc.Calculator;

import static java.lang.System.exit;

public class CalculatorTest
{

    public static void main(String args[]) throws SQLException {
        Calculator c = new Calculator();
        Scanner in = new Scanner(System.in);
        int ch,num;
        String opr;
        do {
            System.out.println("****MENU****");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Absolute value");
            System.out.println("7. Modulus");
            System.out.println("8. Find Maximum no.");
            System.out.println("9. Find Minimum no.");
            System.out.println("10. Read data from table");
            System.out.println("11. Read particular data from table");
            System.out.println("12. Exit");
            System.out.println("\nEnter your choice=");
            ch = in.nextInt();
            switch (ch) {
                case 1:
                    c.input();
                    System.out.println("Sum of two nos.=" + c.add());
                    c.write();
                    break;
                case 2:
                    c.input();
                    System.out.println("Subtraction of two nos.=" + c.sub());
                    c.write();
                    break;
                case 3:
                    c.input();
                    System.out.println("Multiplication of two nos.=" + c.mul());
                    c.write();
                    break;
                case 4:
                    c.input();
                    System.out.println("Division of two nos.=" + c.div());
                    c.write();
                    break;
                case 5:
                    c.input();
                    System.out.println("Power of two nos.=" + c.power());
                    c.write();
                    break;
                case 6:
                    System.out.println("Enter a number=");
                    num = in.nextInt();
                    System.out.println("Absolute value=" + c.absolute(num));
                    c.write();
                    break;
                case 7:
                    c.input();
                    System.out.println("Modulus of two nos.=" + c.div());
                    c.write();
                    break;
                case 8:
                    c.input();
                    System.out.println("Maximum of two nos.=" + c.findmax());
                    c.write();
                    break;
                case 9:
                    c.input();
                    System.out.println("Minimum of two nos.=" + c.findmin());
                    c.write();
                    break;
                case 10:
                    c.read();
                    break;
                case 11:
                    System.out.println("Enter the operation=");
                    opr=in.next();
                    c.readAll(opr);
                    break;
                case 12:
                    exit(0);
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }while((ch>0)&&(ch<10));
    }
}
