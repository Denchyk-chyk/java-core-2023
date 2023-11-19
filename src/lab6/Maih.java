package lab6;

import lab3.Printer;
import lab4.Driver;
import lab4.Month;

import java.util.*;

public class Maih
{
    public static void main(String[] args)
    {

        Driver[] drivers = new Driver[] //Масив з вхідними даними
        {
            new Driver("Іван" ,"Мельник", 2000, 17, Month.DECEMBER, "Toyota", "Raf4", "сірий"),
            new Driver("Сергій" ,"Бойчук", 1988, 12, Month.JUNE, "BMW", "M5", "чорний"),
            new Driver("Андрій" ,"Григорчук", 2008, 22, Month.AUGUST),
            new Driver("Оксана", "Петренко", 1995, 5, Month.AUGUST, "Honda", "Civic", "червоний"),
            new Driver("Анна", "Коваленко", 1990, 20, Month.MARCH, "Mercedes", "CLA", "синій"),
            new Driver("Максим", "Сидоренко", 1985, 10, Month.NOVEMBER, "Audi", "A6", "сріблястий"),
            new Driver("Олександр", "Григоренко", 2002, 8, Month.SEPTEMBER, "Ford", "Focus", "зелений"),
            new Driver("Тетяна", "Павленко", 1998, 15, Month.MAY, "Chevrolet", "Malibu", "білий"),
            new Driver("Дмитро", "Кузьменко", 1983, 25, Month.APRIL, "Hyundai", "Elantra", "сірий"),
            new Driver("Наталія", "Лисенко", 1993, 3, Month.JULY, "Volkswagen", "Golf", "фіолетовий"),
            new Driver("Олег", "Петров", 1980, 12, Month.JANUARY, "Lexus", "RX", "золотий"),
            new Driver("Ірина", "Соколова", 1997, 18, Month.OCTOBER),
            new Driver("Юрій", "Кравчук", 1987, 7, Month.FEBRUARY, "Kia", "Sportage", "сірий"),
            new Driver("Марія", "Коваль", 2005, 11, Month.APRIL, "Nissan", "Altima", "рожевий"),
            new Driver("Артем", "Шевченко", 1991, 22, Month.JANUARY, "Mazda", "CX-5", "сірий"),
            new Driver("Євгенія", "Ткачук", 1989, 9, Month.AUGUST),
            new Driver("Віталій", "Козлов", 2001, 14, Month.MAY, "Jeep", "Grand Cherokee", "бордовий"),
            new Driver("Олена", "Іванова", 1994, 6, Month.JULY, "Suzuki", "Swift", "сірий")
        };

        ArrayDeque<Driver> deque = new ArrayDeque<>(); //Перша колекція

        for (Driver driver : drivers)
            deque.addLast(driver);

        LinkedHashMap<Integer, Driver> map = new LinkedHashMap<Integer, Driver>(); //Друга колекція

        for (Driver driver : drivers)
            map.put(driver.getNumber(), driver);

        //Вивід
        print(deque, "ArrayDeque");
        print(map.values(), "LinkedHashMap");

        //Додавання елементів до ArrayDeque
        //На початок
        deque.addFirst(drivers[0]);
        deque.addFirst(drivers[1]);
        deque.addFirst(drivers[2]);
        //В кінець
        deque.addFirst(drivers[13]);
        deque.addFirst(drivers[14]);
        deque.addFirst(drivers[15]);

        //Вивід
        print(deque, "ArrayDeque з новими елементами");

        //Видалення дублікатів
        for (int i = deque.size(); i > 0; i--)
        {
            Driver driver = deque.removeFirst();

            if (!deque.contains(driver))
                deque.addLast(driver);
        }

        print(deque, "ArrayDeque без дублікатів");

        //Вивід в зворотному порядку
        Printer.getInstance().printHeader("ArrayDeque в зворотному порядку:", false, true);

        for (int i = deque.size(); i > 0; i--)
        {
            Driver driver = deque.removeLast();
            System.out.println(driver);
            deque.addFirst(driver);
        }

        //Вивід в зворотному порядку через Iterator
        Printer.getInstance().printHeader("ArrayDeque в зворотному порядку через iterartor:", true, true);
        Iterator<Driver> iterator = deque.descendingIterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        Printer.getInstance().printSpacer();

        //Зміна атрибутів (Збільшення віку всіх водіїв, що народились до 1990-о року на 7 років)
        for (Driver driver : drivers)
        {
            if (driver.getYear() < 1990)
                driver.setYear(driver.getYear() + 7);
        }

        print(deque, "ArrayDeque");
        print(map.values(), "LinkedHashMap");

        //Додавання елементів до LinkedHashMap
        for (int i = 0; i < 7; i++)
            map.put(map.size() + 1, drivers[map.size() % drivers.length]);

        print(map.values(), "LinkedHashMap з доданими елементами");

        //Видалення дублікатів
        Set<Integer> keys = new HashSet<>(map.keySet());

        for (int i : keys)
        {
            for (int j : keys)
            {
                if (i != j && map.containsKey(i) && map.containsKey(j) && map.get(i).equals(map.get(j)))
                    map.remove(j);
            }
        }

        print(map.values(), "LinkedHashMap без дублікатів");

        //Редагування атрибутів (заміна всіх сірих машин на чорні)
        for (Driver driver : map.values())
        {
            if (driver.getColor().equals("сірий"))
                driver.setColor("чорний");
        }

        print(map.values(), "LinkedHashMap");
    }

    //Метод для виводу колекції
    private static void print(Collection<Driver> drivers, String header)
    {
        Printer.getInstance().printHeader(header + ":", false, true); //Заголовок та розділльник

        //foreach
        for (Driver driver : drivers)
            System.out.println(driver);

        Printer.getInstance().printSpacer(); //Розділльник
    }
}