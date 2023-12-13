package lab10;

import lab3.Printer;

import java.util.function.Predicate;

public class Main
{
    public static void main(String[] args)
    {
        Subscriber[] subscribers =
        {
            new Subscriber("Іван ", "Петров ", -521),
            new Subscriber("Марія ", "Соколова ", 798),
            new Subscriber("Олександр ", "Коваленко", -256),
            new Subscriber("Ольга ", "Іванова", 463),
            new Subscriber("Сергій", "Мороз", -689),
            new Subscriber("Ангеліна", "Довженко", 142),
            new Subscriber("Микола", "Симоненко", 912),
            new Subscriber("Дмитро", "Ткаченко", -143),
            new Subscriber("Анастасія", "Мельник", 689),
            new Subscriber("Андрій", "Бондаренко", -102),
            new Subscriber("Степан", "Горобець", -760),
        };

        Printer.get().print(true, true, "Ім'я почианється на А");
        Predicate<String> checkName = (name) -> name.charAt(0) == 'А';

        for (Subscriber user : subscribers)
        {
            if (checkName.test(user.getFirstName()))
                System.out.println(user);
        }

        Printer.get().print(true, true, "Баланс не менше 250₴");
        Comparison<Integer> checkBalance = (min, current) -> current >= min;

        for (Subscriber user : subscribers)
        {
            if (checkBalance.execute(250, user.getBalance()))
                System.out.println(user);
        }
    }
}