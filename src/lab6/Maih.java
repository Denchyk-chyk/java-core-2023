package lab6;

import lab3.*;

import java.util.*;

public class Maih
{
    public static void main(String[] args)
    {

        Driver[] drivers = new Driver[] //Масив з вхідними даними
        {
            new Driver("Іван" ,"Мельник", 27, "Toyota", "Raf4", "сірий"),
            new Driver("Сергій" ,"Бойчук", 34, "BMW", "M5", "чорний"),
            new Driver("Оксана", "Петренко", 52, "Honda", "Civic", "червоний"),
            new Driver("Анна", "Коваленко", 20, "Mercedes", "CLA", "синій"),
            new Driver("Максим", "Сидоренко", 19, "Audi", "A6", "сріблястий"),
            new Driver("Олександр", "Григоренко", 48, "Ford", "Focus", "зелений"),
            new Driver("Тетяна", "Павленко", 25,  "Chevrolet", "Malibu", "білий"),
            new Driver("Дмитро", "Кузьменко", 33, "Hyundai", "Elantra", "сірий"),
            new Driver("Наталія", "Лисенко", 73, "Volkswagen", "Golf", "фіолетовий"),
            new Driver("Олег", "Петров", 62, "Lexus", "RX", "золотий"),
            new Driver("Юрій", "Кравчук", 47, "Kia", "Sportage", "сірий"),
            new Driver("Марія", "Коваль", 31, "Nissan", "Altima", "рожевий"),
            new Driver("Артем", "Шевченко", 24, "Mazda", "CX-5", "сірий"),
            new Driver("Віталій", "Козлов", 24, "Jeep", "Grand Cherokee", "бордовий"),
            new Driver("Олена", "Іванова", 34, "Suzuki", "Swift", "сірий")
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
        Printer.get().print(false, true, "ArrayDeque в зворотному порядку:");

        for (int i = deque.size(); i > 0; i--)
        {
            Driver driver = deque.removeLast();
            System.out.println(driver);
            deque.addFirst(driver);
        }

        //Вивід в зворотному порядку через Iterator
        Printer.get().print(true, true, "ArrayDeque в зворотному порядку через iterartor:");
        Iterator<Driver> iterator = deque.descendingIterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        Printer.get().printSpacer();

        //Зміна атрибутів (Збільшення віку всіх водіїв, що народились до 1990-о року на 7 років)
        for (Driver driver : drivers)
        {
            if (driver.getAge() < 1990)
                driver.setAge(driver.getAge() + 7);
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
        Printer.get().print(false, true, header + ":"); //Заголовок та розділльник

        //foreach
        for (Driver driver : drivers)
            System.out.println(driver);

        Printer.get().printSpacer(); //Розділльник
    }
}