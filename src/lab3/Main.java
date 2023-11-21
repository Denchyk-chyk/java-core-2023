package lab3;

public class Main
{
    public static void main(String[] args)
    {
        Reader reader = new Reader(); //Для зчитування даних з консолі
        Printer writer = Printer.get(); //Для форматованого виводу

        while (true)
        {
            writer.printSpacer(); //Тут і надалі рооздільник з "_"
            Driver[] drivers = new Driver[reader.ReadInteger("Кількість водіїв")]; //Ініціалізація масиву водіїв із кількістю, вибраною користувачем
            writer.printSpacer();

            for (int i = 0; i < drivers.length; i++) //Ввід інформації про водіїв (то через конструктор, то через параметри)
                drivers[i] = i % 2 == 0 ? reader.CreateVyConstructor() : reader.CreateBySetters();

            writer.printSpacer();

            for (var driver : drivers) //Вивід інформації про водіїв (в обоз форматах)
                System.out.println(driver.GetFullInfo() + "\n" + driver.GetShortInfo());
        }
    }
}