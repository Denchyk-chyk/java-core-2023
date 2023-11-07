package lab4;
import java.util.Scanner;

public class Reader //Клас призначений для спрощення вводу даних з консолі
{
    private Scanner scanner; //Сканер

    public String readLine(String name) //Зчитує рядок, виводить повідомлення про те, які дані слід ввести
    {
        System.out.println(name + ": ");

        if (scanner.hasNextLine())
            return scanner.nextLine();

        return null;
    }

    public int readInteger(String name) //Зчитує число, виводить повідомлення про те, які дані слід ввести
    {
        int value = -1;
        System.out.println(name + ": ");

        if (scanner.hasNextInt())
        {
            value = scanner.nextInt();
            scanner.nextLine();
        }

        return value;
    }

    public Reader()
    {
        scanner = new Scanner(System.in);
    }
}