package ass2;

//  Q10. Write a program to find out the largest between two numbers using a conditional operator.

import java.util.Scanner;

class q10{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int max = num1 > num2 ? num1 : num2;
        System.out.println("The largest between " + num1 + " and " + num2 + " is " + max);
    }
}