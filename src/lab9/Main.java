package lab9;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Methods methods = new Methods();
        calculate(methods, -1, -2);
        calculate(methods, -1, 2);
        calculate(methods, 0, 2);
        calculate(methods, 1, 2);


        safeInput();
    }

    private static void calculate(Methods methods, float a, float b) //Обробляє помилки в Methods
    {
        try
        {
            System.out.println(methods.add(a, b));
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