package lab9;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Input();
    }

    private static void Input() //Метод для вводу тексту
    {
        System.out.println("Ввеідть рядлк:");

        try
        {
            if (new Scanner(System.in).nextLine().isEmpty()) //Рядок порожній
                throw new Exception("Рядок порожній"); //Помилка
        }
        catch (Exception excenption) //Обробка помилки
        {
            System.out.println(excenption); //Виведення інформації про помилку
        }

        Input(); //Рекурсія
    }
}