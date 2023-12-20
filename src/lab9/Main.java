package lab9;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Methods methods = new Methods();
        tryCalculate(methods, -1, -2);
        tryCalculate(methods, -1, 2);
        tryCalculate(methods, 0, 0);
        tryCalculate(methods, 1, 2);

        safeInput();
    }

    private static void tryCalculate(Methods methods, float a, float b) //Обробляє помилки в Methods
    {
        try
        {
            methods.check(a, b);
            System.out.println(true);
        }
        catch (Exception e) //Обробка помилки
        {
            System.out.println(e);
        }
    }

    private static void safeInput() //Метод для вводу тексту
    {
        try
        {
            input(); //Ввід тексту
        }
        catch (Exception e)
        {
            System.out.println("Ви ввели порожній рядок"); //Обробка виключення
        }
        finally
        {
            safeInput(); //Рекурсія
        }
    }

    private static void input() throws Exception //Метод для вводу тексту
    {
        System.out.println("Ввеідть рядлк:");

        if (new Scanner(System.in).nextLine().isEmpty()) //Рядок порожній
            throw new Exception("Рядок порожній"); //Помилка
    }
}