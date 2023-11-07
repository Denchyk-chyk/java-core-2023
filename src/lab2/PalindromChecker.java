package lab2;

import java.util.Scanner;

public class PalindromChecker
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to check");

        if (scanner.hasNextLine())
        {
            //Збереження рядка із видаленням пропусків та зведенням до нижньго регістру
            String input = (scanner.nextLine().replace(" ", "").toLowerCase());

            //Прохождення по всім символам до середини
            for (int i = 0; i < input.length() / 2; i++)
            {
                //Перевірка рівності поточного символа й протилежного (наприклад другого та передостаннього)
                if (input.charAt(i) != input.charAt(input.length() - 1 - i))
                {
                    System.out.println("Not palindrom");
                    return;
                }
            }

            System.out.println("Palindrom");
        }
        else
        {
            System.out.println("No text");
        }
    }
}