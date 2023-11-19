package lab4;

import lab3.Printer;

public class Main
{
    public static void main(String[] args)
    {
        Reader reader = new Reader(); //Для зчитування даних з консолі2
        Printer writer = Printer.getInstance(); //Для форматованого виводу

        while (true)
        {
            writer.printSpacer(); //Тут і надалі рооздільник з "_"
            int count = reader.readInteger("Кількість водіїв (0 для виходу)"); //Вибів кількості водіїв
            if (count <= 0) return; //Вихід

            Driver[] drivers = new Driver[count]; //Ініціалізація масиву водіїв із кількістю, вибраною користувачем
            writer.printSpacer();

            for (int i = 0; i < count; i++) (drivers[i] = new Driver()).instantiate(); //Ввід інформації про водіїв

            writer.printSpacer();
            print(drivers); //Вивід інформації про водіїв

            //Ствоерння анонімного класу для виводу клькості водіїв та, власне, вивід
            System.out.println("Загальна кількість водіїв: " + (new Driver() { public int getCount() { return count; } }).getCount());
            writer.printSpacer();

            //Попарне порівння всіх водіїв із виводом в консоль матриці
            for (Driver first : drivers)
            {
                for (Driver second : drivers) System.out.print((first.equals(second) ? "1" : "0") + " ");
                System.out.print("\n");
            }
            writer.printSpacer();

            //Порівняння першого та останнього водіїв, а також першого водія та його клона методом compareTo()
            System.out.println(drivers[0].compareTo(drivers[drivers.length-1]));
            System.out.println(drivers[0].compareTo(drivers[0].clone()));
        }
    }

    //Метод для виводу інформації про водіїв (або будь-який інший масив елементів, що реалізують інтерфейс Printable)
    private static void print(Printable[] list)
    {
        for (Printable item : list)
            item.print();
    }
}