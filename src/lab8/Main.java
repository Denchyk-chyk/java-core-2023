package lab8;

import lab3.Printer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        Do(new Scanner(System.in));
    }

    private static void Do(Scanner scanner)
    {
        Printer.get().print(true, true,"1. Сума всіх цифер", "2. Перевірка виразу з дужками", "3. Вихід");

        switch (scanner.nextInt())
        {
            case 1:
                scanner.nextLine();
                System.out.println( "Сума всіх цифер - " + getNumbersSum(Printer.get().printInput("Введіть текст", scanner)));
                break;
            case 2:
                scanner.nextLine();
                System.out.println(checkBrackets(Printer.get().printInput("Введіть вираз", scanner)) ? "Дужки правильні" : "Дужки неправильні");
                break;
            default:
                return;
        }

        Do(scanner);
    }

    private static int getNumbersSum(String line) //Знаходження суми цифер з рядка
    {
        int sum = 0;
        //Реалізація через регулярні вирази
        ///*
        Matcher matcher = Pattern.compile("\\d").matcher(line);

        while (matcher.find())
            sum += Integer.parseInt(matcher.group());
        //*/
        //Реалізація без них
        /*
        for (int i = 0; i < line.length(); i++)
        {
            if (Character.isDigit(line.charAt(i)))
                sum += Integer.parseInt(Character.toString(line.charAt(i)));
        }
        */
        return sum;
    }

    private static boolean checkBrackets(String line) //Перевірка виразу з дужками на правильність
    {
        int sum = 0;
        //Реалізація через регулярні вирази
        ///*
        Matcher open = Pattern.compile(Pattern.quote("(")).matcher(line);
        Matcher close = Pattern.compile(Pattern.quote(")")).matcher(line);

        while (open.find()) sum++;
        while (close.find()) sum--;
        //*/
        //Реалізація без них
        /*
        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) == '(') sum++;
            else if (line.charAt(i) == ')') sum--;
        }
        */
        return sum == 0;
    }
}