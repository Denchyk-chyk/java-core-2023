package lab3;

import java.util.Scanner;

public class Printer //Клас призначений для спрощення форматованого виводу в консоль
{
    private static Printer instance;

    public void printSpacer() //Роздільник із "-" або іншого символа
    {
        printSpacer("-");
    }
    public void printSpacer(String token) //Роздільник із "-" або іншого символа
    {
        System.out.println(token.repeat(80));
    }

    public void print(boolean top, boolean bottom, String... lines) //Виводить рядки із роздільниками
    {
        if (top) printSpacer();
        for (String line : lines)
            System.out.println(line);
        if (bottom) printSpacer();
    }

    public String printInput(String header, Scanner scanner)
    {
        System.out.println(header);
        return scanner.nextLine();
    }

    public <T> void print(String name, T[] array)
    {
        System.out.print(name + ": ");

        for (T element : array)
            System.out.print(element.toString() + " ");

        System.out.print("\n");
        printSpacer();
    }

    private Printer() {}

    public static Printer get()
    {
        if (instance == null)
            instance = new Printer();

        return instance;
    }
}