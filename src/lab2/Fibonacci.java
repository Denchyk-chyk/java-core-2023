package lab2;

import java.util.Scanner;

public class Fibonacci
{
    public  static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");

        int sum = 0, number, current = 1, previous = 0;
        number = scanner.nextInt();

        while (current < number)
        {
            sum += current;
            current += previous;
            previous = current - previous;
        }

        System.out.println("Sum = " + sum);
    }
}