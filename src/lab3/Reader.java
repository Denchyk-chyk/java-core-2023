package lab3;

import java.util.Scanner;

class Reader
{
    private Scanner scanner; //Сканер

    public String ReadLine(String name) //Зчитує рядок, виводить повідомлення про те, які дані слід ввести
    {
        System.out.println(name + ": ");

        if (scanner.hasNextLine())
            return scanner.nextLine();

        return null;
    }

    public int ReadInteger(String name)  //Зчитує число, виводить повідомлення про те, які дані слід ввести
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

    public Driver CreateVyConstructor() //Створює екземпляр класу через ввід даних з консолі, використовуючи коструктор із параметрами
    {
        return new Driver(
                ReadLine("Ім'я"),
                ReadLine("Прізвище"),
                ReadInteger("Вік"),
                ReadLine("Модель автомобіля"),
                ReadLine("Марка автомобіля"),
                ReadLine("Колір автомобіля"));
    }

    public Driver CreateBySetters() //Створює екземпляр класу через ввід даних з консолі, напряму використовуючи сетери
    {
        Driver driver = new Driver();

        driver.setFirstName(ReadLine("Ім'я"));
        driver.setLastName(ReadLine("Прізвище"));
        driver.setAge(ReadInteger("Вік"));
        driver.setMark(ReadLine("Модель автомобіля"));
        driver.setModel(ReadLine("Марка автомобіля"));
        driver.setColor(ReadLine("Колір автомобіля"));

        return driver;
    }

    public Reader()
    {
        scanner = new Scanner(System.in);
    }
}